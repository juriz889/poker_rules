package org.poker.handvalue;

import org.poker.Hand;

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
}
