package com.blocker.cardgames.durakgame.api.round;

import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface DurakRoundService {
    boolean isRoundOver(DurakTable durakTable);
}
//final class RoundServiceImpl implements RoundService {
//    @Override public boolean isRoundOver(DurakTable durakTable) {
//        return durakTable.getHands()
//                .stream()
//                .filter(durakHand -> durakHand.state() != DurakHand.State.Defend)
//                .filter(durakHand -> durakHand.action().isPresent())
//                .map(durakHand -> durakHand.action().get())
//                .allMatch(action -> action == Action.Pass);
//    }
//}
