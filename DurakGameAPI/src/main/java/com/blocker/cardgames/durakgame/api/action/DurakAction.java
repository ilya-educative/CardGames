package com.blocker.cardgames.durakgame.api.action;

import java.util.List;

public enum DurakAction {
    Attack, Defend, Pass, Take;

    public static List<DurakAction> attackerActions() {
        return List.of(Attack, Pass);
    }

    public static List<DurakAction> defenderActions() {
        return List.of(Defend, Take);
    }

    public static List<DurakAction> waitingActions() {
        return List.of(Attack, Pass);
    }
}
