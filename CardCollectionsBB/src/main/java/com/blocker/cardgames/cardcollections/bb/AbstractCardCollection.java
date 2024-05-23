package com.blocker.cardgames.cardcollections.bb;

import com.blocker.cardgames.card.api.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCardCollection<C extends Card> {
    private final boolean allowDuplicates;

    protected AbstractCardCollection(boolean allowDuplicates) {
        this.allowDuplicates = allowDuplicates;
    }

    protected boolean isDuplicatesAllowed(C card, Collection<C> cards) {
        if (allowDuplicates) return true;
        else return cards.contains(card);
    }

    public abstract int size();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean hasCards() {
        return size() > 0;
    }

    protected void shuffle(List<C> cards) {
        Collections.shuffle(cards);
    }
}
