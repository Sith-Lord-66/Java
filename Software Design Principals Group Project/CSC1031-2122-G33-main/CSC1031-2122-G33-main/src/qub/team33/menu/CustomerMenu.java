package qub.team33.menu;

import qub.team33.VendingMachine;
import qub.team33.payment.Card;
import qub.team33.payment.Cash;
import qub.team33.payment.CashQuantity;
import qub.team33.payment.type.CardType;
import qub.team33.payment.type.CashType;
import qub.team33.product.Product;
import qub.team33.transaction.CardTransaction;
import qub.team33.transaction.CashTransaction;
import qub.team33.transaction.TransactionStatus;
import qub.team33.utils.ConfigUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This is used for managing the customer menu of the vending machine.
 *
 * @author Adam Thompson (40333846)
 */
public class CustomerMenu extends Menu {

    /**
     * Internal scanner use.
     */
    private static final Scanner input = new Scanner(System.in);

    /**
     * Constructor for a menu object that's called when instantiated and will
     * initialise the attributes.
     *
     * @param title    menu title
     * @param instance vending machine instance
     */
    public CustomerMenu(String title, VendingMachine instance) {
        super(title, new String[0], instance);
    }

    /**
     * This manages the user selection.
     *
     * @param selection menu selection
     */
    @Override
    public void process(String selection) {
        if (selection.equals(ConfigUtils.OWNER_KEY)) {
            boolean key = true;
            if(proveIdent()) {
                do {
                    OwnerMenu menu = new OwnerMenu(ConfigUtils.OWNER_TITLE, ConfigUtils.OWNER_OPTIONS, getInstance());
                    if (menu.exit() == 1) {
                        key = false;
                    }
                } while (key);
            }
            return;
        }
        select(selection);
    }

    /**
     * This is the main method for managing the user selection.
     *
     * @param selection this is the menu option passed down to us the user selects.
     */
    private void select(String selection) {
        Product product = getInstance().getInventoryController().getProduct(selection);

        if (!product.inStock()) {
            System.out.println(ConfigUtils.OUT_OF_STOCK + "\n");
            return;
        }

        LocalDateTime started = LocalDateTime.now();

        System.out.println("\nProduct: " + product.getName());
        System.out.println("Price: " + getCurrency() + String.format("%.2f", product.getPrice()));

        System.out.print("\n" + ConfigUtils.CHOOSE_PAYMENT);
        String choice;

        do {
            while (!input.hasNext("[AB]")) {
                System.out.print("That isn't a valid option, please enter 'A' for cash or 'B' for a card payment: ");
                input.next();
            }

            choice = input.next();
        } while (!choice.equals("A") && !choice.equals("B"));

        if (choice.equals("A")) {
            handleCash(product, started);
        }

        if (choice.equals("B")) {
            handleCard(product, started);
        }
    }

    /**
     * This will handle cash transactions.
     *
     * @param product this is what the user selected
     * @param started the date the transaction started
     */
    private void handleCash(Product product, LocalDateTime started) {
        CashTransaction transaction = new CashTransaction(TransactionStatus.IN_PROGRESS, product, null);
        transaction.setStarted(started);

        List<Cash> twentyNotes = new ArrayList<>();
        List<Cash> tenNotes = new ArrayList<>();
        List<Cash> fiveNotes = new ArrayList<>();
        List<Cash> oneCoins = new ArrayList<>();
        List<Cash> fiftyCoins = new ArrayList<>();
        List<Cash> twentyCoins = new ArrayList<>();
        List<Cash> tenCoins = new ArrayList<>();
        List<Cash> fiveCoins = new ArrayList<>();

        double total = 0;

        boolean valid = false;
        do {
            System.out.print(getFormat(20, false));
            int TWENTY_NOTES;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "20 notes: ");
                    input.next();
                }
                TWENTY_NOTES = input.nextInt();
            } while (TWENTY_NOTES < 0);

            System.out.print(getFormat(10, false));
            int TEN_NOTES;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "10 notes: ");
                    input.next();
                }
                TEN_NOTES = input.nextInt();
            } while (TEN_NOTES < 0);

            System.out.print(getFormat(5, false));
            int FIVE_NOTES;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "5 notes: ");
                    input.next();
                }
                FIVE_NOTES = input.nextInt();
            } while (FIVE_NOTES < 0);

            System.out.print(getFormat(1, true));
            int ONE_COINS;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "1 coins: ");
                    input.next();
                }
                ONE_COINS = input.nextInt();
            } while (ONE_COINS < 0);

            System.out.print(getFormat(50, true));
            int FIFTY_COINS;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "50 coins: ");
                    input.next();
                }
                FIFTY_COINS = input.nextInt();
            } while (FIFTY_COINS < 0);

            System.out.print(getFormat(20, true));
            int TWENTY_COINS;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "20 coins: ");
                    input.next();
                }
                TWENTY_COINS = input.nextInt();
            } while (TWENTY_COINS < 0);

            System.out.print(getFormat(10, true));
            int TEN_COINS;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "10 coins: ");
                    input.next();
                }
                TEN_COINS = input.nextInt();
            } while (TEN_COINS < 0);

            System.out.print(getFormat(5, true));
            int FIVE_COINS;
            do {
                while (!input.hasNextInt()) {
                    System.out.println(ConfigUtils.NOT_INTEGER);
                    System.out.print("\nEnter " + getCurrency() + "5 coins: ");
                    input.next();
                }
                FIVE_COINS = input.nextInt();
            } while (FIVE_COINS < 0);

            for (int i = 0; i < TWENTY_NOTES; i++) {
                twentyNotes.add(new Cash(CashType.NOTE, 20));
            }

            for (int i = 0; i < TEN_NOTES; i++) {
                tenNotes.add(new Cash(CashType.NOTE, 10));
            }

            for (int i = 0; i < FIVE_NOTES; i++) {
                fiveNotes.add(new Cash(CashType.NOTE, 5));
            }

            for (int i = 0; i < ONE_COINS; i++) {
                oneCoins.add(new Cash(CashType.COIN, 1));
            }

            for (int i = 0; i < FIFTY_COINS; i++) {
                fiftyCoins.add(new Cash(CashType.COIN, 0.5));
            }

            for (int i = 0; i < TWENTY_COINS; i++) {
                twentyCoins.add(new Cash(CashType.COIN, 0.2));
            }

            for (int i = 0; i < TEN_COINS; i++) {
                tenCoins.add(new Cash(CashType.COIN, 0.1));
            }

            for (int i = 0; i < FIVE_COINS; i++) {
                fiveCoins.add(new Cash(CashType.COIN, 0.05));
            }

            for (Cash cash : twentyNotes) {
                total += cash.getValue();
            }

            for (Cash cash : tenNotes) {
                total += cash.getValue();
            }

            for (Cash cash : fiveNotes) {
                total += cash.getValue();
            }

            for (Cash cash : oneCoins) {
                total += cash.getValue();
            }

            for (Cash cash : fiftyCoins) {
                total += cash.getValue();
            }

            for (Cash cash : twentyCoins) {
                total += cash.getValue();
            }

            for (Cash cash : tenCoins) {
                total += cash.getValue();
            }

            for (Cash cash : fiveCoins) {
                total += cash.getValue();
            }

            if (total - product.getPrice() >= 0) {
                valid = true;
                continue;
            }

            System.out.println("You need at least " + getCurrency() + String.format("%.2f", product.getPrice() - total) + " to buy this");
        } while (!valid);

        List<Cash> given = new ArrayList<>();
        given.addAll(twentyNotes);
        given.addAll(tenNotes);
        given.addAll(fiveNotes);
        given.addAll(oneCoins);
        given.addAll(fiftyCoins);
        given.addAll(twentyCoins);
        given.addAll(tenCoins);
        given.addAll(fiveCoins);

        List<CashQuantity> change = getInstance().getCashController().calculateChange(given, product.getPrice());
        boolean hasChange = true;

        for (CashQuantity target : change) {
            if (target.getCash().getType().equals(CashType.COIN) && target.getQuantity() > 0) {
                for (CashQuantity available : getInstance().getCashController().getAvailableCoins()) {
                    if (target.getCash().getValue() == available.getCash().getValue() && available.getQuantity() < target.getQuantity()) {
                        hasChange = false;
                        break;
                    }
                }
            }
        }

        for (CashQuantity target : change) {
            for (CashQuantity available : getInstance().getCashController().getAvailableNotes()) {
                if (target.getCash().getType().equals(CashType.NOTE) && target.getCash().getValue() == available.getCash().getValue() && target.getQuantity() > 0 && available.getQuantity() < target.getQuantity()) {
                    hasChange = false;
                    break;
                }
            }
        }

        if (!hasChange) {
            System.out.println("\n" + ConfigUtils.NO_CHANGE);
            System.out.println("Here is your cash back: " + getCurrency() + String.format("%.2f", total) + "\n");
            return;
        }

        System.out.print("\n" + ConfigUtils.CONFIRMATION);
        String choice;

        do {
            while (!input.hasNext("[YN]")) {
                System.out.println("That isn't a valid option, please enter 'Y' for Yes or 'N' for No.");
                System.out.print("\n" + ConfigUtils.CONFIRMATION);
                input.next();
            }

            choice = input.next();

            if (choice.equals("N")) {
                System.out.println("Here is your cash back: " + getCurrency() + String.format("%.2f", total) + "\n");
                return;
            }
        } while (!choice.equals("Y"));

        List<Cash> payments = new ArrayList<>();
        for (Cash cash : given) {
            if (cash.getValue() > 0) {
                payments.add(cash);
            }
        }

        transaction.setStatus(TransactionStatus.PAID);
        transaction.setPayments(payments);
        transaction.setFinished(LocalDateTime.now());
        getInstance().getTransactionController().process(transaction);

        product.purchase();
        getInstance().getInventoryController().updateProduct(product);

        for (Cash cash : given) {
            getInstance().getCashController().addCash(new CashQuantity(cash, 1));
        }

        for (CashQuantity cash : change) {
            getInstance().getCashController().removeCash(cash);
        }

        for (CashQuantity cash : change) {
            if (cash.getQuantity() > 0) {
                System.out.println("\nChange dispensed");
                break;
            }
        }

        System.out.println("Dispensed: " + product.getName() + "\n");
    }

    /**
     * This will get the format as a string to ask the user regarding currency.
     */
    private String getFormat(int value, boolean isCoin) {
        if (isCoin) {
            switch (getInstance().getCurrency()) {
                case DOLLAR:
                case EURO:
                    if (value == 1) {
                        return "\nEnter " + getCurrency() + value + " coins: ";
                    }

                    return "\nEnter " + value + "c coins: ";
                case STERLING:
                    if (value == 1) {
                        return "\nEnter " + getCurrency() + value + " coins: ";
                    }

                    return "\nEnter " + value + "p coins: ";
            }
        }

        return "\nEnter " + getCurrency() + value + " notes: ";
    }

    /**
     * This will handle card transactions.
     *
     * @param product this is what the user selected
     * @param started the date the transaction started
     */
    private void handleCard(Product product, LocalDateTime started) {
        CardTransaction transaction = new CardTransaction(TransactionStatus.IN_PROGRESS, product, null);
        transaction.setStarted(started);

        System.out.println("\n" + ConfigUtils.ACCEPTED_CARDS);
        System.out.print("\nEnter 'A' for 'Visa' or 'B' for 'Master': ");
        String choice;

        do {
            while (!input.hasNext("[AB]")) {
                System.out.println("\n" + ConfigUtils.ACCEPTED_CARDS);
                System.out.print("\nThat isn't a valid option, please enter 'A' for 'Visa' or 'B' for 'Master': ");
                input.next();
            }

            choice = input.next();
        } while (!choice.equals("A") && !choice.equals("B"));

        System.out.print("\n" + ConfigUtils.CONFIRMATION);

        String option;
        do {
            while (!input.hasNext("[YN]")) {
                System.out.println("That isn't a valid option, please enter 'Y' for Yes or 'N' for No.");
                System.out.print("\n" + ConfigUtils.CONFIRMATION);
                input.next();
            }

            option = input.next();

            if (option.equals("N")) {
                System.out.println("Here is your card back\n");

                transaction.setStatus(TransactionStatus.CANCELLED);
                transaction.setPayments(Collections.singletonList(new Card(choice.equals("A") ? CardType.VISA : CardType.MASTER, 0)));
                transaction.setFinished(LocalDateTime.now());

                getInstance().getTransactionController().process(transaction);
                return;
            }
        } while (!option.equals("Y"));
        int code = 0;
        do {
            System.out.print("\nEnter pin code: ");
            code = input.nextInt();
        }while (!getInstance().getVerification().verifyCode(code));

        transaction.setStatus(TransactionStatus.PAID);
        transaction.setPayments(Collections.singletonList(new Card(choice.equals("A") ? CardType.VISA : CardType.MASTER, product.getPrice())));
        transaction.setFinished(LocalDateTime.now());

        product.purchase();
        getInstance().getInventoryController().updateProduct(product);

        getInstance().getTransactionController().process(transaction);
        System.out.println("Dispensed: " + product.getName() + "\n");
    }
    public boolean proveIdent(){
        System.out.println("Please verify user\nWas verification successful?");
        boolean choice = changeValue();
        return getInstance().getVerification().runVerification(choice);

    }
    public boolean changeValue() {
        //Prompts the user to enter either A or B with validation
        System.out.print("A-Yes, B-No\n" + ConfigUtils.INPUT);
        while (!input.hasNext("[AB]")) {
            input.next();
            System.out.print("That is not a valid choice please enter A or B\n" + ConfigUtils.INPUT);
        }
        String choice = input.next();
        return choice.equals("A");
    }

}
