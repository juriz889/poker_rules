package org.poker;

import java.util.Collection;

public record Hand(String name, Collection<Card> cards) {
    /**
     * @param name  then name of the hand e.g. hand one
     * @param cards should be a collection of exactly 5 cards
     * @throws IllegalArgumentException if the number of cards is not 5
     */
    public Hand(String name, Collection<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Hand must have at 5 cards");
        }
        this.name = name;
        this.cards = cards;
    }
}
