package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TwoPairsValue implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        List<Card> sortedCards = hand.getSortedCards();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .filter(cards -> cards.size() > 1).count() > 1;
    }

    @Override
    public int rank() {
        return 7;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return Winner.noWinner();
    }

}
