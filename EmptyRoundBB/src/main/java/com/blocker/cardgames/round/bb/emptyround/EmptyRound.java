package com.blocker.cardgames.round.bb.emptyround;

import com.blocker.cardgames.round.api.AbstractRound;

public final class EmptyRound extends AbstractRound {
    private boolean isRunning;

    public EmptyRound() {
        isRunning = false;
    }

    public EmptyRound(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override public boolean isRunning() {
        return isRunning;
    }

    public void isRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
