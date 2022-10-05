package qub.team33.transaction;

import qub.team33.product.Product;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Represents an abstract model of a transaction.
 *
 * @author Adam Thompson (40333846)
 */
public abstract class Transaction<T> {

    /**
     * Status of transaction.
     */
    private TransactionStatus status;

    /**
     * Product inside the transaction.
     */
    private Product product;

    /**
     * Payments in the transaction.
     */
    private List<T> payments;

    /**
     * Time the transaction started.
     */
    private LocalDateTime started;

    /**
     * Time the transaction finished.
     */
    private LocalDateTime finished;

    /**
     * Constructor for a transaction object that's called when
     * instantiated and will initialise the attributes.
     *
     * @param status   transaction status
     * @param product  the product being purchased
     * @param payments the payments given
     */
    public Transaction(TransactionStatus status, Product product, List<T> payments) {
        this.status = status;
        this.product = product;
        this.payments = payments;
    }

    /**
     * Get status of transaction.
     */
    public TransactionStatus getStatus() {
        return status;
    }

    /**
     * Set status of transaction.
     *
     * @param status transaction status
     */
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    /**
     * Get the product in the transaction.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the product in the transaction.
     *
     * @param product this is what is being purchased
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the payments given for the transaction.
     */
    public List<T> getPayments() {
        return payments;
    }

    /**
     * Set the payments for the transaction.
     *
     * @param payments transaction payments given
     */
    public void setPayments(List<T> payments) {
        this.payments = payments;
    }

    /**
     * Get the date the transaction was started.
     */
    public LocalDateTime getStarted() {
        return started.truncatedTo(ChronoUnit.SECONDS);
    }

    /**
     * Set the transaction start date.
     *
     * @param date transaction started
     */
    public void setStarted(LocalDateTime date) {
        this.started = date;
    }

    /**
     * Get the date the transaction was finished.
     */
    public LocalDateTime getFinished() {
        return finished.truncatedTo(ChronoUnit.SECONDS);
    }

    /**
     * Set the transaction finished date.
     *
     * @param date transaction finished
     */
    public void setFinished(LocalDateTime date) {
        this.finished = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "status=" + getStatus() +
                ", product=" + getProduct() +
                ", payments=" + getPayments() +
                ", started=" + getStarted() +
                ", finished=" + getFinished() +
                '}';
    }
}
