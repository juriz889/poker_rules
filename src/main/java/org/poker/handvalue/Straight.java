package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;

import java.util.Iterator;
import java.util.List;

public final class Straight implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        List<Card> sortedCards = hand.getCardsSortedFromHighestToLowest();
        Iterator<Card> iterator = sortedCards.iterator();
        Card lastCard = iterator.next();
        while (iterator.hasNext()) {
            Card currentCard = iterator.next();
            if (hasRankGap(currentCard, lastCard)) {
                return false;
            }
            lastCard = currentCard;
        }
        return true;
    }

    @Override
    public int rank() {
        return 20;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        if (isStraightAceLow(hand1) && isStraightAceLow(hand2)) {
            return Winner.noWinner();
        }
        if (isStraightAceLow(hand1)) {
            return Winner.of(hand2);
        }
        if (isStraightAceLow(hand2)) {
            return Winner.of(hand1);
        }
        return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
    }

    @Override
    public String handName() {
        return "Straight";
    }

    private static boolean isStraightAceLow(Hand hand1) {
        List<Card> cardsSortedFromHighestToLowest = hand1.getCardsSortedFromHighestToLowest();
        return cardsSortedFromHighestToLowest.getFirst().rank() == Rank.ACE && cardsSortedFromHighestToLowest.getLast().rank() == Rank.TWO;
    }

    private static boolean isLastCardsAceAndCurrentFive(Card lastCard, Card currentCard) {
        return lastCard.rank() == Rank.ACE && currentCard.rank() == Rank.FIVE;
    }

    private static boolean hasRankGap(Card currentCard, Card lastCard) {
        return isCurrentCardRankLowerThanLastCardByOne(currentCard, lastCard) && !isLastCardsAceAndCurrentFive(lastCard, currentCard);
    }

    private static boolean isCurrentCardRankLowerThanLastCardByOne(Card currentCard, Card lastCard) {
        return currentCard.rankValue() != lastCard.rankValue() - 1;
    }
}
