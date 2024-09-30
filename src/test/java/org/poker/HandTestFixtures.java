package org.poker;

import java.util.Collection;
import java.util.List;

public final class HandTestFixtures {
    private HandTestFixtures() {
    }

    public static List<Card> createHighCardAceHighHand() {
        return List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.SPADES),
                new Card(Rank.NINE, Suit.CLUBS));
    }

    public static List<Card> createRoyalFlushHand() {
        return List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.QUEEN, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS));
    }

    public static List<Card> createStraightFlushHand() {
        return List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.QUEEN, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS));
    }

    public static List<Card> createStraightHand() {
        return List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.QUEEN, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS));
    }

    public static List<Card> createFlushHand() {
        return List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS));
    }

    public static List<Card> createPairHand() {
        return List.of(new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.NINE, Suit.HEARTS));
    }


    public static List<Card> createTwoPairsHand() {
        return List.of(new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.THREE, Suit.SPADES),
                new Card(Rank.THREE, Suit.CLUBS));
    }

    public static Collection<Card> createThreeOfAKind() {
        return List.of(new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.TWO, Suit.SPADES),
                new Card(Rank.THREE, Suit.CLUBS));
    }
}
