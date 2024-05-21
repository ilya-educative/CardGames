package com.blocker.cardgames.cardcollection.bb.visiblecardcollection;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardcollection.api.CardCollection;

import java.util.Iterator;
import java.util.List;

public final class VisibleCardCollection<C extends Card> extends CardCollection<C> {
    private final List<C> cards;

    public VisibleCardCollection(List<C> cards) {
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

    public C get(int index) {
        return cards.get(index);
    }

    public List<C> getCards() {
        return cards;
    }

    public List<C> subList() {
        return cards.subList(0, cards.size());
    }
}
