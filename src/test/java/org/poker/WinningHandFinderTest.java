package org.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.handvalue.HandValueFinder;

import static org.assertj.core.api.Assertions.assertThat;

class WinningHandFinderTest {
    private WinningHandFinder cut;

    @BeforeEach
    void setUp() {
        cut = new WinningHandFinder(new HandValueFinder());
    }

    @Test
    void hand1IsHighCardAndHand2IsRoyalFlush_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createHighCardAceHighHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand2);
    }


    @Test
    void hand1AndHand2AreBothHighCard_findWinner_noWinner() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createHighCardAceHighHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createHighCardAceHighHand());
        assertThat(cut.findWinningHand(hand1, hand2)).isEmpty();
    }

    @Test
    void hand1IsRoyalFlushAndHand2IsStraightFlush_findWinner_hand1() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createRoyalFlushHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createStraightFlushHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand1);
    }

    @Test
    void hand2IsHighCardAndHand1IsRoyalFlush_findWinner_hand1() {
        Hand hand2 = new Hand("Hand 1", HandTestFixtures.createHighCardAceHighHand());
        Hand hand1 = new Hand("Hand 2", HandTestFixtures.createRoyalFlushHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand1);
    }

    @Test
    void hand1IsHighCardAndHandTwoIsPair_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createHighCardAceHighHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createPairHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand2);
    }

    @Test
    void hand1HasTwoPairsAndHandTwoIsPair_findWinner_hand1() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createTwoPairsHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createPairHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand1);
    }

    @Test
    void hand1HasTwoPairsAndHandTwoHasThreeOfAKing_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createTwoPairsHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createThreeOfAKind());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand2);
    }

    @Test
    void hand1HasStraightAndHandTwoHasThreeOfAKing_findWinner_hand1() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createStraightHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createThreeOfAKind());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand1);
    }

    @Test
    void hand1HasStraightAndHandTwoHasFlush_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createStraightHand());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createFlushHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand2);
    }
    @Test
    void hand1HasFullHouseAndHandTwoHasFlush_findWinner_hand1() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createFullHouse());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createFlushHand());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand1);
    }

    @Test
    void hand1HasFullHouseAndHandTwoHasFourOfKind_findWinner_hand2() {
        Hand hand1 = new Hand("Hand 1", HandTestFixtures.createFullHouse());
        Hand hand2 = new Hand("Hand 2", HandTestFixtures.createFourOfAKind());
        assertThat(cut.findWinningHand(hand1, hand2)).contains(hand2);
    }
}