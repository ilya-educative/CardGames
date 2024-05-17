package com.blocker.cardgames.durakgame.api.round;

import com.blocker.cardgames.round.bb.emptyround.EmptyRound;

public class DurakRound {
    private final EmptyRound round;

    public DurakRound(EmptyRound round) {
        this.round = round;
    }

    public boolean isRunning() {
        return round.isRunning();
    }

    public boolean isFirstRound() {
        return round.isFirstRound();
    }
}
