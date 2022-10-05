package qub.team33.location;

/**
 * This class allows the location to be set and methods to manage the parameters of the constructor
 *
 * @author Evan McCullough - 40333597
 */
public class Location {

    private double latitude; // Variable for the current Latitude coordinate
    private double longitude; // Variable for the current Longitude coordinate

    /**
     * This is the location constructor to set the machines current location
     *
     * @param latitude  - The latitude coordinate
     * @param longitude - The longitude coordinate
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude; // Sets the current lat to the new lat
        this.longitude = longitude; // Sets the current lon to the new lon
    }

    /**
     * This method gets the current latitude value
     *
     * @return the current latitude value
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the current latitude value
     *
     * @param latitude - the current latitude value
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the current longitude value
     *
     * @return - The current longitude value
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the current longitude value
     *
     * @param longitude - the current longitude value
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
