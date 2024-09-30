package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.HandTestFixtures;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StraightFlushTest {
    private StraightFlush cut;

    @BeforeEach
    void setUp() {
        cut = new StraightFlush();
    }

    @Test
    void handHasRoyalStraightFlush_isMet_returnsTrue() {
        assertThat(cut.matches(new Hand("some hand", HandTestFixtures.createRoyalFlushHand()))).isTrue();
    }

    @Test
    void handHasRegularStraightFlush_isMet_returnsTrue() {
        assertThat(cut.matches(new Hand("some hand", HandTestFixtures.createStraightFlushHand()))).isTrue();
    }

    @Test
    void handHasHighCard_matches_returnsFalse() {
        assertThat(cut.matches(new Hand("some hand", HandTestFixtures.createHighCardAceHighHand()))).isFalse();
    }

    @Test
    void handHasStraight_matches_returnsFalse() {
        assertThat(cut.matches(new Hand("some hand", HandTestFixtures.createStraightHand()))).isFalse();
    }

    @Test
    void handHasFlush_matches_returnsFalse() {
        assertThat(cut.matches(new Hand("some hand", HandTestFixtures.createFlushHand()))).isFalse();
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

    @Test
    void handTwoIsStraightFromAceLowAndHandTwoIsHandFromTwo_compare_hand2() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handOneIsStraightFromAceLowAndHandOneIsHandFromThree_compare_hand1() {
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void bothHandsAreAceLow_compare_noWinner() {
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.noWinner());
    }

    @Test
    void handOneIsStraightFromTwoAndHandTwoIsHandFromThree_compare_hand2() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        Hand hand2 = new Hand("Hand 2", List.of(new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handIsAceLow_matches_true() {
        Hand hand1 = new Hand("Hand 1", List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS)));
        assertThat(cut.matches(hand1)).isTrue();
    }
}