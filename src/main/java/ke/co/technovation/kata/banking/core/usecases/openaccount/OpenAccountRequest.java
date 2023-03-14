package ke.co.technovation.kata.banking.core.usecases.openaccount;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OpenAccountRequest {

    private String firstName;
    private String lastName;
    private int initialBalance;

}
