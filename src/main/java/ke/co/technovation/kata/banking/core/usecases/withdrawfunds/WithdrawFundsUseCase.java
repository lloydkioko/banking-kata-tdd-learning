package ke.co.technovation.kata.banking.core.usecases.withdrawfunds;

import ke.co.technovation.kata.banking.core.common.Guard;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;
import ke.co.technovation.kata.banking.core.usecases.UseCase;
public class WithdrawFundsUseCase implements UseCase<WithdrawFundsRequest, WithdrawFundsResponse> {
    public WithdrawFundsResponse handle(WithdrawFundsRequest request) {
        Guard.AgainstNullOrWhitespace(request.getAccountNumber(), ValidationMessages.ACCOUNT_NUMBER_EMPTY);

        return new WithdrawFundsResponse();
    }
}