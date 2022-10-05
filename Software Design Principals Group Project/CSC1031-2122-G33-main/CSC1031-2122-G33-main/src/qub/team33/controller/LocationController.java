package qub.team33.controller;

import qub.team33.location.Location;

/**
 * This class manages the location of the machine
 * & allows the user to update its location.
 *
 * @author Evan McCullough - 40333597
 */
public class LocationController {

    /**
     * Sets a base location for the machine.
     */
    private Location location = new Location(20.444665, 20.694201);

    /**
     * This constructor is empty to allow us
     * to instantiate without parameters.
     */
    public LocationController() {
        // Empty
    }

    /**
     * Get the location of the vending machine.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location of the vending machine.
     *
     * @param location the location of the machine
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationController{" + "location=" + location + '}';
    }
}
