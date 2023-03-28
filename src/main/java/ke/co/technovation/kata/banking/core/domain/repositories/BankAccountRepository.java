package ke.co.technovation.kata.banking.core.domain.repositories;

//import ke.co.technovation.kata.banking.core.domain.accounts;
import ke.co.technovation.kata.banking.core.domain.accounts.BankAccount;

import java.util.Optional;

public interface BankAccountRepository {

    Optional<BankAccount> find(String accountNumber);

    void add(BankAccount bankAccount);

}
