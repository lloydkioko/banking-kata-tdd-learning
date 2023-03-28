package ke.co.technovation.kata.banking.core.usecases.openaccount;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ke.co.technovation.kata.banking.core.usecases.Request;
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OpenAccountRequest implements Request<OpenAccountResponse> {

    private String firstName;
    private String lastName;
    private int initialBalance;

}
