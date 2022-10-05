package qub.team33.payment;

import qub.team33.payment.type.CashType;

/**
 * This represents a cash payment which holds
 * information like cash type & value.
 *
 * @author Evan McCullough (40333597)
 */
public class Cash extends Payment<CashType> {

    public Cash(CashType type, double value) {
        super(type, value);
    }
}
