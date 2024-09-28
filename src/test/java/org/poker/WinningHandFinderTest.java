package org.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.handvalue.HandValueFinder;

import static org.assertj.core.api.Assertions.assertThat;

class WinningHandFinderTest {
    private WinningHandFinder cut;

    @BeforeEach
    void setUp() {
        cut = new WinningHandFinder(new HandValueFinder());
    }

    @Test
    void hand1IsHighCardAndHand2IsRoyalFlush_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createHighCardHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        assertThat(cut.findWindingHand(hand1, hand2)).contains(hand2);
    }
    @Test
    void hand2IsHighCardAndHand1IsRoyalFlush_findWinner_hand1() {
        Hand hand2 = new Hand("Hand 1", HandTestFixtures.createHighCardHand());
        Hand hand1 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        assertThat(cut.findWindingHand(hand1, hand2)).contains(hand1);
    }
}