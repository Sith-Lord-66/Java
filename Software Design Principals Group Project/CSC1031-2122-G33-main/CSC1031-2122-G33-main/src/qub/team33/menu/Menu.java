package qub.team33.menu;

import qub.team33.VendingMachine;
import qub.team33.product.Product;

import java.util.List;
import java.util.Scanner;

/**
 * This is the abstract class for creating menus.
 *
 * @author Adam Thompson (40333846)
 */
public abstract class Menu {

    /**
     * Title of menu.
     */
    private final String title;

    /**
     * Options of menu.
     */
    private final String[] options;

    /**
     * Internal scanner use.
     */
    private final Scanner input;

    /**
     * Instance of {@link VendingMachine}.
     */
    private final VendingMachine instance;

    /**
     * Constructor for a menu object that's called when instantiated and will
     * initialise the attributes.
     *
     * @param title    menu title
     * @param options  menu options
     * @param instance vending machine instance
     */
    public Menu(String title, String[] options, VendingMachine instance) {
        this.instance = instance;
        this.title = title;
        this.options = options.length == 0 ? getOptions() : options;
        this.input = new Scanner(System.in);

        process();
    }

    /**
     * This is to get the instance of {@link VendingMachine} to use its methods
     * in any class that extends this class.
     */
    public VendingMachine getInstance() {
        return instance;
    }

    /**
     * Overriding this method in a class that extends this class will allow you to access
     * the parameter which is the menu option the user selects, this method is called
     * each time the user inputs a selection.
     *
     * @param selection menu selection to pass down to classes that override this method.
     */
    public abstract void process(String selection);

    /**
     * This calls {@link Menu#display()} to display title and options and then
     * manage the user selection and validation.
     */
    private void process() {
        display();

        boolean check = true;
        int max = options.length;
        char alpha = ' ';
        int editMax = max;

        if (max <= 5) {
            alpha = 'A';
        } else if (max <= 10) {
            alpha = 'B';
            editMax -= 5;
        } else if (max <= 15) {
            alpha = 'C';
            editMax -= 10;
        } else if (max <= 20) {
            alpha = 'D';
            editMax -= 15;
        } else if (max <= 25) {
            alpha = 'E';
            editMax -= 20;
        }

        char number = Character.forDigit(editMax, 10);
        String position;
        do {
            System.out.print("Please Enter Selection: ");
            position = input.nextLine();
            if (position.length() == 2) {
                char char1 = position.charAt(0);
                char char2 = position.charAt(1);

                if (char1 >= 'A' && char1 <= alpha) {
                    if (alpha != char1 && char2 >= '1' && char2 <= '5') check = false;
                    else if (alpha == char1 && char2 >= '1' && char2 <= number) check = false;
                    else if (char1 == 'A' && char2 == 'A') check = false;
                }
            }
        } while (check);

        process(position);
    }

    /**
     * This will display the menu title and menu options.
     */
    private void display() {
        System.out.println(title);

        for (int i = 0; i < title.length(); i++) {
            System.out.print("*");
        }

        System.out.println();

        int count = 1;
        char alphabet = 'A';

        for (String option : options) {
            if (count > 5) {
                alphabet++;
                count = 1;
            }

            String result = alphabet + "" + count + ". ";
            System.out.println(result + option);
            count++;
        }

        System.out.println();
    }

    /**
     * This will get the product names and create an
     * array of strings to be used for menu options.
     */
    private String[] getOptions() {
        List<Product> products = getInstance().getInventoryController().getProducts();
        String[] options = new String[products.size()];

        for (int i = 0; i < products.size(); i++) {
            options[i] = products.get(i).getName();
        }

        return options;
    }

    /**
     * Get the currency symbol of the vending machine.
     */
    public String getCurrency() {
        return getInstance().getCurrency().toString();
    }
}
