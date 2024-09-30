package org.poker.handvalue;

import org.poker.Hand;

public final class StraightFlush implements HandValue {
    private final Straight straight = new Straight();
    private final Flush flush = new Flush();

    @Override
    public boolean matches(Hand hand) {
        return straight.matches(hand) && flush.matches(hand);
    }

    @Override
    public int rank() {
        return 100;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return straight.compareTwoHandsOfSameValue(hand1, hand2);
    }

}
