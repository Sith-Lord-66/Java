package qub.team33.controller;

import qub.team33.payment.Card;
import qub.team33.payment.Cash;
import qub.team33.payment.type.CardType;
import qub.team33.payment.type.CashType;
import qub.team33.product.Product;
import qub.team33.transaction.CardTransaction;
import qub.team33.transaction.CashTransaction;
import qub.team33.transaction.Transaction;
import qub.team33.transaction.TransactionStatus;
import qub.team33.utils.ConfigUtils;
import qub.team33.utils.FileUtils;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a utility class used to manage transactions.
 *
 * @author Adam Thompson (40333846)
 */
public class TransactionController {

    /**
     * This holds all transactions that were cancelled.
     */
    private final List<Transaction<?>> cancelled = new ArrayList<>();

    /**
     * This holds all the transactions that were paid (successful).
     */
    private final List<Transaction<?>> paid = new ArrayList<>();

    public TransactionController() {
        load();
    }

    /**
     * This will read the stored transactions (Transactions.csv) & add them to
     * {@link TransactionController#cancelled} & {@link TransactionController#paid}.
     */
    private void load() {
        try {
            List<String> data = FileUtils.getLines(ConfigUtils.TRANSACTIONS_LOCATION);

            for (String line : data) {
                String[] parts = line.split(",");
                TransactionStatus status = getStatus(parts[0]);
                LocalDateTime started = LocalDateTime.parse(parts[1].trim(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime finished = LocalDateTime.parse(parts[2].trim(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String location = parts[3].trim();
                String name = parts[4].trim();
                String description = parts[5].trim();
                double price = Double.parseDouble(parts[6].trim());
                int quantity = Integer.parseInt(parts[7].trim());
                Product product = new Product(location, name, description, price, quantity);

                int index = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        index++;
                    }

                    if (index >= 8) {
                        index = i + 1;
                        break;
                    }
                }

                String[] money = line.substring(index).split(",");
                List<Cash> cash = new ArrayList<>();
                List<Card> card = new ArrayList<>();

                if (money[0].trim().equalsIgnoreCase("coin") || money[0].trim().equalsIgnoreCase("note")) {
                    for (int i = 0; i < money.length; i++) {
                        String target = money[i].trim();

                        CashType type;
                        switch (target.toLowerCase()) {
                            case "coin":
                                type = CashType.COIN;
                                break;
                            case "note":
                                type = CashType.NOTE;
                                break;
                            default:
                                continue;
                        }

                        double value = Double.parseDouble(money[i + 1].trim());
                        cash.add(new Cash(type, value));
                    }
                }

                if (money[0].trim().equalsIgnoreCase("master") || money[0].trim().equalsIgnoreCase("visa")) {
                    for (int i = 0; i < money.length; i++) {
                        String target = money[i].trim();

                        CardType type;
                        switch (target.toLowerCase()) {
                            case "master":
                                type = CardType.MASTER;
                                break;
                            case "visa":
                                type = CardType.VISA;
                                break;
                            default:
                                continue;
                        }

                        double value = Double.parseDouble(money[i + 1].trim().substring(1));
                        card.add(new Card(type, value));
                    }
                }

                boolean isCash = false;
                boolean isCard = false;

                for (Cash amount : cash) {
                    if (amount != null) {
                        isCash = true;
                    }
                }

                for (Card amount : card) {
                    if (amount != null) {
                        isCard = true;
                    }
                }

                if (isCash) {
                    Transaction<Cash> transaction = new CashTransaction(status, product, cash);
                    transaction.setStarted(started);
                    transaction.setFinished(finished);

                    if (transaction.getStatus().equals(TransactionStatus.CANCELLED)) {
                        cancelled.add(transaction);
                    }

                    if (transaction.getStatus().equals(TransactionStatus.PAID)) {
                        paid.add(transaction);
                    }
                }

                if (isCard) {
                    Transaction<Card> transaction = new CardTransaction(status, product, card);
                    transaction.setStarted(started);
                    transaction.setFinished(finished);

                    if (transaction.getStatus().equals(TransactionStatus.CANCELLED)) {
                        cancelled.add(transaction);
                    }

                    if (transaction.getStatus().equals(TransactionStatus.PAID)) {
                        paid.add(transaction);
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }
    }

    /**
     * Gets the {@link TransactionStatus} equivalent from a string.
     *
     * @param status string to compare
     */
    private TransactionStatus getStatus(String status) {
        switch (status.toLowerCase()) {
            case "cancelled":
                return TransactionStatus.CANCELLED;
            case "paid":
                return TransactionStatus.PAID;
            default:
                return null;
        }
    }

    /**
     * This adds the transaction to the cache & stores it in a file.
     *
     * @param transaction this will be processed
     */
    public void process(Transaction<?> transaction) {
        if (transaction.getStatus().equals(TransactionStatus.CANCELLED)) {
            cancelled.add(transaction);
        }

        if (transaction.getStatus().equals(TransactionStatus.PAID)) {
            paid.add(transaction);
        }

        try {
            Product product = transaction.getProduct();
            String status = transaction.getStatus().toString();
            String started = transaction.getStarted().toString();
            String finished = transaction.getFinished().toString();
            String location = product.getLocation();
            String name = product.getName();
            String description = product.getDescription();
            String price = String.valueOf(product.getPrice());
            String quantity = String.valueOf(product.getQuantity());
            StringBuilder payments = new StringBuilder();

            for (Object payment : transaction.getPayments()) {
                if (payment instanceof Cash) {
                    Cash cash = (Cash) payment;
                    payments
                            .append(cash.getType())
                            .append(",")
                            .append(cash.getValue())
                            .append(",");
                }

                if (payment instanceof Card) {
                    Card card = (Card) payment;
                    payments
                            .append(card.getType())
                            .append(",")
                            .append(card.getValue())
                            .append(",");
                }
            }

            if (payments.charAt(payments.length() - 1) == ',') {
                payments.deleteCharAt(payments.length() - 1);
            }

            String data =
                    status + "," +
                    started + "," +
                    finished + "," +
                    location + "," +
                    name + "," +
                    description + "," +
                    price + "," +
                    quantity + "," +
                    payments;

            FileUtils.addLine(ConfigUtils.TRANSACTIONS_LOCATION, data);
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }
    }

    /**
     * Get all cancelled transactions.
     */
    public List<Transaction<?>> getCancelled() {
        return cancelled;
    }

    /**
     * Get all paid transactions.
     */
    public List<Transaction<?>> getPaid() {
        return paid;
    }
}
