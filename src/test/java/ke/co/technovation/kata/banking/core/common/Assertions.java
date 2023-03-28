package ke.co.technovation.kata.banking.core.common;

import ke.co.technovation.kata.banking.core.domain.exceptions.ValidationException;
import ke.co.technovation.kata.banking.core.usecases.Request;
import ke.co.technovation.kata.banking.core.usecases.UseCase;
import ke.co.technovation.kata.banking.core.usecases.openaccount.OpenAccountRequest;
import ke.co.technovation.kata.banking.core.usecases.openaccount.OpenAccountUseCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Assertions {
    public static <R extends Request<P>, P, U extends UseCase<R, P>> void assertResponse2(U useCase, R request, P expectedResponse) {
        var response = useCase.handle(request);
        assertThat(response).isEqualTo(expectedResponse);
    }
}
