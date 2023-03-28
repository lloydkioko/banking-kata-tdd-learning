package ke.co.technovation.kata.banking.core.usecases.openaccount;

import ke.co.technovation.kata.banking.core.common.Guard;
import ke.co.technovation.kata.banking.core.domain.entities.BankAccount;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;
import ke.co.technovation.kata.banking.core.domain.generators.AccountNumberGenerator;
import ke.co.technovation.kata.banking.core.domain.repositories.BankAccountRepository;
import ke.co.technovation.kata.banking.core.usecases.UseCase;

public class OpenAccountUseCase implements UseCase<OpenAccountRequest, OpenAccountResponse> {

    private final AccountNumberGenerator accountNumberGenerator;
    private final BankAccountRepository bankAccountRepository;

    public OpenAccountUseCase(AccountNumberGenerator accountNumberGenerator, BankAccountRepository bankAccountRepository) {
        this.accountNumberGenerator = accountNumberGenerator;
        this.bankAccountRepository = bankAccountRepository;
    }

    public OpenAccountResponse handle(OpenAccountRequest request) {
        Guard.AgainstNullOrWhitespace(request.getFirstName(), ValidationMessages.FIRST_NAME_EMPTY);
        Guard.AgainstNullOrWhitespace(request.getLastName(), ValidationMessages.LAST_NAME_EMPTY);
        Guard.AgainstNegative(request.getInitialBalance(), ValidationMessages.INITIAL_BALANCE_NEGATIVE);

        var accountNumber = accountNumberGenerator.next();

        var bankAccount = new BankAccount(accountNumber);
        bankAccountRepository.add(bankAccount);

        return getResponse(accountNumber);
    }

    private OpenAccountResponse getResponse(String accountNumber) {
        var response = new OpenAccountResponse();
        response.setAccountNumber(accountNumber);
        return response;
    }
}
