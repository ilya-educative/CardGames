package com.blocker.cardgames.durakgame.api.table;

import com.blocker.cardgames.durakgame.api.hand.DurakHand;

public interface DurakTableController {
    default boolean join(DurakTable durakTable, DurakHand durakHand) {
        return durakTable.join(durakHand);
    }

    default boolean leave(DurakTable durakTable, int id) {
        return durakTable.leave(id);
    }
}
