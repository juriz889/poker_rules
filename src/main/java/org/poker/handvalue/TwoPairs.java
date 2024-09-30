package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TwoPairs implements HandValue {

    @Override
    public boolean matches(Hand hand) {
        return getPairCards(hand).size() == Constants.TWO_PAIRS;
    }

    @Override
    public int rank() {
        return 7;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        List<Card> pairCards1 = getPairCards(hand1);
        List<Card> pairCards2 = getPairCards(hand2);
        Winner winner = HandCardWinnerChecker.checkWinner(new HandCard(hand1, pairCards1.getLast()), new HandCard(hand2, pairCards2.getLast()));
        if (winner.getWinner().isEmpty()) {
            winner = HandCardWinnerChecker.checkWinner(new HandCard(hand1, pairCards1.getFirst()), new HandCard(hand2, pairCards2.getFirst()));
        }
        if (winner.getWinner().isEmpty()) {
            return new HighCard().compareTwoHandsOfSameValue(hand1, hand2);
        }
        return winner;

    }

    @Override
    public String handName(Hand hand) {
        List<Rank> list = getPairCards(hand).stream().map(Card::rank).toList();
        return "Two Pairs of " + list.stream().map(Rank::toString).collect(Collectors.joining(" and "));
    }

    private List<Card> getPairCards(Hand hand) {
        List<Card> sortedCards = hand.getCardsSortedFromHighestToLowest();
        Map<Integer, List<Card>> cardsByRank = sortedCards.stream()
                .collect(Collectors.groupingBy(Card::rankValue));
        return cardsByRank.values().stream()
                .filter(cards -> cards.size() == Constants.PAIR_SIZE)
                .flatMap(cardsList -> Stream.of(cardsList.getFirst()))
                .collect(Collectors.toList());
    }

}
