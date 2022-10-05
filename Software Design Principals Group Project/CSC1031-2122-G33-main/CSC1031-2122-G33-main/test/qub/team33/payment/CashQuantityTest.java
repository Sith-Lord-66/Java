package qub.team33.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qub.team33.payment.type.CashType;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Adam Thompson (40333846)
 */
class CashQuantityTest {

    int newQuantity;
    int quantity;
    CashQuantity cash;

    @BeforeEach
    void setUp() {
        newQuantity = 7;
        quantity = 3;
        cash = new CashQuantity(new Cash(CashType.COIN, 1), quantity);
    }

    @Test
    void getQuantity() {
        int expected = quantity;
        int actual = cash.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    void setQuantity() {
        int expected = newQuantity;

        cash.setQuantity(newQuantity);
        int actual = cash.getQuantity();

        assertEquals(expected, actual);
    }
}
