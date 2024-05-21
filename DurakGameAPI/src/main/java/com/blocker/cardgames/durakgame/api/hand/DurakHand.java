package com.blocker.cardgames.durakgame.api.hand;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.visiblecardcollection.VisibleCardCollection;
import com.blocker.cardgames.durakgame.api.action.DurakAction;

import java.util.List;
import java.util.Optional;

public final class DurakHand {
    private final VisibleCardCollection<StandardCard> cards;
    private boolean isRoundLooser;
    private DurakHandState durakHandState;
    private int slotId;
    private DurakAction durakAction;
    private boolean canAct;
    private boolean startedRound;

    public DurakHand(VisibleCardCollection<StandardCard> cards, int slotId) {
        this.cards = cards;
        this.isRoundLooser = false;
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

    public List<StandardCard> view() {
        return cards.subList();
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

    public DurakHandState state() {
        return durakHandState;
    }

    public void state(DurakHandState durakHandState) {
        this.durakHandState = durakHandState;
    }

    public void canAct(boolean canAct) {
        this.canAct = canAct;
    }

    public boolean canAct() {
        return canAct;
    }

    public void action(DurakAction durakAction) {
        this.durakAction = durakAction;
    }

    public Optional<DurakAction> action() {
        return Optional.ofNullable(durakAction);
    }

    public boolean startedRound() {
        return startedRound;
    }

    public void startedRound(boolean startedRound) {
        this.startedRound = startedRound;
    }
}
