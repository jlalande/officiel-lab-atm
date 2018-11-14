package ca.ulaval.glo4002.atm.application.banking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawalRequest {

    public final int amount;

    @JsonCreator
    public WithdrawalRequest(@JsonProperty("amount") int amount) {
        this.amount = amount;
    }

}
