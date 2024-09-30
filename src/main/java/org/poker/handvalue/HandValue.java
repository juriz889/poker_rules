package org.poker.handvalue;

import org.poker.Hand;

public interface HandValue {
    boolean matches(Hand hand);

    String handName(Hand hand);

    int rank();

    Winner compareTwoHandsOfSameValue(Hand hand1, Hand hand2);
}
