package ca.ulaval.glo4002.atm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.ulaval.glo4002.atm.application.ServiceLocator;
import ca.ulaval.glo4002.atm.application.banking.BankingService;
import ca.ulaval.glo4002.atm.application.banking.ReceiptDto;

@Path("/accounts/{accountNumber}/withdraw")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WithdrawResource {

    private BankingService bankingService;

    public WithdrawResource() {
        bankingService = ServiceLocator.resolve(BankingService.class);
    }

    public WithdrawResource(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PUT
    public ReceiptDto withdrawMoney(@PathParam("accountNumber") int accountNumber, WithdrawalRequest withdrawalRequest) {
        return bankingService.withdrawMoney(accountNumber, withdrawalRequest);
    }

}
