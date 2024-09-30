package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.Iterator;
import java.util.List;

public final class StraightFlush implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        List<Card> sortedCards = hand.getSortedCards();
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

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        Card hand1LastCard = hand1.getSortedCards().getLast();
        Card hand2LastCard = hand2.getSortedCards().getLast();
        return HandCardWinnerChecker.checkWinner(new HandCard(hand1, hand1LastCard), new HandCard(hand2, hand2LastCard));
    }

}
