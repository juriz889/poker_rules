package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Hand;
import org.poker.HandTestFixtures;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class HighCardTest {
    private HighCard cut;

    @BeforeEach
    void setUp() {
        cut = new HighCard();
    }

    @Test
    void anyHand_matches_true() {
        assertThat(cut.matches(new Hand("any hand", HandTestFixtures.createRoyalFlushHand()))).isTrue();
    }
}