package com.blocker.cardgames.durakgame.api.action;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardinteraction.bb.durakcardinteraction.DurakCardInteraction;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;

public interface DurakActionController {
    boolean attack(StandardCard attackingCard, DurakHand hand, DurakBoard board);

    boolean defend(StandardCard attackingCard, StandardCard defendingCard, DurakHand hand, DurakBoard board, DurakCardInteraction cardInteraction);

    boolean pass(DurakHand durakHand);

    boolean take(DurakHand hand);

    boolean surrender(DurakHand hand);
}
