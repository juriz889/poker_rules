package org.poker;

import org.poker.handvalue.HandValue;
import org.poker.handvalue.HandValueFinder;

import java.util.Optional;

public final class WinningHandFinder {
    private final HandValueFinder handValueFinder;

    public WinningHandFinder(HandValueFinder handValueFinder) {
        this.handValueFinder = handValueFinder;
    }

    public Optional<Hand> findWindingHand(Hand hand1, Hand hand2) {
        HandValue handValue1 = handValueFinder.getHandValue(hand1);
        HandValue handValue2 = handValueFinder.getHandValue(hand2);
        if (handValue1.rank() < handValue2.rank()) {
            return Optional.of(hand2);
        } else {
            return Optional.of(hand1);
        }
    }
}
