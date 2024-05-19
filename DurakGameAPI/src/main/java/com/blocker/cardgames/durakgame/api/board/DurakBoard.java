package com.blocker.cardgames.durakgame.api.board;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardmap.bb.cardmap.CardMap;

import java.util.List;
import java.util.Optional;

public final class DurakBoard {
    private final CardMap<StandardCard> board;

    public DurakBoard(CardMap<StandardCard> board) {
        this.board = board;
    }

    public boolean isEmpty() {
        return board.isEmpty();
    }

    public void attackWith(StandardCard attackingCard) {
        board.put(attackingCard, Optional.empty());
    }

    public boolean canAttackWith(StandardCard attackingCard) {
        return board.isEmpty() || getCardsOnBoard()
                .stream()
                .anyMatch(cardOnboard -> cardOnboard.rank() == attackingCard.rank());
    }

    private List<StandardCard> getCardsOnBoard() {
        return board.getCards();
    }

    public void defendAgainst(StandardCard attackingCard, StandardCard defendingCard) {
        board.put(attackingCard, Optional.ofNullable(defendingCard));
    }

    public List<StandardCard> getCards() {
        return board.getCards();
    }

    public void clear() {
        board.clear();
    }

    public boolean hasCards() {
        return board.hasCards();
    }
}
