package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class FullHouseTest {
    private FullHouse cut;

    @BeforeEach
    void setUp() {
        cut = new FullHouse();
    }

    @Test
    void handOneIsFullHouseWithThreeAcesHandTwoHasKinds_findWinner_hand1() {
        List<Card> handOneCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void handOneAndTowIsFullHouseWithThreeAcesButHandTwoHasTwoKings_findWinner_hand2() {
        List<Card> handOneCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2
        ));
    }

    @Test
    void handOneAndTwoAreSame_findWinner_noWinner() {
        List<Card> handOneCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS));
        List<Card> handTwoCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS));
        Hand hand2 = new Hand("hand 2", handTwoCards);
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.noWinner());
    }

    @Test
    void testName() {
        List<Card> handOneCards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS));
        Hand hand1 = new Hand("any hand", handOneCards);
        assertThat(cut.handName(hand1)).isEqualTo("Full House with Three of a Kind of ACE");
    }
}