package org.poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class Hand {
    private final String name;
    private final Collection<Card> cards;
    private final List<Card> sortedCards;

    /**
     * @param name  the name of the hand e.g. hand one
     * @param cards should be a collection of exactly 5 cards
     * @throws IllegalArgumentException if the number of cards is not 5
     */
    public Hand(String name, Collection<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Hand must have at 5 cards");
        }
        this.name = name;
        this.cards = cards;
        sortedCards = new ArrayList<>(cards);
        sortedCards.sort(Comparator.reverseOrder());
    }

    public List<Card> getCardsSortedFromHighestToLowest() {
        return sortedCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;
        return name.equals(hand.name) && cards.equals(hand.cards) && sortedCards.equals(hand.sortedCards);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + cards.hashCode();
        result = 31 * result + sortedCards.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hand{" +
                " name='" + name + '\'' +
                ", cards=" + sortedCards +
                '}';
    }
}
