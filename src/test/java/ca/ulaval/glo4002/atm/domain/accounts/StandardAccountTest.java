package ca.ulaval.glo4002.atm.domain.accounts;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4002.atm.domain.accounts.transactions.Receipt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StandardAccountTest {

    private StandardAccount account;

    @Before
    public void setUp() {
        account = new StandardAccount();
    }

    @Test
    public void debitCreatesAnAcceptedReceiptIfAccountHasEnoughFunds() {
        double amountInAccount = 500;
        account.credit(amountInAccount);

        Receipt receipt = account.debit(amountInAccount);

        assertTrue(receipt.isAccepted());
    }

    @Test
    public void debitRemovesTheAmountFromTheAccount() {
        double amountInAccount = 500;
        account.credit(amountInAccount);

        account.debit(amountInAccount);
        Receipt receipt = account.debit(amountInAccount);

        assertFalse(receipt.isAccepted());
    }

    @Test
    public void debitCreatesARefusedReceiptIAccountDoesNotHaveEnoughFunds() {
        double amountInAccount = 500;
        account.credit(amountInAccount);

        Receipt receipt = account.debit(amountInAccount + 1);

        assertFalse(receipt.isAccepted());
    }

}
