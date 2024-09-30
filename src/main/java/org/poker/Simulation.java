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
        Collections.shuffle(deck);
        List<Card> handOneCards = new ArrayList<>();
        List<Card> handTwoCards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card pop = deck.pop();
            System.out.println("Hand 1  draws: " + pop);
            handOneCards.add(pop);
            pop = deck.pop();
            System.out.println("Hand 2  draws: " + pop);
            handTwoCards.add(pop);
        }
        Hand hand1 = new Hand("hand one", handOneCards);
        Hand hand2 = new Hand("hand two", handTwoCards);
        System.out.println("Hand one: " + hand1);
        System.out.println("Hand two: " + hand2);
        WinningHandFinder winningHandFinder = new WinningHandFinder(new HandValueFinder());
        Optional<Hand> windingHand = winningHandFinder.findWindingHand(hand1, hand2);
        System.out.println("Winner is " + windingHand.map(Hand::getName).orElse("no one"));
    }

    private static LinkedList<Card> createDeck() {
        LinkedList<Card> deck = new LinkedList<>();
        for (Rank value : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
        return deck;
    }
}
