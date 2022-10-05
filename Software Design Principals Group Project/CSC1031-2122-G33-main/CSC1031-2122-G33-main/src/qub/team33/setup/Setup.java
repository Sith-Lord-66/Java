package qub.team33.setup;

import qub.team33.payment.type.CurrencyType;
import qub.team33.utils.ConfigUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author 40328644 - James Ross
 */
public class Setup {

    //Declare files needed
    static File products = ConfigUtils.INVENTORY_LOCATION;
    static File coins = ConfigUtils.COINS_LOCATION;
    static File notes = ConfigUtils.NOTES_LOCATION;
    static File transactions = ConfigUtils.TRANSACTIONS_LOCATION;
    //Declare scanner and currencyType
    private static final Scanner input = new Scanner(System.in);
    private final CurrencyType currencyType;

    /**
     * The constructor for Setup which runs the setupMachine and assigns a currency type
     */
    public Setup() {
        this.currencyType = setupMachine();
    }

    /**
     * This method checks for csv files present in the program, if they are not then it creates them
     * then runs the method pickSettings()
     * It also asks the user what currency they want to use
     * @return CurrencyType currency selected by the user
     */
    public CurrencyType checkCSV() {
        try {
            if (products.createNewFile()) {
                if (notes.createNewFile()) {
                    if (transactions.createNewFile()) {
                        if (coins.createNewFile()) {
                            System.out.println("Creating Required Files\n");
                            System.out.println("Files Successfully created");
                            pickSettings();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("file error");
        }

        int currency = 0;
        CurrencyType cur = CurrencyType.STERLING;
        do {
            System.out.println("Please enter currency type:\n1.Euro\n2.Dollar\n3.Pounds");
            currency = input.nextInt();
            if (currency == 1) cur = CurrencyType.EURO;
            else if (currency == 2) cur = CurrencyType.DOLLAR;

        } while (currency < 1 || currency > 3);

        return cur;
    }

    /**
     * This method runs the checkCSV() method
     * @return CurrencyType selected by the user
     */
    public CurrencyType setupMachine() {
        return checkCSV();
    }

    /**
     * This method displays info to the user and adds a pre-existing backlog of products and cash to the csv files
     */
    public void pickSettings() {
        System.out.println("Quick Setup by using an existing backlog of products, coins and notes");
        writeFile(products, ConfigUtils.PRODUCT_DATA);
        writeFile(coins, ConfigUtils.COIN_DATA);
        writeFile(notes, ConfigUtils.NOTE_DATA);
        System.out.println("\nSetting Payment Methods To Card and Cash");
        System.out.println("\nverification pin is set to 1234");
    }

    /**
     * This method writes a string to a file
     * @param fileName the file being written to
     * @param writeString the string to be used
     */
    public void writeFile(File fileName, String writeString) {
        PrintWriter writer = null;
        //Writes a String to a file stored at location fileName
        try {
            writer = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR 404 - FILE NOT FOUND");
        }
        writer.write(writeString);
        writer.close();
    }

    /**
     * The getter for currency type
     * @return the value of currencyType
     */
    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
