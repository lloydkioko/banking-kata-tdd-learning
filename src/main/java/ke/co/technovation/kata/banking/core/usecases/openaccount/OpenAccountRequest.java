package ke.co.technovation.kata.banking.core.usecases.openaccount;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OpenAccountRequest {

    private String firstName;
    private String lastName;
}
