package qub.team33.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qub.team33.payment.Cash;
import qub.team33.payment.type.CashType;
import qub.team33.product.Product;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Adam Thompson (40333846)
 */
class CashTransactionTest {

    CashTransaction transaction;
    TransactionStatus newStatus;
    TransactionStatus status;
    Product newProduct;
    Product product;
    List<Cash> newPayments = new ArrayList<>();
    List<Cash> payments = new ArrayList<>();
    LocalDateTime newStarted;
    LocalDateTime started;
    LocalDateTime newFinished;
    LocalDateTime finished;

    @BeforeEach
    void setUp() {
        newStatus = TransactionStatus.CANCELLED;
        status = TransactionStatus.IN_PROGRESS;
        newProduct = new Product("A1", "New Name", "New Description", 0.9, 15);
        product = new Product("A2", "Hunky Dorys", "A Packet of crinkly crisps", 0.7, 8);
        newPayments.add(new Cash(CashType.COIN, 0.5));
        payments.add(new Cash(CashType.NOTE, 20));
        newStarted = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        started = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        newFinished = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        finished = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        transaction = new CashTransaction(status, product, payments);
        transaction.setStarted(started);
        transaction.setFinished(finished);
    }

    @Test
    void getStatus() {
        TransactionStatus expected = status;
        TransactionStatus actual = transaction.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    void setStatus() {
        TransactionStatus expected = newStatus;

        transaction.setStatus(expected);
        TransactionStatus actual = transaction.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    void getProduct() {
        Product expected = product;
        Product actual = transaction.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    void setProduct() {
        Product expected = newProduct;

        transaction.setProduct(expected);
        Product actual = transaction.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    void getPayments() {
        List<Cash> expected = payments;
        List<Cash> actual = transaction.getPayments();

        assertEquals(expected, actual);
    }

    @Test
    void setPayments() {
        List<Cash> expected = newPayments;

        transaction.setPayments(expected);
        List<Cash> actual = transaction.getPayments();

        assertEquals(expected, actual);
    }

    @Test
    void getStarted() {
        LocalDateTime expected = started;
        LocalDateTime actual = transaction.getStarted();

        assertEquals(expected, actual);
    }

    @Test
    void setStarted() {
        LocalDateTime expected = newStarted;

        transaction.setStarted(expected);
        LocalDateTime actual = transaction.getStarted();

        assertEquals(expected, actual);
    }

    @Test
    void getFinished() {
        LocalDateTime expected = finished;
        LocalDateTime actual = transaction.getFinished();

        assertEquals(expected, actual);
    }

    @Test
    void setFinished() {
        LocalDateTime expected = newStarted;

        transaction.setStarted(expected);
        LocalDateTime actual = transaction.getStarted();

        assertEquals(expected, actual);
    }
}
