package com.blocker.cardgames.matchmaking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Match<T extends Joiner> {
    private final List<T> queue = new ArrayList<>();
    private final UUID uuid = UUID.randomUUID();
    private final int size;

    public Match(int size) {
        this.size = size;
    }

    public boolean hasSlots() {
        return queue.size() < size;
    }

    public UUID join(T t) {
        queue.add(t);
        return uuid;
    }

    public void leave(T t) {
        queue.remove(t);
    }

    public UUID uuid() {
        return uuid;
    }
}
