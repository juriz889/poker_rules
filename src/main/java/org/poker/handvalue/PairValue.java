package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;

public final class PairValue implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        List<Card> sortedCards = hand.getSortedCards();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .anyMatch(cards -> cards.size() > 1);
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return Winner.noWinner();
    }
}
