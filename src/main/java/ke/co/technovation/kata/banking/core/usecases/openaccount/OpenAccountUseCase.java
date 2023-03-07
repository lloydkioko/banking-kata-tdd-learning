package ke.co.technovation.kata.banking.core.usecases.openaccount;

import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;

public class OpenAccountUseCase {
    public OpenAccountResponse handle(OpenAccountRequest request) {
        if (request.getFirstName() == null || request.getFirstName().trim().equals("")) {
            throw new ValidationException(ValidationMessages.FIRST_NAME_EMPTY);
        }
        return new OpenAccountResponse();
    }
}
