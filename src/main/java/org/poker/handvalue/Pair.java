package org.poker.handvalue;

import org.poker.Hand;

public final class Pair implements HandValue {
    private final OfAKind ofAKind = new OfAKind(Constants.PAIR_SIZE);

    @Override
    public boolean matches(Hand hand) {
        return ofAKind.matches(hand);
    }

    @Override
    public String handName(Hand hand) {
        return "Pair of " + ofAKind.getCardsOfAKindFromHand(hand).getFirst().rank();
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return ofAKind.compareTwoHandsOfSameValue(hand1, hand2);
    }

}
