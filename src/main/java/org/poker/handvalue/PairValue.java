package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.List;
import java.util.Map;
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
        Card pairCards1 = getPairCards(hand1);
        Card pairCards2 = getPairCards(hand2);
        if (pairCards1.rankValue() < pairCards2.rankValue()) {
            return Winner.of(hand2);
        } else if (pairCards1.rankValue() > pairCards2.rankValue()) {
            return Winner.of(hand1);
        }
        return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
    }

    private Card getPairCards(Hand hand) {
        List<Card> sortedCards = hand.getSortedCards();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .filter(cards -> cards.size() > 1)
                .findFirst()
                .orElseThrow().getFirst();
    }
}
