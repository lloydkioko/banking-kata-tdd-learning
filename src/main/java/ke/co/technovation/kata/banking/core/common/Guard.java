package ke.co.technovation.kata.banking.core.common;

import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
public class Guard {
    public static void AgainstNullOrWhitespace(String value, String message) {
        if(isNullOrWhitespace(value)) {
            throw new ValidationException(message);
        }
    }

    private static boolean isNullOrWhitespace(String value) {
        return value == null || value.trim().equals("");
    }
}
