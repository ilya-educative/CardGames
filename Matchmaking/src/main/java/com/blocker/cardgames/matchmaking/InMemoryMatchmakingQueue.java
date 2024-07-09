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

    @Override public synchronized Match<V> join(K matchType, V joiner) throws MultipleMatchmakingException {
        resetConfirmation(joiner);
        if (map.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(match -> match.contains(joiner))) {
            throw new MultipleMatchmakingException(
                    ExceptionMessage.MULTIPLE_MATCHMAKING_s.formatted(joiner.uuid().toString())
            );
        }

        Optional<Match<V>> optionalMatch = map.get(matchType).stream()
                .filter(Match::hasSlots)
                .findFirst();

        Match<V> match;
        if (optionalMatch.isPresent()) {
            match = optionalMatch.get();
        } else {
            match = new Match<>();
            map.get(matchType).add(match);
        }
        return match.join(joiner);
    }

    @Override public synchronized void leave(V joiner) {
        Optional<Match<V>> optionalMatch = map.values().stream()
                .flatMap(Collection::stream)
                .filter(match -> match.contains(joiner))
                .findFirst();

        if (optionalMatch.isPresent()) {
            optionalMatch.get().leave(joiner);
        } else {
            throw new JoinerNotInMatchmakingQueueException(
                    ExceptionMessage.JOINER_NOT_IN_MATCHMAKING_QUEUE_s.formatted(joiner.uuid().toString())
            );
        }
    }

    @Override public void confirm(V joiner) {
        joiner.isConfirmed(true);
    }

    @Override public void resetConfirmation(V joiner) {
        joiner.isConfirmed(false);
    }

    @Override public List<Match<V>> getMatchesByKey(K matchType) {
        return map.get(matchType);
    }
}
