package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Hand;
import org.poker.HandTestFixtures;

import static org.assertj.core.api.Assertions.assertThat;

class FlushTest {
    private Flush cut;

    @BeforeEach
    void setUp() {
        cut = new Flush();
    }
    @Test
    void hand1IsAceHighAndHand2IsLower_compareWithSame_hand1() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createRoyalFlushHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createStraightFlushHand());
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void hand2IsAceHighAndHand1IsLower_compareWithSame_hand1() {
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createStraightFlushHand());
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void hand1AndHand2AreSame_compareWithSame_noWinner() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createRoyalFlushHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.noWinner());
    }
}