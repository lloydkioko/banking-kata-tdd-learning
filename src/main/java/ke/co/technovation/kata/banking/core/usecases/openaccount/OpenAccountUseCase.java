package ke.co.technovation.kata.banking.core.usecases.openaccount;

import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationMessages;

public class OpenAccountUseCase {
    public OpenAccountResponse handle(OpenAccountRequest request) {
        if(isNullOrWhitespace(request.getFirstName())) {
            throw new ValidationException(ValidationMessages.FIRST_NAME_EMPTY);
        }
        return new OpenAccountResponse();
    }

    private static boolean isNullOrWhitespace(String value) {
        return value == null || value.trim().equals("");
    }
}
