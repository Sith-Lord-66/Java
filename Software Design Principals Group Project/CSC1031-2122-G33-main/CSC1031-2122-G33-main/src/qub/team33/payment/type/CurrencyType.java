package qub.team33.payment.type;

import qub.team33.utils.ConfigUtils;

/**
 * This contains the different types of
 * currencies the vending machine takes.
 *
 * @author Adam Thompson (40333846)
 */
public enum CurrencyType {
    DOLLAR(ConfigUtils.DOLLAR_UNICODE),
    EURO(ConfigUtils.EURO_UNICODE),
    STERLING(ConfigUtils.STERLING_UNICODE);

    private final String symbol;

    CurrencyType(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
