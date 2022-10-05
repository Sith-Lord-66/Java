package qub.team33;

import qub.team33.setup.Setup;

/**
 * Main class for running the vending machine.
 *
 * @author Adam Thompson (40333846)
 */
public class VendingMachineImpl {

    /**
     * This is the main method that is called to start the vending machine.
     */
    public static void main(String[] args) {
        Setup setup = new Setup();

        VendingMachine machine = new VendingMachine(setup.getCurrencyType());
        machine.start();
    }
}
