package qub.team33.payment;

/**
 * This holds a cash object & the quantity of them.
 *
 * @author Adam Thompson (40333846)
 */
public class CashQuantity {

    /**
     * This is the type of cash.
     */
    private final Cash cash;

    /**
     * Quantity of cash objects.
     */
    private int quantity;

    /**
     * Constructor for a cash quantity object that's called when
     * instantiated and will initialise the attributes.
     *
     * @param cash     to store
     * @param quantity cash quantity
     */
    public CashQuantity(Cash cash, int quantity) {
        this.cash = cash;
        this.quantity = quantity;
    }

    /**
     * Get the cash object being stored.
     */
    public Cash getCash() {
        return cash;
    }

    /**
     * Get quantity of {@link Cash} objects.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of {@link Cash} objects.
     *
     * @param quantity amount to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CashQuantity{" + "cash=" + cash + ", quantity=" + quantity + '}';
    }
}
