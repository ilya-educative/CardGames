package com.blocker.cardgames.matchmaking;

import com.blocker.cardgames.matchmaking.exception.ExceptionMessage;
import com.blocker.cardgames.matchmaking.exception.JoinerNotInMatchmakingQueueException;
import com.blocker.cardgames.matchmaking.exception.MultipleMatchmakingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryMatchmakingQueue<K extends Enum<K>, V extends Joiner> implements MatchmakingQueue<K, V> {
    private final Map<K, List<Match<V>>> map = new HashMap<>();

    public InMemoryMatchmakingQueue(Class<K> enumClass) {
        for (K enumKey : EnumSet.allOf(enumClass)) {
            map.put(enumKey, new ArrayList<>());
        }
    }

    @Override public synchronized Match<V> join(K k, V v) throws MultipleMatchmakingException {
        resetConfirmation(v);
        if (map.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(match -> match.contains(v))) {
            throw new MultipleMatchmakingException(
                    ExceptionMessage.MULTIPLE_MATCHMAKING_s.formatted(v.uuid().toString())
            );
        }

        Optional<Match<V>> optionalMatch = map.get(k).stream()
                .filter(Match::hasSlots)
                .findFirst();

        Match<V> match;
        if (optionalMatch.isPresent()) {
            match = optionalMatch.get();
        } else {
            match = new Match<>();
            map.get(k).add(match);
        }
        return match.join(v);
    }

    @Override public synchronized void leave(V v) {
        Optional<Match<V>> optionalMatch = map.values().stream()
                .flatMap(Collection::stream)
                .filter(match -> match.contains(v))
                .findFirst();

        if (optionalMatch.isPresent()) {
            optionalMatch.get().leave(v);
        } else {
            throw new JoinerNotInMatchmakingQueueException(
                    ExceptionMessage.JOINER_NOT_IN_MATCHMAKING_QUEUE_s.formatted(v.uuid().toString())
            );
        }
    }

    @Override public void confirm(V v) {
        v.isConfirmed(true);
    }

    @Override public void resetConfirmation(V v) {
        v.isConfirmed(false);
    }

    @Override public List<Match<V>> getMatchesByKey(K k) {
        return map.get(k);
    }
}
