package qub.team33.transaction;

/**
 * This contains the different status types of
 * transactions in the vending machine.
 *
 * @author Adam Thompson (40333846)
 */
public enum TransactionStatus {
    CANCELLED("Cancelled"),
    IN_PROGRESS("In Progress"),
    PAID("Paid");

    private final String value;

    TransactionStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
