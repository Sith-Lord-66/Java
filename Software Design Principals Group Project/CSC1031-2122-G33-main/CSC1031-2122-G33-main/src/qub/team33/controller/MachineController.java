package qub.team33.controller;

/**
 * @author 40328644 - James Ross
 */
public class MachineController {
    private int temperature;
    private boolean openDoor;

    /**
     * Constructor for the Controller Object
     *
     * @param temperature The temp of the machine of type int
     * @param openDoor    Boolean value of whether the door is open or not
     */
    public MachineController(int temperature, boolean openDoor) {
        this.temperature = temperature;
        this.openDoor = openDoor;
    }

    /**
     * Getter for the variable temperature
     *
     * @return The temperature of type int
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Setter for the variable temperature
     *
     * @param temperature The temperature of type int
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Getter for the variable isDoor
     *
     * @return The true or false value of openDoor
     */
    public boolean isOpenDoor() {
        return openDoor;
    }

    /**
     * Setter for the variable openDoor
     *
     * @param openDoor The true or false value of openDoor
     */
    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }
}
