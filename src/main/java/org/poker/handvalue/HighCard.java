package org.poker.handvalue;

import org.poker.Hand;

public final class HighCard implements HandValue {
    @Override
    public boolean isMet(Hand hand) {
        return true;
    }
}
