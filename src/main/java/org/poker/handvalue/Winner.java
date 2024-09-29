package org.poker.handvalue;

import org.poker.Hand;

import java.util.Objects;
import java.util.Optional;

public final class Winner {
    private final Hand winner;

    private Winner(Hand winner) {
        this.winner = winner;
    }

    public static Winner of(Hand winner) {
        return new Winner(winner);
    }

    public static Winner noWinner() {
        return new Winner(null);
    }

    public Optional<Hand> getWinner() {
        return Optional.ofNullable(winner);
    }

    @Override
    public String toString() {
        return "Winner{" +
                "winner=" + winner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winner winner1 = (Winner) o;
        return Objects.equals(winner, winner1.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winner);
    }
}
