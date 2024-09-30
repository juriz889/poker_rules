package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class PairValue implements HandValue {
    @Override
    public boolean matches(Hand hand) {
        return getPairCards(hand).size() == Constants.PAIR_SIZE;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        Card pairCards1 = getPairCards(hand1).getFirst();
        Card pairCards2 = getPairCards(hand2).getFirst();
        Winner winner = HandCardWinnerChecker.checkWinner(new HandCard(hand1, pairCards1), new HandCard(hand2, pairCards2));
        if (winner.getWinner().isEmpty()) {
            return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
        }
        return winner;

    }

    private List<Card> getPairCards(Hand hand) {
        List<Card> sortedCards = hand.getCardsSortedFromHighestToLowest();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .filter(cards -> cards.size() == Constants.PAIR_SIZE)
                .findFirst().orElse(List.of());
    }
}
