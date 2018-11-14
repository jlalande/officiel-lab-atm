package ca.ulaval.glo4002.atm.rest;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4002.atm.application.banking.BankingService;
import ca.ulaval.glo4002.atm.application.banking.ReceiptDto;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;

public class WithdrawResourceTest {

    private static final int ACCOUNT_NUMBER = 123;

    private WithdrawResource withdrawResource;
    private BankingService bankingService;
    private WithdrawalRequest withdrawalRequest;

    @Before
    public void setUp() {
        bankingService = mock(BankingService.class);
        withdrawalRequest = new WithdrawalRequest(100);
        withdrawResource = new WithdrawResource(bankingService);
    }

    @Test
    public void withdrawMoneyReturnsTheResultingReceipt() {
        ReceiptDto expectedReceipt = mock(ReceiptDto.class);
        willReturn(expectedReceipt).given(bankingService).withdrawMoney(ACCOUNT_NUMBER, withdrawalRequest);

        ReceiptDto receipt = withdrawResource.withdrawMoney(ACCOUNT_NUMBER, withdrawalRequest);

        assertSame(expectedReceipt, receipt);
    }

}
