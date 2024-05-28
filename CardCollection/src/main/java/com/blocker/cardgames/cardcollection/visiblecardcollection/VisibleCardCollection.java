package com.blocker.cardgames.cardcollection.visiblecardcollection;

import com.blocker.cardgames.card.Card;
import com.blocker.cardgames.cardcollection.CardCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VisibleCardCollection<C extends Card> extends CardCollection<C> {
    private final List<C> cards;

    public VisibleCardCollection(C[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    @Override public int size() {
        return cards.size();
    }

    @Override protected Optional<C> getByIndex(int index) {
        if (isEmpty() || index < 0 || index >= size()) return Optional.empty();
        return Optional.of(cards.get(index));
    }

    @Override protected void insertAtTop(C card) {
        cards.add(card);
    }

    @Override public Optional<C> removeByIndex(int index) {
        if (isEmpty() || index < 0 || index >= size()) return Optional.empty();
        return Optional.of(cards.remove(index));
    }
}
