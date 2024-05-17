package com.blocker.cardgames.durakgame.api.action;

import com.blocker.cardgames.durakgame.api.action.DurakAction;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;

import java.util.List;

public interface DurakActionService {
    List<DurakAction> allowedActions(DurakHand durakHand, DurakBoard durakBoard, DurakGameConfig durakGameConfig);
}
//final class ActionServiceImpl implements ActionService {
//    @Override public List<Action> allowedActions(DurakHand durakHand, DurakBoard durakBoard, DurakGameConfig durakGameConfig) {
//        List<Action> allowedActions = new ArrayList<>();
//        switch (durakHand.state()) {
//            case Attack -> allowedActions.addAll(Action.attackerActions());
//            case Defend -> allowedActions.addAll(Action.defenderActions());
//            case Wait -> allowedActions.addAll(Action.waitingActions());
//        }
//        if (durakBoard.isEmpty()) {
//            allowedActions.remove(Action.Pass);
//        }
//        if (durakHand.isEmpty()) {
//            allowedActions.remove(Action.Attack);
//            allowedActions.remove(Action.Defend);
//        }
//        return allowedActions;
//    }
//}
