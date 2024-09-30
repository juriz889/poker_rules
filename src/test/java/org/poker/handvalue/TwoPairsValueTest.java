package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TwoPairsValueTest {
    private TwoPairsValue cut;

    @BeforeEach
    void setUp() {
        cut = new TwoPairsValue();
    }
    @Test
    void bothHandsAreTwoPairButHand2HaBetterPair_compare_hand2() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.EIGHT, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }
    @Test
    void bothHandsAreTwoPairButHand2HasLowerSecondPair_compare_hand1() {
        List<Card> handOneCards = List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }
}