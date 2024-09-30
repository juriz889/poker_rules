package org.poker.handvalue;

import org.poker.Hand;

public final class FourOfAKind implements HandValue {
    private final OfAKind ofAKind = new OfAKind(Constants.FOUR_OF_KIND_SIZE);

    @Override
    public boolean matches(Hand hand) {
        return ofAKind.matches(hand);
    }

    @Override
    public String handName(Hand hand) {
        return "Four of a Kind of " + ofAKind.getCardsOfAKindFromHand(hand).getFirst().rank();
    }

    @Override
    public int rank() {
        return 50;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return ofAKind.compareTwoHandsOfSameValue(hand1, hand2);
    }
}
