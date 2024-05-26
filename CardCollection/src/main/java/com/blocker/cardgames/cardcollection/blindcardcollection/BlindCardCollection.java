package com.blocker.cardgames.cardcollection.blindcardcollection;

import com.blocker.cardgames.card.Card;
import com.blocker.cardgames.cardcollection.AbstractCardCollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public class BlindCardCollection<C extends Card> extends AbstractCardCollection<C> {
    private final LinkedList<C> cards;

    public BlindCardCollection(C[] cards) {
        this.cards = new LinkedList<>(Arrays.asList(cards));
    }

    @Override public int size() {
        return cards.size();
    }

    @Override public Optional<C> removeFromTop() {
        if (isEmpty()) return Optional.empty();
        return Optional.of(cards.removeFirst());
    }

    @Override public void shuffle() {
        Collections.shuffle(cards);
    }
}
