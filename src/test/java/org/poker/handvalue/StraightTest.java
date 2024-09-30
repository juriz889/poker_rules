package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StraightTest {
    private Straight cut;

    @BeforeEach
    void setUp() {
        cut = new Straight();
    }

    @Test
    void handOneIsStraightFromTwoAndHandTwoIsHandFromThree_compare_hand2() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handTwoIsStraightFromAceLowAndHandTwoIsHandFromThree_compare_hand2() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handOneIsStraightFromAceLowAndHandOneIsHandFromThree_compare_hand1() {
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void bothHandsAreAceLow_compare_noWinner() {
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.noWinner());
    }

    @Test
    void handIsAceLow_matches_true() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.matches(hand1)).isTrue();
    }
}