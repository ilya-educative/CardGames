package com.blocker.cardgames.cardcollection.visiblecardcollection;

import com.blocker.cardgames.card.Card;
import com.blocker.cardgames.cardcollection.AbstractCardCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VisibleCardCollection<C extends Card> extends AbstractCardCollection<C> {
    private final List<C> cards;

    public VisibleCardCollection(C[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    @Override public int size() {
        return cards.size();
    }

    @Override public Optional<C> getByIndex(int index) {
        if (isEmpty()) return Optional.empty();
        return Optional.of(cards.get(index));
    }

    @Override public boolean insertAtIndex(C card, int index) {
        cards.set(index, card);
        return true;
    }
}
