package com.blocker.cardgames.matchmaking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemoryMatchmakingQueue<K extends Enum<K>, V extends Joiner> implements MatchmakingQueue<K, V> {
    private final Map<K, List<Match<V>>> map = new HashMap<>();

    public InMemoryMatchmakingQueue(Class<K> enumClass) {
        for (K enumKey : EnumSet.allOf(enumClass)) {
            map.put(enumKey, new ArrayList<>());
        }
    }

    @Override public synchronized UUID join(K k, V v, MatchConfiguration matchConfiguration) {
        Match<V> match = map.get(k).stream()
                .filter(Match::hasSlots)
                .findFirst()
                .orElse(new Match<>(matchConfiguration.size));
        return match.join(v);
    }

    @Override public synchronized void leave(V v, UUID uuid) {
        map.values().stream()
                .flatMap(Collection::stream)
                .filter(match -> uuid.equals(match.uuid()))
                .findFirst()
                .ifPresentOrElse(match -> match.leave(v),
                        () -> {
                            throw new IllegalArgumentException("");
                        });
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
