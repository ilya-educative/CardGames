package com.blocker.cardgames.durakgame.api.table;

import com.blocker.cardgames.durakgame.api.round.DurakRound;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface TableService {
    void switchFromAttackToWait(DurakTable durakTable);

    void setToAttack(DurakTable durakTable, DurakRound durakRound);

    void setToDefend(DurakTable durakTable);

    void clearRoundLooser(DurakTable durakTable);
}
//final class TableServiceImpl implements TableService {
//    @Override public void switchFromAttackToWait(DurakTable durakTable) {
//        durakTable.getHands()
//                .stream()
//                .filter(hand -> hand.state() == DurakHand.State.Attack)
//                .forEach(hand -> hand.state(DurakHand.State.Wait));
//    }
//
//    @Override public void setToAttack(DurakTable durakTable, DurakRound durakRound) {
//        if (durakRound.isFirstRound()) {
//            durakTable.attacker(0);
//            return;
//        }
//        if (durakTable.roundLooser().isPresent()) {
//            durakTable.attacker(durakTable.roundLooser().get().slotId());
//        } else {
//            durakTable.attacker(durakTable.defender().slotId());
//        }
//    }
//
//    @Override public void setToDefend(DurakTable durakTable) {
//        DurakHand attacker = durakTable.attacker();
//        durakTable.defender(durakTable.afterAttacker(attacker.slotId()));
//    }
//
//    @Override public void clearRoundLooser(DurakTable durakTable) {
//        durakTable.roundLooser().ifPresent(hand -> hand.isRoundLooser(false));
//    }
//}
