package ca.ulaval.glo4002.atm.application.banking;

import ca.ulaval.glo4002.atm.domain.accounts.transactions.Receipt;

public class ReceiptAssembler {
    public ReceiptDto toDto(Receipt receipt) {
        return new ReceiptDto(receipt.isAccepted(), receipt.getAmount());
    }
}
