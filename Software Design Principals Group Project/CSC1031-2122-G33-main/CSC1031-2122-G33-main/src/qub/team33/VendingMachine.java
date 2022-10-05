package qub.team33;

import qub.team33.controller.*;
import qub.team33.menu.CustomerMenu;
import qub.team33.payment.type.CurrencyType;
import qub.team33.utils.ConfigUtils;
import qub.team33.verification.Verification;

/**
 * This class is the 'main' controller class
 * to manage everything in the machine.
 *
 * @author Adam Thompson (40333846)
 * @author James Ross (40328644)
 */
public class VendingMachine {

    /**
     * Currency of vending machine.
     */
    private final CurrencyType currency;

    /**
     * Instance of cash controller.
     */
    private final CashController cashController;

    /**
     * Instance of inventory controller.
     */
    private final InventoryController inventoryController;

    /**
     * Instance of location controller.
     */
    private final LocationController locationController;

    /**
     * Instance of machine controller.
     */
    private final MachineController machineController;

    /**
     * Instance of transaction controller.
     */
    private final TransactionController transactionController;

    /**
     * Instance of verification controller.
     */
    private final Verification verification;

    /**
     * Initialise the vending machine instance variables.
     */
    public VendingMachine(CurrencyType currency) {
        this.currency = currency;
        cashController = new CashController();
        inventoryController = new InventoryController();
        locationController = new LocationController();
        machineController = new MachineController(35, false);
        transactionController = new TransactionController();
        verification = new Verification(1234);
    }

    /**
     * This will start the vending machine.
     */
    public void start() {
        while (true) {
            new CustomerMenu(ConfigUtils.CUSTOMER_TITLE, this);
        }
    }

    /**
     * Get currency type of vending machine.
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * Get cash controller instance.
     */
    public CashController getCashController() {
        return cashController;
    }

    /**
     * Get inventory controller instance.
     */
    public InventoryController getInventoryController() {
        return inventoryController;
    }

    /**
     * Get location controller instance.
     */
    public LocationController getLocationController() {
        return locationController;
    }

    /**
     * Get machine controller instance.
     */
    public MachineController getMachineController() {
        return machineController;
    }

    /**
     * Get transaction controller instance.
     */
    public TransactionController getTransactionController() {
        return transactionController;
    }

    /**
     * Get verification controller instance.
     */
    public Verification getVerification() {
        return verification;
    }
}
