package com.blocker.cardgames.cardcollection.bb.blindcardcollection;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardcollection.api.CardCollection;

import java.util.Iterator;
import java.util.List;

public final class BlindCardCollection<C extends Card> extends CardCollection<C> {
    private final List<C> cards;

    public BlindCardCollection(List<C> cards) {
        this.cards = cards;
    }

    @Override public boolean add(C card) {
        return cards.add(card);
    }

    @Override public Iterator<C> iterator() {
        return cards.iterator();
    }

    @Override public int size() {
        return cards.size();
    }

    public List<C> getCards() {
        return cards;
    }
}
