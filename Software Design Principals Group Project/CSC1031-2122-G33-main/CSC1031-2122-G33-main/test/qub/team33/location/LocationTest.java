package qub.team33.location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Evan McCullough - 40333597
 */
class LocationTest {

    double lat;
    double lon;

    @BeforeEach
    void setUp() {
        lat = 23.232;
        lon = 24.242;
    }

    @Test
    void testGetLongitude() {
        double expected = 24.242;
        double actual = lon;
        assertEquals(expected, actual);
    }

    @Test
    void testGetLatitude() {
        double expected = 23.232;
        double actual = lat;
        assertEquals(expected, actual);
    }
}
