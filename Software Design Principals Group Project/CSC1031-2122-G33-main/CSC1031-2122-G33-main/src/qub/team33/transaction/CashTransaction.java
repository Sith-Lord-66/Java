package qub.team33.transaction;

import qub.team33.payment.Cash;
import qub.team33.product.Product;

import java.util.List;

/**
 * This represents a cash transaction.
 *
 * @author Adam Thompson (40333846)
 */
public class CashTransaction extends Transaction<Cash> {

    public CashTransaction(TransactionStatus status, Product product, List<Cash> cash) {
        super(status, product, cash);
    }
}
