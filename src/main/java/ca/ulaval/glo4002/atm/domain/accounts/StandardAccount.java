package ca.ulaval.glo4002.atm.domain.accounts;

import javax.persistence.Entity;

import ca.ulaval.glo4002.atm.domain.accounts.transactions.Receipt;

@Entity
public class StandardAccount extends Account {

    protected StandardAccount() {
        super(); // for hibernate
    }

    public StandardAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public Receipt debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return Receipt.accepted(amount);
        }

        return Receipt.refused(amount);
    }

    public void credit(double amount) {
        balance += amount;
    }

}
