package ke.co.technovation.kata.banking.core.usecases;

import ke.co.technovation.kata.banking.core.domain.entities.BankAccount;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;
import ke.co.technovation.kata.banking.core.usecases.openaccount.OpenAccountRequest;
import ke.co.technovation.kata.banking.core.usecases.openaccount.OpenAccountResponse;
import ke.co.technovation.kata.banking.core.usecases.openaccount.OpenAccountUseCase;
import ke.co.technovation.kata.banking.infra.fake.generators.FakeAccountNumberGenerator;
import ke.co.technovation.kata.banking.infra.fake.repositories.FakeBankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static ke.co.technovation.kata.banking.core.common.Assertions.assertResponse2;
import static ke.co.technovation.kata.banking.core.common.Assertions.assertThrowsValidationException;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenAccountUseCaseTest {

    private FakeAccountNumberGenerator accountNumberGenerator;
    private FakeBankAccountRepository bankAccountRepository;
    private OpenAccountUseCase useCase;

    @BeforeEach
    void init() {
        this.accountNumberGenerator = new FakeAccountNumberGenerator();
        this.bankAccountRepository = new FakeBankAccountRepository();
        this.useCase = new OpenAccountUseCase(accountNumberGenerator, bankAccountRepository);
    }

    @ParameterizedTest
    @MethodSource
    void should_open_account_when_request_is_valid(String firstName, String lastName, int initialBalance, String accountNumber) {
        accountNumberGenerator.add(accountNumber);

        var request = new OpenAccountRequest();
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setInitialBalance(initialBalance);

        var expectedResponse = new OpenAccountResponse();
        expectedResponse.setAccountNumber(accountNumber);

        var expectedBankAccount = new BankAccount(accountNumber);

        assertResponse(request, expectedResponse);

        var retrievedBankAccount = bankAccountRepository.find(accountNumber);
        assertThat(retrievedBankAccount).usingRecursiveComparison().isEqualTo(Optional.of(expectedBankAccount));
    }

    private static Stream<Arguments> should_open_account_when_request_is_valid() {
        return Stream.of(Arguments.of("John", "Smith", 0, "GB41OMQP68570038161775"),
                Arguments.of("Mary", "McDonald", 50, "GB36BMFK75394735916876"));
    }

    @ParameterizedTest
    @MethodSource
    void should_throw_exception_when_first_name_is_empty(String firstName) {
        var request = new OpenAccountRequest();
        request.setFirstName(firstName);

        assertThrows(request, ValidationMessages.FIRST_NAME_EMPTY);
    }

    private static Stream<String> should_throw_exception_when_first_name_is_empty() {
        return Stream.of(null, "", " ", "   ");
    }

    @ParameterizedTest
    @MethodSource
    void should_throw_exception_when_last_name_is_empty(String lastName) {
        var request = new OpenAccountRequest();
        request.setFirstName("John");
        request.setLastName(lastName);

        assertThrows(request, ValidationMessages.LAST_NAME_EMPTY);
    }

    private static Stream<String> should_throw_exception_when_last_name_is_empty() {
        return Stream.of(null, "", " ", "   ");
    }

    @ParameterizedTest
    @MethodSource
    void should_throw_exception_when_initial_balance_is_negative(int balance) {
        var request = new OpenAccountRequest();
        request.setFirstName("John");
        request.setLastName("Smith");
        request.setInitialBalance(balance);

        assertThrows(request, ValidationMessages.INITIAL_BALANCE_NEGATIVE);
    }

    private static Stream<Integer> should_throw_exception_when_initial_balance_is_negative() {
        return Stream.of(-1, -2, -10);
    }

    private void assertResponse(OpenAccountRequest request, OpenAccountResponse expectedResponse) {
        assertResponse2(useCase, request, expectedResponse);
    }

    private void assertThrows(OpenAccountRequest request, String message) {
        assertThrowsValidationException(useCase, request, message);
    }
}