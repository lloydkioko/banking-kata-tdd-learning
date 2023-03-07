package ke.co.technovation.kata.banking.core.usecases;

import ke.co.technovation.kata.banking.core.usecases.withdrawfunds.WithdrawFundsRequest;
import ke.co.technovation.kata.banking.core.usecases.withdrawfunds.WithdrawFundsResponse;
import ke.co.technovation.kata.banking.core.usecases.withdrawfunds.WithdrawFundsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawFundsUseCaseTest {
    private WithdrawFundsUseCase useCase;

    @BeforeEach
    void init() {
        this.useCase = new WithdrawFundsUseCase();
    }

    @Test
    void nothing() {
        var request = new WithdrawFundsRequest();
        var expectedResponse = new WithdrawFundsResponse();

        var response = useCase.handle(request);

        assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
    }
}