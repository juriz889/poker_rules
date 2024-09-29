package org.poker;

public record Card(Rank rank, Suit suit) implements Comparable<Card> {
    public int rankValue() {
        return rank.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(rankValue(), o.rankValue());
    }
}
