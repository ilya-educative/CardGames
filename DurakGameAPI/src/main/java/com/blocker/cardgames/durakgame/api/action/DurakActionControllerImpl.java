package com.blocker.cardgames.durakgame.api.action;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardinteraction.bb.durakcardinteraction.DurakCardInteraction;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;

public final class DurakActionControllerImpl implements DurakActionController {
    @Override public synchronized boolean attack(StandardCard attackingCard, DurakHand durakHand, DurakBoard durakBoard) {
        try {
            if (durakBoard.canAttackWith(attackingCard)) {
                durakHand.removeCard(attackingCard);
                durakBoard.attackWith(attackingCard);
                durakHand.action(DurakAction.Attack);
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override public synchronized boolean defend(StandardCard attackingCard, StandardCard defendingCard, DurakHand durakHand, DurakBoard durakBoard, DurakCardInteraction durakCardInteraction) {
        try {
            if (durakCardInteraction.test(attackingCard, defendingCard)) {
                durakHand.removeCard(defendingCard);
                durakBoard.defendAgainst(attackingCard, defendingCard);
                durakHand.action(DurakAction.Defend);
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override public boolean pass(DurakHand durakHand) {
        try {
            durakHand.action(DurakAction.Pass);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override public boolean take(DurakHand durakHand) {
        try {
            durakHand.isRoundLooser(true);
            durakHand.action(DurakAction.Take);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override public boolean surrender(DurakHand durakHand) {
        try {
            durakHand.isRoundLooser(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
