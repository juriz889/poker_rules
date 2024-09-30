package org.poker.handvalue;

import org.poker.Hand;

public final class FullHouse implements HandValue {
    private final ThreeOfAKind threeOfAKind = new ThreeOfAKind();
    private final Pair pair = new Pair();

    @Override
    public boolean matches(Hand hand) {
        return threeOfAKind.matches(hand) && pair.matches(hand);
    }

    @Override
    public int rank() {
        return 30;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        Winner winner = threeOfAKind.compareThreeOfAKind(hand1, hand2);
        if (winner.getWinner().isEmpty()) {
            return pair.compareTwoHandsOfSameValue(hand1, hand2);
        }
        return winner;
    }
}
