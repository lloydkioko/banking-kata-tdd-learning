package ke.co.technovation.kata.banking.core.common;

import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;

import java.util.function.Predicate;

public class Guard {
    public static void AgainstNullOrWhitespace(String value, String message) {
        Against(Validation::isNullOrWhitespace, value, message);
    }

    public static void AgainstNegative(int value, String message) {
        Against(Validation::isNegative, value, message);
    }

    public static void Against(Predicate<String> tester, String value, String message) {
        if(tester.test(value)) {
            throw new ValidationException(message);
        }
    }

    public static void Against(Predicate<Integer> tester, int value, String message) {
        if(tester.test(value)) {
            throw new ValidationException(message);
        }
    }
}
