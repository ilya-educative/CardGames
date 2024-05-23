package com.blocker.cardgames.cardcollections.bb.visiblecardcollection;

import com.blocker.cardgames.card.api.card.Card;
import com.blocker.cardgames.cardcollections.bb.AbstractCardCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VisibleCardCollection<C extends Card> extends AbstractCardCollection<C> {
    private final List<C> cards;

    public VisibleCardCollection(C[] cards) {
        super(true);
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public VisibleCardCollection(boolean allowDuplicates) {
        super(allowDuplicates);
        this.cards = new ArrayList<>();
    }

    public VisibleCardCollection(C[] cards, boolean allowDuplicates) {
        super(allowDuplicates);
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    @Override public int size() {
        return cards.size();
    }

    public C getByIndex(int index) {
        return cards.get(index);
    }

    public boolean insertAtIndex(int index, C card) {
        if (isDuplicatesAllowed(card, cards)) {
            cards.set(index, card);
            return true;
        }
        return false;
    }
}
