package org.poker.handvalue;

import org.poker.Hand;

public interface HandValue {
    boolean matches(Hand hand);
    int rank();
}
