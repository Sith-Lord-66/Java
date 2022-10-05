package qub.team33.setup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qub.team33.payment.type.CurrencyType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetupTests {

    Setup object;

    @BeforeEach
    void setUp() {
        object = new Setup();
    }

    @Test
    void testGetCurrencyType() {
        CurrencyType expected = CurrencyType.STERLING;
        CurrencyType actual = object.getCurrencyType();
        assertEquals(expected, actual);
    }
}
