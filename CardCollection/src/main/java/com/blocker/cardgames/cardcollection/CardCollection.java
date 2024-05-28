package com.blocker.cardgames.cardcollection;

import com.blocker.cardgames.card.Card;

import java.util.Optional;

public abstract class CardCollection<C extends Card> {
    protected CardCollection() {
    }

    public abstract int size();
    public final boolean isEmpty() {
        return size() == 0;
    }
    public final boolean hasCards() {
        return size() > 0;
    }

    protected Optional<C> getByIndex(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected void insertAtTop(C card) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected Optional<C> removeFromTop() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    protected Optional<C> removeByIndex(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected void shuffle() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
