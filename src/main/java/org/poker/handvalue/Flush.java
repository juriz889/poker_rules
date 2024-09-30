package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.Iterator;
import java.util.List;

public final class Flush implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        List<Card> sortedCards = hand.getCardsSortedFromHighestToLowest();
        Iterator<Card> iterator = sortedCards.iterator();
        Card lastCard = iterator.next();
        while (iterator.hasNext()) {
            Card currentCard = iterator.next();
            if (currentCard.suit() != lastCard.suit()) {
                return false;
            }
            lastCard = currentCard;
        }
        return true;
    }

    @Override
    public String handName() {
        return "Flush";
    }

    @Override
    public int rank() {
        return 25;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
    }
}