package com.blocker.cardgames.cardcollection;

import com.blocker.cardgames.card.Card;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCardCollection<C extends Card> {
    protected AbstractCardCollection() {
    }

    public abstract int size();
    public final boolean isEmpty() {
        return size() == 0;
    }
    public final boolean hasCards() {
        return size() > 0;
    }
    protected final void shuffle(List<C> cards) {
        Collections.shuffle(cards);
    }

    protected Optional<C> getFromTop() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    protected Optional<C> getFromBottom() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    protected Optional<C> getByIndex(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected boolean insertAtTop(C card) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    protected boolean insertAtBottom(C card) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    protected boolean insertAtIndex(C card, int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
