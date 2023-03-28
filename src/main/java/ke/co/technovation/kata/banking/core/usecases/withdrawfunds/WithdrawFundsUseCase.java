package ke.co.technovation.kata.banking.core.usecases.withdrawfunds;

import ke.co.technovation.kata.banking.core.usecases.UseCase;
public class WithdrawFundsUseCase implements UseCase<WithdrawFundsRequest, WithdrawFundsResponse> {
    public WithdrawFundsResponse handle(WithdrawFundsRequest request) {
        return new WithdrawFundsResponse();
    }
}
