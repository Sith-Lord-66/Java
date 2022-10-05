package qub.team33.payment;

/**
 * Represents an abstract model of a payment.
 *
 * @author Evan McCullough (40333597)
 */
public abstract class Payment<T> {

    /**
     * Payment type.
     */
    private final T type;

    /**
     * Value of payment.
     */
    private final double value;

    /**
     * Constructor for a payment object that's called when
     * instantiated and will initialise the attributes.
     *
     * @param type  payment type
     * @param value payment value
     */
    public Payment(T type, double value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Get the payment type.
     */
    public T getType() {
        return type;
    }

    /**
     * Get the value of payment.
     */
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return type + "{" + "type=" + type + ", value=" + value + '}';
    }
}
