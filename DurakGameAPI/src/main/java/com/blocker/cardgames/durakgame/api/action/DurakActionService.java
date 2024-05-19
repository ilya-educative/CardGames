package com.blocker.cardgames.durakgame.api.action;

import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;

import java.util.List;

public interface DurakActionService {
    List<DurakAction> allowedActions(DurakHand durakHand, DurakBoard durakBoard, DurakGameConfig durakGameConfig);
}
