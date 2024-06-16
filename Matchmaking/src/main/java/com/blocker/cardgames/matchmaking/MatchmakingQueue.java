package com.blocker.cardgames.matchmaking;

import java.util.List;
import java.util.UUID;

public interface MatchmakingQueue<K extends Enum<K>, V extends Joiner> {
    UUID join(K k, V v);

    void leave(V v);

    void leave(V v, UUID uuid);

    void confirm(V v);

    void resetConfirmation(V v);

    List<Match<V>> getMatchesByKey(K k);
}
