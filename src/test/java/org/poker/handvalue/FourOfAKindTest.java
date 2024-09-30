package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FourOfAKindTest {
    private FourOfAKind cut;

    @BeforeEach
    void setUp() {
        cut = new FourOfAKind();
    }

    @Test
    void handOneIsOfNinesAndHand2IsOfAce_findWinner_hand2() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.ACE, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        assertThat(cut.compareTwoHandsOfSameValue(new Hand("any hand", handOneCards), hand2)).isEqualTo(Winner.of(hand2));
    }

    @Test
    void handOneIsOfNineAndHand2IsOfThree_findWinner_hand1() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.SPADES),
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void bothHandsAreOfNineWithSameKicker_findWinner_noWinner() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        assertThat(cut.compareTwoHandsOfSameValue(new Hand("any hand", handOneCards), new Hand("hand 2", handTwoCards))).isEqualTo(Winner.noWinner());
        ;
    }

}