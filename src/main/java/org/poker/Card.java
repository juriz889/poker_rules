package org.poker;

public record Card(Rank rank, Suit suit) implements Comparable<Card> {
    public int rankValue() {
        return rank.getValue();
    }



    @Override
    public int compareTo(Card o) {
        return Integer.compare(rankValue(), o.rankValue());
    }
}
