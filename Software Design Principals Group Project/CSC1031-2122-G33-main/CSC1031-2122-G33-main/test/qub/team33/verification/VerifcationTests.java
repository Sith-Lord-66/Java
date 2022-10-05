package qub.team33.verification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerifcationTests {

    Verification object;

    @BeforeEach
    void setUp() {
        object = new Verification(1234);
    }

    @Test
    void testRunVerification() {
        boolean success = true;
        boolean expected = true;
        boolean actual = object.runVerification(success);
        assertEquals(expected, actual);
    }

    @Test
    void testVerifyCode() {
        int code = 1234;
        int enteredCode = 1234;
        boolean expected = true;
        boolean actual = object.verifyCode(enteredCode);
        assertEquals(expected, actual);
    }
}
