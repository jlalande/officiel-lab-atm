package ca.ulaval.glo4002.atm.application.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptDto {
    @JsonIgnore
    public final boolean accepted;
    @JsonProperty
    public final double amount;

    public ReceiptDto(boolean accepted, double amount) {
        this.accepted = accepted;
        this.amount = amount;
    }
}
