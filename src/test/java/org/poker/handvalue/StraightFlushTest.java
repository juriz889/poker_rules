package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Hand;
import org.poker.HandTestFixtures;

import static org.assertj.core.api.Assertions.assertThat;

class StraightFlushTest {
    private StraightFlush cut;

    @BeforeEach
    void setUp() {
        cut = new StraightFlush();
    }

    @Test
    void handHasRoyalStraightFlush_isMet_returnsTrue() {
        assertThat(cut.isMet(new Hand("some hand", HandTestFixtures.createRoyalFlushHand()))).isTrue();
    }

    @Test
    void handHasRegularStraightFlush_isMet_returnsTrue() {
        assertThat(cut.isMet(new Hand("some hand", HandTestFixtures.createStraightFlushHand()))).isTrue();
    }

    @Test
    void handHasHighCard_isMet_returnsFalse() {
        assertThat(cut.isMet(new Hand("some hand", HandTestFixtures.createHighCardHand()))).isFalse();
    }
}