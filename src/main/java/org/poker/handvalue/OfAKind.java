package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OfAKind {
    private final int ofAKindSize;

    public OfAKind(int ofAKindSize) {
        this.ofAKindSize = ofAKindSize;
    }


    public boolean matches(Hand hand) {
        return getCardsOfAKindFromHand(hand).size() == ofAKindSize;
    }


    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        Card pairCards1 = getCardsOfAKindFromHand(hand1).getFirst();
        Card pairCards2 = getCardsOfAKindFromHand(hand2).getFirst();
        Winner winner = HandCardWinnerChecker.checkWinner(new HandCard(hand1, pairCards1), new HandCard(hand2, pairCards2));
        if (winner.getWinner().isEmpty()) {
            return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
        }
        return winner;

    }

    public List<Card> getCardsOfAKindFromHand(Hand hand) {
        List<Card> sortedCards = hand.getCardsSortedFromHighestToLowest();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .filter(cards -> cards.size() == ofAKindSize)
                .findFirst().orElse(List.of());
    }
}
