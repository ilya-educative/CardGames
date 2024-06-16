package com.blocker.cardgames.matchmaking;

import java.util.List;

public interface MatchmakingQueue<K extends Enum<K>, V extends Joiner> {
    Match<V> join(K k, V v);

    void leave(V v);

    void confirm(V v);

    void resetConfirmation(V v);

    List<Match<V>> getMatchesByKey(K k);
}
