package qub.team33.payment.type;

/**
 * This contains the different types of cash
 * payments the vending machine takes.
 *
 * @author Evan McCullough (40333597)
 */
public enum CashType {
    COIN("Coin"),
    NOTE("Note");

    private final String type;

    CashType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
