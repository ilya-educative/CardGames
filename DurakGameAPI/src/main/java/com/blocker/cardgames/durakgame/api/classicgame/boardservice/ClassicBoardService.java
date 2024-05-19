package com.blocker.cardgames.durakgame.api.classicgame.boardservice;

import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.board.DurakBoardService;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

import java.util.Optional;

public final class ClassicBoardService implements DurakBoardService {
    @Override public synchronized void clearBoard(DurakBoard durakBoard, DurakTable durakTable) {
        Optional<DurakHand> optionalRoundLooser = durakTable.roundLooser();
        if (optionalRoundLooser.isPresent()) {
            DurakHand durakHand = optionalRoundLooser.get();
            durakBoard.getCards().forEach(durakHand::addCard);
        }
        durakBoard.clear();
    }
}
