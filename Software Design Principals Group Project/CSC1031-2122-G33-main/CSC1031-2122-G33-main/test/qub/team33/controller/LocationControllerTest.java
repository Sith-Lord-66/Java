package qub.team33.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qub.team33.location.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Evan McCullough - 40333597
 */
class LocationControllerTest {

    double lon;
    double lat;
    Location Loc;
    LocationController man = new LocationController();

    @BeforeEach
    void setUp() {
        lat = 24.242;
        lon = 23.232;
        man.setLocation(Loc = new Location(lat, lon));
    }

    @Test
    void testGetLocation() {
        Location expected = new Location(24.242, 23.232);
        System.out.println(man.getLocation());
    }

    @Test
    void testSetLocation() {
        Location loc = new Location(54.545, 23.899);
        man.setLocation(loc);
        Location newLoc = loc;
        assertEquals(newLoc, loc);
    }
}
