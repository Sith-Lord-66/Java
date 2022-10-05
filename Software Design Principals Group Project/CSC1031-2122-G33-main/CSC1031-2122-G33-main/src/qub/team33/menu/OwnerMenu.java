package qub.team33.menu;

import qub.team33.VendingMachine;
import qub.team33.controller.MachineController;
import qub.team33.controller.TransactionController;
import qub.team33.location.Location;
import qub.team33.payment.CashQuantity;
import qub.team33.product.Product;
import qub.team33.transaction.Transaction;
import qub.team33.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 40328644 - James Ross
 */
public class OwnerMenu extends Menu {

    //Declaring variables used in processes to determine amount of items and coins
    private static final int ITEM_MAX = 25;
    private static final int COIN_MAX = 5;
    private static int exit = 0;
    private static int itemCount = 0;
    private static int coinCount = 0;

    //Declaring objects used in the owner menu
    private static List<CashQuantity> NoOfCoins = new ArrayList<>(COIN_MAX);
    private static List<CashQuantity> NoOfNotes = new ArrayList<>(3);
    private static List<Product> Items = new ArrayList<>(ITEM_MAX);
    private static Scanner input = new Scanner(System.in);

    /**
     * This is the constructor for the OwnerMenu Object
     * Which inherits variables from the Menu class
     * @param title the title of the menu of type String
     * @param options the options of the menu of type String
     * @param instance the object vendingMachine
     */
    public OwnerMenu(String title, String[] options, VendingMachine instance) {
        super(title, options, instance);
    }

    /**
     * This method runs the desired user functions
     * It runs methods to read csv files containing Items and Coins
     * Then uses the entered String to select and run the desired method
     * @param selection the String entered by the user
     */
    @Override
    public void process(String selection) {
        //Run methods for reading csv files to array of objects
        Items = getInstance().getInventoryController().getProducts();
        NoOfCoins = getInstance().getCashController().getAvailableCoins();
        NoOfNotes = getInstance().getCashController().getAvailableNotes();

        //Uses the Selection parameter to run desired user functions
        switch (selection) {
            case "A1":
                restockMachine();
                break;
            case "A2":
                changeItem();
                break;
            case "A3":
                depositCoins();
                break;
            case "A4":
                retrieveCoins();
                break;
            case "A5":
                regTemperature();
                break;
            case "B1":
                returnToCustomer();
                break;
            case "B2":
                updateLocation();
                break;
            case "B3":
                currentLocation();
                break;
            case "B4":
                getTransactions();
                break;
            case "B5":
                powerOff();
                break;
            default:
                System.out.println("Option " + selection + " is invalid.");
                break;
        }
    }

    /**
     * This method allows the user to restock the machine
     * It opens the machine door and once restocked and the door is closed
     * It then scans the machine for new items
     * Then assigns the value of quantity for each Item in Inventory.csv
     * In this case quantity is assigned to 20
     */
    public void restockMachine() {
        MachineController machine = getInstance().getMachineController();
        //Checks if the user wishes to continue and then opens the machine door
        System.out.println("Restocking Vending Machine");
        if (changeValue()) machine.setOpenDoor(true);
        else System.out.println("No coins have been deposited.\n");

        //If the door is open then this section will execute
        if (machine.isOpenDoor()) {

            System.out.println("Controller: Door Is Now Open");
            System.out.print("Please now refill the machine " +
                    "- when finished close door and enter A\n" + ConfigUtils.INPUT);

            //Prompts the user to enter a String "A" and will repeat until correct input
            while (!input.hasNext("[A]")) {
                input.next();
                System.out.print("That is not a valid choice please enter A\n" + ConfigUtils.INPUT);
            }
            String finished = input.next();

            //Once "A" is entered the door is shut
            if (finished.equals("A")) machine.setOpenDoor(false);
            //If the door is shut this section will execute
            if (!machine.isOpenDoor()) {
                System.out.println("Controller: Door Is Now Closed");
                System.out.println("Controller: Scanning to calculate quantity");
                //Updates the Array of Products with new quantities
                int count = 0;
                do {
                    Items.get(count).setQuantity(20);
                    count++;
                } while (count < ITEM_MAX);
                //Writes these changes to the csv file Inventory.csv
                for(Product prod: Items){
                    getInstance().getInventoryController().updateProduct(prod);
                }
                System.out.println("Stock has been Successfully Updated\n");
            }
        }
        input.nextLine();
    }

    /**
     * This method allows the user to change an item name, price and quantity
     * It prompts the user to enter a location
     * Then checks if item is already present
     * Then prompts the user to enter new values for each
     * It finally writes these new values to the Inventory.csv file
     */
    public void changeItem() {
        System.out.println("Changing An Item");

        //Prompts the user to enter an item location and then displays this item
        int location = getItemLocation();
        System.out.println(Items.get(location));

        //Checks if the user wishes to continue and executes if so
        if (changeValue()) {
            //Prompts the user to enter a new value for name
            String newName;
            input.nextLine();
            do {
                System.out.print("Please enter the new name for the item:\n" + ConfigUtils.INPUT);
                newName = getLine();

                //Checks that the desired name does not match any currently in the machine
                boolean invalid = false;
                int index = 0;
                do {
                    if (newName.equals(Items.get(index).getName())) {
                        invalid = true;
                        break;
                    }
                    index++;
                } while (index < ITEM_MAX);

                //If item is already present then it will repeat the code to prompt the user for a new input
                if (invalid) System.out.println("This item is already in the machine");
                else break;

            } while (true);

            System.out.print("Please enter the new description for the item:\n" + ConfigUtils.INPUT);
             String newDesc = getLine();

            //Prompts the user to enter a new value for price
            System.out.print("Please enter the new price for the item:\n" + ConfigUtils.INPUT);
            double newPrice = getDouble();

            //Prompts the user to enter a new value for quantity and ensures it is between 0-20
            int newQuantity;
            do {
                System.out.print("Please enter the new quantity for the item:\n" + ConfigUtils.INPUT);
                newQuantity = getInt();
            } while (newQuantity > 20 || newQuantity < 0);
            
            /**
             * Writes these changes to the array Items at the location of the item
             * Then writes these changes to the file Inventory.csv
             */
            Items.get(location).setPrice(newPrice);
            Items.get(location).setName(newName);
            Items.get(location).setDescription(newDesc);
            Items.get(location).setQuantity(newQuantity);
            for (Product product : Items){
                getInstance().getInventoryController().updateProduct(product);
            }

            System.out.println("Item has been successfully changed to:\n" + Items.get(location));
        } else System.out.println("Item has not been changed.\n");
        input.nextLine();
    }

    /**
     * This method allows the user to add coins to the machine
     * It prompts the user to enter how many of each coin has been added
     * Then it adds this to the quantity stored in the csv file
     */
    public void depositCoins() {
        System.out.println("Depositing Coins/Notes");

        //Executes this section if the user wishes to continue
        if (changeValue()) {
            //Prompts the user to enter quantities of each coin being entered and validates this
            System.out.print("Please enter the amount of each coin/note being added\n"+ getCurrency() +"0.05: ");
            int fives = getInt();

            System.out.print( getCurrency() +"0.10: ");
            int tens = getInt();
            System.out.print(getCurrency() +"0.20: ");
            int twenties = getInt();
            System.out.print(getCurrency() +"0.50: ");
            int fifties = getInt();
            System.out.print(getCurrency() +"1.00: ");
            int pounds = getInt();
            System.out.print(getCurrency() +"5.00: ");
            int noteFive = getInt();
            System.out.print(getCurrency() +"10.00: ");
            int noteTen = getInt();
            System.out.print(getCurrency() +"20.00: ");
            int noteTwenty = getInt();

            /*Adds the amount of each coin being added to the amount already present
            And writes this to the array of Coins
            */
            NoOfCoins.get(0).setQuantity(fives);
            NoOfCoins.get(1).setQuantity(tens);
            NoOfCoins.get(2).setQuantity(twenties);
            NoOfCoins.get(3).setQuantity(fifties);
            NoOfCoins.get(4).setQuantity(pounds);
            NoOfNotes.get(0).setQuantity(noteFive);
            NoOfNotes.get(1).setQuantity(noteTen);
            NoOfNotes.get(2).setQuantity(noteTwenty);

            //Writes these changes to the csv file Coins.csv
            for(CashQuantity cash: NoOfCoins) {
                getInstance().getCashController().addCash(cash);
            }
            for(CashQuantity cash: NoOfNotes) {
                getInstance().getCashController().addCash(cash);
            }
            System.out.println("Cash successfully added to the machine");
        } else System.out.println("Cash hasn't been deposited.\n");
        input.nextLine();
    }

    /**
     * This method allows the user to remove coins to the machine
     * It prompts the user to enter how many of each coin has been removed
     * Then it removes this from the quantity stored in the csv file
     */
    public void retrieveCoins() {
        System.out.println("Retrieving Coins/Notes");

        //Executes this section if the user wishes to continue
        if (changeValue()) {
            //Prompts the user to enter quantities of each coin being removed and validates this
            System.out.print("Please enter the amount of each coin/note being retrieved\n"+ getCurrency()+ "0.05: ");
            int fives = getInt();
            System.out.print(getCurrency() +"0.10: ");
            int tens = getInt();
            System.out.print(getCurrency() +"0.20: ");
            int twenties = getInt();
            System.out.print(getCurrency() +"0.50: ");
            int fifties = getInt();
            System.out.print(getCurrency() +"1.00: ");
            int pounds = getInt();
            System.out.print(getCurrency() +"5.00: ");
            int noteFive = getInt();
            System.out.print(getCurrency() +"10.00: ");
            int noteTen = getInt();
            System.out.print(getCurrency() +"20.00: ");
            int noteTwenty = getInt();

              /*Subtracts the amount of each coin being removed to the amount already present
            And writes this to the array of Coins
            */
            NoOfCoins.get(0).setQuantity(fives);
            NoOfCoins.get(1).setQuantity(tens);
            NoOfCoins.get(2).setQuantity(twenties);
            NoOfCoins.get(3).setQuantity(fifties);
            NoOfCoins.get(4).setQuantity(pounds);
            NoOfNotes.get(0).setQuantity(noteFive);
            NoOfNotes.get(1).setQuantity(noteTen);
            NoOfNotes.get(2).setQuantity(noteTwenty);

            //Writes these changes to the csv file Coins.csv
            for(CashQuantity cash: NoOfCoins){
                getInstance().getCashController().removeCash(cash);
            }
            for(CashQuantity cash: NoOfNotes) {
                getInstance().getCashController().addCash(cash);
            }
            System.out.println("Cash successfully retrieved from the machine");
            System.out.println("Controller: dispense cash from machine");

        } else System.out.println("Cash hasn't been retrieved.\n");
        input.nextLine();
    }

    /**
     * This method allows the user to regulate the temperature of the machine
     * It prompts the user to enter a new temperature
     * Then changes the value stored in the Controller object
     */
    public void regTemperature() {
        MachineController machine = getInstance().getMachineController();
        //Displays current temp of the machine
        System.out.println("The current temperature of the vending machine is: " +
                machine.getTemperature() + "°C");

        //executes if the user wishes to continue
        if (changeValue()) {
            //prompts the user to enter a new temp between 1-50 and validates it
            int temp;
            do {
                System.out.print("Please enter the new temperature between 1-50\n" + ConfigUtils.INPUT);
                temp = getInt();
            } while (temp < 0 || temp >= 50);

            //Sets the new temp stored in the Controller object to the desired value and prints this
            machine.setTemperature(temp);
            System.out.println("The New temperature has been set to: " +
                    machine.getTemperature() + "°C\n");
        } else System.out.println("The temperature has not been changed.\n");
        input.nextLine();
    }

    /**
     * This method allows the user to return to the customer menu
     */
    public void returnToCustomer() {
        //executes if the user wishes to continue
        if (changeValue()) {
            //Returns the user to the customer menu
            System.out.println("Exiting Owner Mode");
            exit = 1;
            new CustomerMenu(ConfigUtils.CUSTOMER_TITLE, getInstance());
        }
    }

    /**
     * This method allows the user to turn off the Vending machine
     */
    public void powerOff() {
        //exits the program (Power off)
        System.out.println("\nPowering Off System...");
        System.exit(0);
    }

    /**
     * This method prompts the user to enter a location
     * Then determines the integer value of the location
     * Later used to change a certain Product's contents
     * @return The location of the Product in integer form
     */
    public int getItemLocation() {
        boolean check = true;
        String position;
        //Prompts the user to enter a location with chars between A-E and then 1-5 with validation
        do {
            System.out.print("\nPlease enter an item location\n" + ConfigUtils.INPUT);
            position = input.nextLine();
            if (position.length() == 2) {
                if (position.charAt(0) >= 'A' && position.charAt(0) <= 'E') {
                    if (position.charAt(1) >= '1' && position.charAt(1) <= '5') {
                        check = false;
                    }
                }
            }
        } while (check);

        //Assigns an integer weighting to each of the letters
        int location = -1;
        switch (position.charAt(0)) {
            case 'B':
                location += 5;
                break;
            case 'C':
                location += 10;
                break;
            case 'D':
                location += 15;
                break;
            case 'E':
                location += 20;
                break;
            default:
                break;
        }
        //Adds the integer entered to the letter weighting
        switch (position.charAt(1)) {
            case '1':
                location += 1;
                break;
            case '2':
                location += 2;
                break;
            case '3':
                location += 3;
                break;
            case '4':
                location += 4;
                break;
            case '5':
                location += 5;
                break;
            default:
                break;
        }
        return location;
    }

    /**
     * This method prompts the user to enter if this wish to continue or go back
     * @return Boolean value where true is continue and false is go back
     */
    public boolean changeValue() {
        //Prompts the user to enter either A or B with validation
        System.out.print("\nWould you like to continue? A-Yes, B-No\n" + ConfigUtils.INPUT);
        while (!input.hasNext("[AB]")) {
            input.next();
            System.out.print("That is not a valid choice please enter A or B\n" + ConfigUtils.INPUT);
        }
        String choice = input.next();
        return choice.equals("A");
    }

    /**
     * This method prompts the user to enter an integer number
     * Uses validation to confirm the entry is of type int
     * @return The integer number entered
     */
    public int getInt() {
        //Prompts the user to enter an integer with validation
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("That is not a valid choice please enter a number\n" + ConfigUtils.INPUT);
        }
        return input.nextInt();
    }

    /**
     * This method prompts the user to enter a double number
     * Uses validation to confirm the entry is of type double
     * @return The double number entered
     */
    public double getDouble() {
        //Prompts the user to enter a double with validation
        while (!input.hasNextDouble()) {
            input.next();
            System.out.print("That is not a valid choice please enter a number\n" + ConfigUtils.INPUT);
        }
        return input.nextDouble();
    }

    /**
     * This method prompts the user to enter a String
     * Uses validation to confirm the entry is of type String
     * @return The String entered
     */
    public String getLine() {
        //Prompts the user to enter a String with validation
        while (!input.hasNextLine()) {
            input.next();
            System.out.print("That is not a valid choice\n" + ConfigUtils.INPUT);
        }
        return input.nextLine();
    }

    /**
     * This method is used in VendingMachine
     * To determine when a user wants to return to the Customer Menu
     * @return The value of the int exit
     */
    public int exit() {
        return exit;
    }

    /**
     * This method allows the user to update the machines current location
     * @author Evan McCullough - 40333597
     */
    public void updateLocation(){
        System.out.println("Updating Vending Machine Location");
        System.out.println("");
        System.out.println("Enter new latitude value ");
        double lat = input.nextDouble();
        input.nextLine();
        System.out.println("Enter new longitude value ");
        double lon = input.nextDouble();
        input.nextLine();
        getInstance().getLocationController().setLocation(new Location(lat, lon));
        System.out.println("Location updated");
    }

    /** This method gets the current machine location
     * @author Evan McCullough - 40333597
     */
    public void currentLocation(){
        System.out.println("Current Location of Machine");
        System.out.println("**");
        System.out.println(getInstance().getLocationController().getLocation());
        System.out.println();
    }

    public void getTransactions() {
        TransactionController transactions = getInstance().getTransactionController();
        System.out.print("Would you like to view paid or cancelled transactions?\n" + ConfigUtils.INPUT);
        String choice;
        do {
            choice = getLine();
        } while (!choice.equals("paid") && !choice.equals("cancelled"));
        if (choice.equals("paid")) {
            System.out.println("\nPaid transactions\n");
            for (Transaction<?> paid : transactions.getPaid()) {
                System.out.println(paid);
            }
            System.out.println();
        }
        if (choice.equals("cancelled")) {
            System.out.println("\nCancelled Transactions\n");
            for (Transaction<?> cancelled : transactions.getCancelled()) {
                System.out.println(cancelled);
            }
            System.out.println();
        }
    }
}
