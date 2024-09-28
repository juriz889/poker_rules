package org.poker.handvalue;

import org.poker.Hand;

import java.util.List;

public final class HandValueFinder {
    private static final List<HandValue> ALL_HAND_VALUES = List.of(
            new StraightFlush(),
            new HighCard()
    );

    public HandValue getHandValue(Hand hand) {
        return ALL_HAND_VALUES.stream()
                .filter(handValue -> handValue.matches(hand))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No hand value found for hand: " + hand));
    }
}
