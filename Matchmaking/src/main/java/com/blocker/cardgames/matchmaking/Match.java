package com.blocker.cardgames.matchmaking;

import com.blocker.cardgames.matchmaking.exception.AlreadyInMatchmakingQueueException;
import com.blocker.cardgames.matchmaking.exception.ExceptionMessage;
import com.blocker.cardgames.matchmaking.exception.FullMatchException;
import com.blocker.cardgames.matchmaking.exception.JoinerNotFoundInMatchException;
import com.blocker.cardgames.matchmaking.exception.JoinerNotInMatchmakingQueueException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Match<T extends Joiner> {
    private final List<T> queue = new ArrayList<>();
    private final UUID uuid = UUID.randomUUID();
    private final int size = 2;

    public Match() {
    }

    public boolean contains(T t) {
        return queue.contains(t);
    }

    public boolean hasSlots() {
        return queue.size() < size;
    }

    public Match<T> join(T t) throws AlreadyInMatchmakingQueueException, FullMatchException {
        if (queue.contains(t)) throw new AlreadyInMatchmakingQueueException(
                ExceptionMessage.ALREADY_IN_MATCHMAKING_QUEUE_s.formatted(t.uuid().toString()));
        if (!hasSlots()) throw new FullMatchException(
                ExceptionMessage.FULL_MATCH_s_s.formatted(uuid.toString(), t.uuid().toString())
        );
        queue.add(t);
        return this;
    }

    public void leave(T t) throws JoinerNotInMatchmakingQueueException {
        if (!queue.contains(t)) throw new JoinerNotFoundInMatchException(
                ExceptionMessage.JOINER_NOT_FOUND_IN_MATCH_s_s.formatted(t.uuid().toString(), uuid.toString())
        );
        queue.remove(t);
    }

    public UUID uuid() {
        return uuid;
    }
}
