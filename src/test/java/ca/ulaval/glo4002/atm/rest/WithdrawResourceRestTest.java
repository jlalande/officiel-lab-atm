package ca.ulaval.glo4002.atm.rest;

import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.Response.Status;

import org.junit.Test;

public class WithdrawResourceRestTest extends RestTestBase {
    private static final Object INEXISTANT_ACCOUNT = 321231;

    @Test
    public void withdrawMoneyOnAnAccountWithMoneyResultsInAnAcceptedTransaction() {
        WithdrawalRequest request = new WithdrawalRequest(100);

        givenBaseRequest().body(request)
                .when().put("/accounts/{accountNumber}/withdraw", buildPathParams("accountNumber", ACCOUNT_NUMBER_WITH_MONEY))
                .then().body("accepted", equalTo(true))
                .and().body("amount", equalTo((float) request.amount));
    }

    @Test
    public void withdrawMoneyOnAccountThatDoesntExistResultsInA404Error() {
        WithdrawalRequest request = new WithdrawalRequest(100);

        givenBaseRequest().body(request)
                .when().put("/accounts/{accountNumber}/withdraw", buildPathParams("accountNumber", INEXISTANT_ACCOUNT))
                .then().statusCode(Status.NOT_FOUND.getStatusCode());
    }
}
