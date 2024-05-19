package com.blocker.cardgames.durakgame.api.classicgame.actionservice;

import com.blocker.cardgames.durakgame.api.action.DurakAction;
import com.blocker.cardgames.durakgame.api.action.DurakActionService;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.config.GameFeature;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClassicActionService implements DurakActionService {
    @Override public List<DurakAction> allowedActions(DurakHand durakHand, DurakBoard durakBoard, DurakGameConfig durakGameConfig) {
        if (!durakHand.canAct()) {
            return Collections.emptyList();
        }

        if (durakHand.isEmpty()) {
            return List.of(DurakAction.Pass);
        }

        List<DurakAction> allowedActions = new ArrayList<>();
        switch (durakHand.state()) {
            case Attacking -> {
                allowedActions.add(DurakAction.Attack);
                if (durakBoard.hasCards()) {
                    allowedActions.add(DurakAction.Pass);
                }
            }
            case Defending -> {
                allowedActions.addAll(List.of(DurakAction.Defend, DurakAction.Take));
                if (durakGameConfig.features().contains(GameFeature.Transfer)) {
                    allowedActions.add(DurakAction.Transfer);
                }
            }
        }
        return allowedActions;
    }
}
