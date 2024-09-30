package org.poker.handvalue;

import org.poker.Card;
import org.poker.Hand;

public final class ThreeOfAKind implements HandValue {
    private static final int RANK = 15;
    private final OfAKind ofAKind = new OfAKind(Constants.THREE_OF_KIND_SIZE);

    @Override
    public boolean matches(Hand hand) {
        return ofAKind.matches(hand);
    }

    @Override
    public int rank() {
        return RANK;
    }

    @Override
    public String handName() {
        return "Three of a Kind";
    }

    @Override
    public Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2) {
        return ofAKind.compareTwoHandsOfSameValue(hand1, hand2);
    }

    public Winner compareThreeOfAKind(Hand hand1, Hand hand2) {
        Card pairCards1 = ofAKind.getCardsOfAKindFromHand(hand1).getFirst();
        Card pairCards2 = ofAKind.getCardsOfAKindFromHand(hand2).getFirst();
        return HandCardWinnerChecker.checkWinner(new HandCard(hand1, pairCards1), new HandCard(hand2, pairCards2));
    }

}

