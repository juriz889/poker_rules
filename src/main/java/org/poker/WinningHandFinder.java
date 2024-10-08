package org.poker;

import org.poker.handvalue.HandValue;
import org.poker.handvalue.HandValueFinder;

import java.util.Optional;

public final class WinningHandFinder {
    private final HandValueFinder handValueFinder;

    public WinningHandFinder(HandValueFinder handValueFinder) {
        this.handValueFinder = handValueFinder;
    }

    public Optional<Hand> findWinningHand(Hand hand1, Hand hand2) {
        HandValue handValue1 = handValueFinder.getHandValue(hand1);
        System.out.println("Hand one has value : " + handValue1.handName(hand1));
        HandValue handValue2 = handValueFinder.getHandValue(hand2);
        System.out.println("Hand two has value : " + handValue2.handName(hand2));
        if (handValue1.rank() < handValue2.rank()) {
            return Optional.of(hand2);
        } else if (handValue1.rank() > handValue2.rank()) {
            return Optional.of(hand1);
        } else {
            return handValue1.compareTwoHandsOfSameValue(hand1, hand2).getWinner();
        }
    }
}
