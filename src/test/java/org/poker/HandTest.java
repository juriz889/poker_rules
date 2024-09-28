package org.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HandTest {
    @Test
    void handHasOneCard_create_throws() {
        List<Card> cards = List.of(new Card(Rank.NINE, Suit.CLUBS));
        assertThatThrownBy(() -> new Hand("Hand one", cards))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hand must have at 5 cards");
    }
}