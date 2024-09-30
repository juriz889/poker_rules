package org.poker.handvalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.Card;
import org.poker.Hand;
import org.poker.HandTestFixtures;
import org.poker.Rank;
import org.poker.Suit;

import java.util.List;

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

    @Test
    void bothHandsAreSame_compareTowHandsOfSameValue_noWinner() {
        assertThat(cut.compareTwoHandsOfSameValue(new Hand("any hand", HandTestFixtures.createRoyalFlushHand()), new Hand("any hand", HandTestFixtures.createRoyalFlushHand()))).isEqualTo(Winner.noWinner());
    }

    @Test
    void bothHandsAreAceHighButHand1HasBetterKicker_compareTwoHandsOfSameValue_hand1() {
        List<Card> hand1Cards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.SPADES),
                new Card(Rank.NINE, Suit.CLUBS));
        List<Card> hand2Cards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.SPADES),
                new Card(Rank.EIGHT, Suit.CLUBS));
        Hand hand1 = new Hand("Hand 1", hand1Cards);
        Hand hand2 = new Hand("Hand 2", hand2Cards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand1));
    }

    @Test
    void bothHandsAreAceHighButHand2HasBetterKicker_compareTwoHandsOfSameValue_hand2() {
        List<Card> hand1Cards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TEN, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS));
        List<Card> hand2Cards = List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS));
        Hand hand1 = new Hand("Hand 1", hand1Cards);
        Hand hand2 = new Hand("Hand 2", hand2Cards);
        assertThat(cut.compareTwoHandsOfSameValue(hand1, hand2)).isEqualTo(Winner.of(hand2));
    }
}