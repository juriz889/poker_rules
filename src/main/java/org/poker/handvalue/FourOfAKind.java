package org.poker.handvalue;

import org.poker.Hand;

public final class FourOfAKind implements HandValue {

    @Override
    public boolean matches(Hand hand) {
        return false;
    }

    @Override
    public int rank() {
        return 50;
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return null;
    }
}
