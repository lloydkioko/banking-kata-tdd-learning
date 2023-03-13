package ke.co.technovation.kata.banking.core.usecases.openaccount;

import ke.co.technovation.kata.banking.core.common.Guard;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;



public class OpenAccountUseCase {
    public OpenAccountResponse handle(OpenAccountRequest request) {
        Guard.AgainstNullOrWhitespace(request.getFirstName(), ValidationMessages.FIRST_NAME_EMPTY);
        Guard.AgainstNullOrWhitespace(request.getLastName(), ValidationMessages.LAST_NAME_EMPTY);
        Guard.AgainstNegative(request.getInitialBalance(), ValidationMessages.INITIAL_BALANCE_NEGATIVE);

        return new OpenAccountResponse();
    }
}
