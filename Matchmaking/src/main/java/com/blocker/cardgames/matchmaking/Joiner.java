package com.blocker.cardgames.matchmaking;

import java.util.UUID;

public abstract class Joiner {
    private boolean isConfirmed = false;
    private final UUID uuid = UUID.randomUUID();

    public final boolean isConfirmed() {
        return isConfirmed;
    }

    public final void isConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public final UUID uuid() {
        return uuid;
    }
}
