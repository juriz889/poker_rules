package org.poker.handvalue;

public final class HandCardWinnerChecker {
    private HandCardWinnerChecker() {
    }

    public static Winner checkWinner(HandCard handCard1, HandCard handCard2) {
        if (handCard1.card().rankValue() < handCard2.card().rankValue()) {
            return Winner.of(handCard2.hand());
        } else if (handCard1.card().rankValue() > handCard2.card().rankValue()) {
            return Winner.of(handCard1.hand());
        } else {
            return Winner.noWinner();
        }
    }
}
