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

class PairValueTest {
    private PairValue cut;

    @BeforeEach
    void setUp() {
        cut = new PairValue();
    }

    @Test
    void pair_matches_true() {
        assertThat(cut.matches(new Hand("any hand", HandTestFixtures.createPairHand()))).isTrue();
    }

    @Test
    void handOneIsPairOfNineAndHand2IsPairOfAce_findWinner_hand2() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS));
        cut = new PairValue();
        Hand hand2 = new Hand("hand 2", handTwoCards);
        assertThat(cut.compareTwoHandsOfSameValue(new Hand("any hand", handOneCards), hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handOneIsPairOfNineAndHand2IsPairOfThree_findWinner_hand1() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS));
        cut = new PairValue();
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1
        ));
    }

    @Test
    void bothHandsArePairOfNineButHandOneHasBetterKicker_findWinner_hand1() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        cut = new PairValue();
        assertThat(cut.compareTwoHandsOfSameValue(new Hand("any hand", handOneCards), new Hand("hand 2", handTwoCards))).isEqualTo(Winner.of(new Hand("any hand", handOneCards)));
    }
}