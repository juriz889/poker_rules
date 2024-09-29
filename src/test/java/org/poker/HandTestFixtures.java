package org.poker;

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
}
