package ke.co.technovation.kata.banking.core.domain.accounts;

public class BankAccount {
    private String accountNumber;
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
