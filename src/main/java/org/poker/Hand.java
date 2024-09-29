package org.poker;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public final class Hand {
    private final String name;
    private final Collection<Card> cards;
    private final SortedSet<Card> sortedCards;

    /**
     * @param name the name of the hand e.g. hand one
     * @param cards should be a collection of exactly 5 cards
     * @throws IllegalArgumentException if the number of cards is not 5
     */
    public Hand(String name, Collection<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Hand must have at 5 cards");
        }
        this.name = name;
        this.cards = cards;
        sortedCards = new TreeSet<>(cards);
    }

    public SortedSet<Card> getSortedCards() {
        return new TreeSet<>(cards);
    }
}
