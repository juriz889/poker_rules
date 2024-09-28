package org.poker;

public enum Suit {
    HEARTS('H'), DIAMONDS('D'), CLUBS('C'), SPADES('S');
    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }
}
