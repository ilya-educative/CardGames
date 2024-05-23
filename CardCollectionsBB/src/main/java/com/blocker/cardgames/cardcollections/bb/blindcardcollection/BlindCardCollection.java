package com.blocker.cardgames.cardcollections.bb.blindcardcollection;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardcollections.bb.AbstractCardCollection;

import java.util.Arrays;
import java.util.LinkedList;

public class BlindCardCollection<C extends Card> extends AbstractCardCollection<C> {
    private final LinkedList<C> cards;

    public BlindCardCollection(C[] cards) {
        super(true);
        this.cards = new LinkedList<>(Arrays.asList(cards));
    }

    public BlindCardCollection(boolean allowDuplicates) {
        super(allowDuplicates);
        this.cards = new LinkedList<>();
    }

    public BlindCardCollection(C[] cards, boolean allowDuplicates) {
        super(allowDuplicates);
        this.cards = new LinkedList<>(Arrays.asList(cards));
    }

    @Override public int size() {
        return cards.size();
    }

    public C getFromTop() {
        return cards.removeFirst();
    }

    public C getFromBottom() {
        return cards.removeLast();
    }

    public boolean insertAtTop(C card) {
        if (isDuplicatesAllowed(card, cards)) return cards.offerFirst(card);
        return false;
    }

    public boolean insertAtBottom(C card) {
        if (isDuplicatesAllowed(card, cards)) return cards.offerLast(card);
        return false;
    }

    public void shuffle() {
        shuffle(cards);
    }
}
