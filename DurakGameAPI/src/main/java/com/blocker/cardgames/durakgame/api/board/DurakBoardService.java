package com.blocker.cardgames.durakgame.api.board;

import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface DurakBoardService {
    void clearBoard(DurakBoard durakBoard, DurakTable durakTable);
}
//final class BoardServiceImpl implements BoardService {
//    @Override public void clearBoard(DurakBoard durakBoard, DurakTable durakTable) {
//        if (durakTable.roundLooser().isPresent()) {
//            DurakHand durakHand = durakTable.roundLooser().get();
//            durakBoard.getCards().forEach(durakHand::addCard);
//        } else {
//            durakBoard.clear();
//        }
//    }
//}
