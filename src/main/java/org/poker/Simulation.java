package org.poker;

import org.poker.handvalue.HandValueFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class Simulation {
    public static void main(String[] args) {
        System.out.println("Starting poker simulation...");
        LinkedList<Card> deck = createDeck();
        List<Card> handOneCards = new ArrayList<>();
        List<Card> handTwoCards = new ArrayList<>();
        dealCards(deck, handOneCards, handTwoCards);
        Hand hand1 = new Hand("hand one", handOneCards);
        Hand hand2 = new Hand("hand two", handTwoCards);
        System.out.println("Hand one is: " + hand1);
        System.out.println("Hand two is: " + hand2);
        WinningHandFinder winningHandFinder = new WinningHandFinder(new HandValueFinder());
        Optional<Hand> windingHand = winningHandFinder.findWinningHand(hand1, hand2);
        System.out.println("Winner is " + windingHand.map(Hand::getName).orElse("no one"));
    }

    private static void dealCards(LinkedList<Card> deck, List<Card> handOneCards, List<Card> handTwoCards) {
        for (int i = 0; i < 5; i++) {
            Card pop = deck.pop();
            System.out.println("Hand 1  draws: " + pop);
            handOneCards.add(pop);
            pop = deck.pop();
            System.out.println("Hand 2  draws: " + pop);
            handTwoCards.add(pop);
        }
    }

    private static LinkedList<Card> createDeck() {
        LinkedList<Card> deck = new LinkedList<>();
        for (Rank value : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }
}
