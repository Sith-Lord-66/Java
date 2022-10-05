package qub.team33.payment.type;

/**
 * This contains the different types of card
 * payments the vending machine takes.
 *
 * @author Evan McCullough (40333597)
 */
public enum CardType {
    MASTER("Master"),
    VISA("Visa");

    private final String type;

    CardType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
