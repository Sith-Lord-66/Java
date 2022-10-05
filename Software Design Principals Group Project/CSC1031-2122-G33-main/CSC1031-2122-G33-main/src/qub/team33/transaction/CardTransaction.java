package qub.team33.transaction;

import qub.team33.payment.Card;
import qub.team33.product.Product;

import java.util.List;

/**
 * This represents a card transaction.
 *
 * @author Adam Thompson (40333846)
 */
public class CardTransaction extends Transaction<Card> {

    public CardTransaction(TransactionStatus status, Product product, List<Card> card) {
        super(status, product, card);
    }
}
