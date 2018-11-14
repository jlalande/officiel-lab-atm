package ca.ulaval.glo4002.atm.domain.accounts.transactions;

public class Receipt {

    public static Receipt accepted(double amount) {
        return new Receipt(true, amount);
    }

    public static Receipt refused(double amount) {
        return new Receipt(false, amount);
    }

    private boolean accepted;
    private double amount;

    private Receipt(boolean accepted, double amount) {
        this.accepted = accepted;
        this.amount = amount;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public double getAmount() {
        return amount;
    }

}
