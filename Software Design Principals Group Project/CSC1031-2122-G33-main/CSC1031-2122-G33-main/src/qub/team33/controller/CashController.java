package qub.team33.controller;

import qub.team33.payment.Cash;
import qub.team33.payment.CashQuantity;
import qub.team33.payment.type.CashType;
import qub.team33.utils.ConfigUtils;
import qub.team33.utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a utility class used to manage cash & calculate change.
 *
 * @author Evan McCullough - (40333597)
 */
public class CashController {

    /**
     * This adds cash to the cash storage (Coins.csv & Notes.csv).
     *
     * @param cash object which holds a {@link Cash} object & quantity
     */
    public void addCash(CashQuantity cash) {
        boolean isCoin = cash.getCash().getType().equals(CashType.COIN);

        try {
            List<String> data = FileUtils.getLines(isCoin ? ConfigUtils.COINS_LOCATION : ConfigUtils.NOTES_LOCATION);

            for (int i = 0; i < data.size(); i++) {
                String[] parts = data.get(i).split(",");
                String target = String.format("%.2f", Double.parseDouble(parts[0].trim()));
                String value = String.format("%.2f", cash.getCash().getValue());
                int quantity = Integer.parseInt(parts[1].trim());

                if (value.equals(target)) {
                    data.set(i, value + "," + (quantity + cash.getQuantity()));
                }
            }

            FileUtils.overwrite(isCoin ? ConfigUtils.COINS_LOCATION : ConfigUtils.NOTES_LOCATION, data);
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }
    }

    /**
     * This method removes cash from the cash storage (Coins.csv & Notes.csv).
     *
     * @param cash object which holds a {@link Cash} object & quantity
     */
    public void removeCash(CashQuantity cash) {
        boolean isCoin = cash.getCash().getType().equals(CashType.COIN);

        try {
            List<String> data = FileUtils.getLines(isCoin ? ConfigUtils.COINS_LOCATION : ConfigUtils.NOTES_LOCATION);

            for (int i = 0; i < data.size(); i++) {
                String[] parts = data.get(i).split(",");
                String target = String.format("%.2f", Double.parseDouble(parts[0].trim()));
                String value = String.format("%.2f", cash.getCash().getValue());
                int quantity = Integer.parseInt(parts[1].trim());

                if (value.equals(target)) {
                    data.set(i, value + "," + (quantity - cash.getQuantity()));
                }
            }

            FileUtils.overwrite(isCoin ? ConfigUtils.COINS_LOCATION : ConfigUtils.NOTES_LOCATION, data);
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }
    }

    /**
     * Reads the cash storage for coins & returns a list of {@link CashQuantity}
     * which coins a {@link Cash} object & quantity.
     */
    public List<CashQuantity> getAvailableCoins() {
        List<CashQuantity> result = new ArrayList<>();

        try {
            List<String> data = FileUtils.getLines(ConfigUtils.COINS_LOCATION);

            for (String line : data) {
                String[] parts = line.split(",");
                double value = Double.parseDouble(parts[0].trim());
                int quantity = Integer.parseInt(parts[1].trim());

                Cash cash = new Cash(CashType.COIN, value);
                result.add(new CashQuantity(cash, quantity));
            }
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }

        return result;
    }

    /**
     * Reads the cash storage for notes & returns a list of {@link CashQuantity}
     * which coins a {@link Cash} object & quantity.
     */
    public List<CashQuantity> getAvailableNotes() {
        List<CashQuantity> result = new ArrayList<>();

        try {
            List<String> data = FileUtils.getLines(ConfigUtils.NOTES_LOCATION);

            for (String line : data) {
                String[] parts = line.split(",");
                double value = Double.parseDouble(parts[0].trim());
                int quantity = Integer.parseInt(parts[1].trim());

                Cash cash = new Cash(CashType.NOTE, value);
                result.add(new CashQuantity(cash, quantity));
            }
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }

        return result;
    }

    /**
     * Calculates change to given based on parameters.
     *
     * @param cash  collection of {@link Cash} objects given
     * @param price price of product
     */
    public List<CashQuantity> calculateChange(List<Cash> cash, double price) {
        List<CashQuantity> result = new ArrayList<>();
        double given = 0;

        for (Cash amount : cash) {
            given += amount.getValue();
        }

        int change = (int) Math.ceil((given - price) * 100);

        Cash TWENTY_NOTE = new Cash(CashType.NOTE, 20);
        result.add(new CashQuantity(TWENTY_NOTE, Math.round(change / 2000)));
        change %= 2000;

        Cash TEN_NOTE = new Cash(CashType.NOTE, 10);
        result.add(new CashQuantity(TEN_NOTE, Math.round(change / 1000)));
        change %= 1000;

        Cash FIVE_NOTE = new Cash(CashType.NOTE, 5);
        result.add(new CashQuantity(FIVE_NOTE, Math.round(change / 500)));
        change %= 500;

        Cash ONE_COIN = new Cash(CashType.COIN, 1);
        result.add(new CashQuantity(ONE_COIN, Math.round(change / 100)));
        change %= 100;

        Cash FIFTY_COIN = new Cash(CashType.COIN, 0.5);
        result.add(new CashQuantity(FIFTY_COIN, Math.round(change / 50)));
        change %= 50;

        Cash TWENTY_COIN = new Cash(CashType.COIN, 0.2);
        result.add(new CashQuantity(TWENTY_COIN, Math.round(change / 20)));
        change %= 20;

        Cash TEN_COIN = new Cash(CashType.COIN, 0.1);
        result.add(new CashQuantity(TEN_COIN, Math.round(change / 10)));
        change %= 10;

        Cash FIVE_COIN = new Cash(CashType.COIN, 0.05);
        result.add(new CashQuantity(FIVE_COIN, Math.round(change / 5)));

        return result;
    }
}
