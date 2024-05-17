package com.blocker.cardgames.round.bb.turnbasedround;

import com.blocker.cardgames.round.api.AbstractRound;

import java.util.Queue;

public final class TurnBasedRound<T> extends AbstractRound {
    private final Queue<T> turns;

    public TurnBasedRound(Queue<T> turns) {
        this.turns = turns;
    }

    public boolean hasTurns() {
        return turnsLeft() > 0;
    }

    public boolean turnsAreEmpty() {
        return turnsLeft() == 0;
    }

    public int turnsLeft() {
        return turns.size();
    }

    public void addNextTurn(T turn) {
        turns.offer(turn);
    }

    public T getNextTurn() {
        return turns.remove();
    }

    @Override public boolean isRunning() {
        return hasTurns();
    }
}
