package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.Iterator;
import java.util.SortedSet;

public final class StraightFlush implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        SortedSet<Card> sortedCards = hand.getSortedCards();
        Iterator<Card> iterator = sortedCards.iterator();
        Card lastCard = iterator.next();
        while (iterator.hasNext()) {
            Card currentCard = iterator.next();
            if (currentCard.rankValue() != lastCard.rankValue() + 1) {
                return false;
            }
            if (currentCard.suit() != lastCard.suit()) {
                return false;
            }
            lastCard = currentCard;
        }
        return true;
    }

    @Override
    public int rank() {
        return 100;
    }
}
