package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.Iterator;

public final class HighCard implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        return true;
    }


    @Override
    public int rank() {
        return 0;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        Iterator<Card> cardIteratorHand1 = hand1.getSortedCards().iterator();
        Iterator<Card> cardIteratorHand2 = hand2.getSortedCards().iterator();
        while (cardIteratorHand1.hasNext() && cardIteratorHand2.hasNext()) {
            Card card1 = cardIteratorHand1.next();
            Card card2 = cardIteratorHand2.next();
            if (card1.rankValue() < card2.rankValue()) {
                return Winner.of(hand2);
            } else if (card1.rankValue() > card2.rankValue()) {
                return Winner.of(hand1);
            }
        }
        return Winner.noWinner();
    }
}
