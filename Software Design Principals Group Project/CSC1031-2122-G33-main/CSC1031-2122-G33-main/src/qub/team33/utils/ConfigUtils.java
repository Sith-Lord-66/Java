package qub.team33.utils;

import java.io.File;

/**
 * This is used to store data that would be commonly used throughout the project
 * reducing data redundancy and errors that may arise if we don't use this.
 *
 * @author Adam Thompson (40333846)
 * @author James Ross (40328644)
 */
public class ConfigUtils {

    public static final String ACCEPTED_CARDS = "Accepted cards:\n- Visa\n- Master";

    public static final String CHOOSE_PAYMENT = "Enter 'A' for 'cash' or 'B' for a 'card' payment: ";

    public static final String CONFIRMATION = "Would you like to continue? (Y | N): ";

    public static final String NO_CHANGE = "Sorry we are currently out of change.";

    public static final String OUT_OF_STOCK = "Sorry this product is out of stock.";

    public static final String NOT_INTEGER = "That is not a valid choice please enter a number.";

    public static final String ERROR = "An error occurred, please report to system administrator.";

    public static final String CUSTOMER_TITLE = "Customer Options";

    public static final String OWNER_TITLE = "Owner Options";

    public static final String OWNER_KEY = "AA";

    public static final String[] OWNER_OPTIONS = new String[]{
            "Restock Vending Machine",
            "Change Item",
            "Deposit Coins",
            "Retrieve Coins",
            "Regulate Temperature",
            "Return to Customer Menu",
            "Update GPS Location",
            "Get Current Location",
            "See Previous Tranasactions",
            "Power Off"
    };

    public static final File COINS_LOCATION = new File("src/qub/team33/Coins.csv");

    public static final File NOTES_LOCATION = new File("src/qub/team33/Notes.csv");

    public static final File INVENTORY_LOCATION = new File("src/qub/team33/Inventory.csv");

    public static final File TRANSACTIONS_LOCATION = new File("src/qub/team33/Transactions.csv");

    public static final String INPUT = "--->";

    public static final String DOLLAR_UNICODE = "\u0024";

    public static final String EURO_UNICODE = "\u20AC";

    public static final String STERLING_UNICODE = "\u00A3";

    public static final String PRODUCT_DATA = "A1,Doritos Extreme Chilli Heatwave,A Packet of Doritos,0.8,10\n" +
            "A2,Hula Hoops BBQ,A Packet of Hula Hoops,0.3,14\n" +
            "A3,Kettle Sweet Chilli,A packet of crisps,1.5,7\n" +
            "A4,Bacon Frazzles,Bacon Flavoured crisps,0.85,15\n" +
            "A5,Hunky Dorys Buffalo,A Packet of crinkly crisps,0.7,4\n" +
            "B1,McVitie's Mini Cheddars,A Packet of cheese,0.75,30\n" +
            "B2,Tayto Salt & Vinegar,A popular choice,0.7,11\n" +
            "B3,Tayto Cheese & Onion, The second popular choice,0.7,20\n" +
            "B4,Walkers Salt & Vinegar,Same flavour different brand,1,14\n" +
            "B5,Walkers Baked Cheese & Onion,The same flavour different brand,1,2\n" +
            "C1,Twirl,A Chocolate bar,0.75,17\n" +
            "C2,Kinder Bueno,A Chocolate bar,1.05,9\n" +
            "C3,Twix,A chocolate bar,1.1,13\n" +
            "C4,Mars Bar,A Chocolate bar,1.2,5\n" +
            "C5,Snickers Bar,A Chocolate bar,1.15,12\n" +
            "D1,Dr Pepper,A peppered DR,1.65,17\n" +
            "D2,Fanta,Orange based drink,1.35,14\n" +
            "D3,Lucozade,Another orange based drink,1.25,8\n" +
            "D4,Red Bull,Diabetes in a can,2.35,15\n" +
            "D5,San Pellegrino, An expensive fruit flavoured drink,1,10\n" +
            "E1,Pepsi,Best canned drink,1.25,11\n" +
            "E2,Pepsi Max,The best canned drink,1.35,5\n" +
            "E3,Diet Coke,A sub-par drink,1.45,2\n" +
            "E4,Coca Cola,A sub-par drink,1.75,7\n" +
            "E5,Gatorade,Nice and refreshing,1.45,19\n";

    public static final String COIN_DATA = "0.05,10\n" +
            "0.10,10\n" +
            "0.20,10\n" +
            "0.50,10\n" +
            "1.00,10\n";

    public static final String NOTE_DATA = "5.00,10\n" +
            "10.00,10\n" +
            "20.00,10\n";

}
