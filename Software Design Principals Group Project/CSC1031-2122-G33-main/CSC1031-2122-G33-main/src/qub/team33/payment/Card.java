package qub.team33.payment;

import qub.team33.payment.type.CardType;

/**
 * This represents a card payment which holds
 * information like card type & value.
 *
 * @author Evan McCullough (40333597)
 */
public class Card extends Payment<CardType> {

    public Card(CardType type, double value) {
        super(type, value);
    }
}
