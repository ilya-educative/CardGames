package com.blocker.cardgames.durakgame.api.hand;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.visiblecardcollection.VisibleCardCollection;
import com.blocker.cardgames.durakgame.api.action.DurakAction;

import java.util.List;
import java.util.Optional;

public final class DurakHand {
    private final VisibleCardCollection<StandardCard> cards;
    private boolean isRoundLooser;
    private State state;
    private int slotId;
    private DurakAction durakAction;

    public DurakHand(VisibleCardCollection<StandardCard> cards, int slotId) {
        this.cards = cards;
        this.isRoundLooser = false;
        this.state = State.Wait;
        this.slotId = slotId;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean hasCards() {
        return cards.hasCards();
    }

    public int size() {
        return cards.size();
    }

    public void addCard(StandardCard card) {
        cards.add(card);
    }

    public void removeCard(StandardCard card) {
        cards.remove(card);
    }

    public List<StandardCard> getCards() {
        return cards.getCards();
    }

    public void isRoundLooser(boolean value) {
        isRoundLooser = value;
    }

    public boolean isRoundLooser() {
        return isRoundLooser;
    }

    public int slotId() {
        return slotId;
    }

    public void slotId(int slotId) {
        this.slotId = slotId;
    }

    public State state() {
        return state;
    }

    public void state(State state) {
        this.state = state;
    }

    public void action(DurakAction durakAction) {
        this.durakAction = durakAction;
    }

    public Optional<DurakAction> action() {
        return Optional.ofNullable(durakAction);
    }

    public enum State {
        Attack, Defend, Wait
    }
}
