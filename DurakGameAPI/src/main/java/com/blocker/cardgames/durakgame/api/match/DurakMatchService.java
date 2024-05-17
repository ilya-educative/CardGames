package com.blocker.cardgames.durakgame.api.match;

import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface DurakMatchService {
    boolean isGameOver(DurakTable durakTable);
}
//final class EngGameServiceImpl implements EndGameService {
//    @Override public boolean isGameOver(DurakTable durakTable) {
//        return durakTable.getHands()
//                .stream()
//                .filter(DurakHand::hasCards)
//                .count() >= 2;
//    }
//}
