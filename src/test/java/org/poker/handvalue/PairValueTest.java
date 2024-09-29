package org.poker.handvalue;

import org.junit.jupiter.api.Test;
import org.poker.Hand;
import org.poker.HandTestFixtures;

import static org.assertj.core.api.Assertions.assertThat;

class PairValueTest {
    private PairValue cut;

    @Test
    void pair_matches_true() {
        cut = new PairValue();
        assertThat(cut.matches(new Hand("any hand", HandTestFixtures.createPairHand()))).isTrue();
    }
}