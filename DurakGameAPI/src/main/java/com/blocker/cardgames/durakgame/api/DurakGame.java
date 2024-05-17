package com.blocker.cardgames.durakgame.api;

import com.blocker.cardgames.card.bb.standardcard.Suit;

import java.util.List;

public interface DurakGame {
    /* OnInitialization() */
    /*deck*/ Object setDeck(/*rules*/);
    void shuffleDeck(/*deck*/);
    void setTrump(/*deck*/);
    Suit getTrump(/*deck*/);

    default void onRoundStart(/*deck, table, round, rules*/) {
        switchAttackersHandStateToWaiting();
        splitCardsFromDeckToHands();
        setHandStateToAttacking();
        setHandStateToWaiting();
        addHandToTurns();
        clearRoundLooserHandState();
    }
    void switchAttackersHandStateToWaiting(/* table */);
    void splitCardsFromDeckToHands(/* deck, listOfHands, rules */);
    @Deprecated
    int defineWhoStartsFirst(/* listOfHands, rules */);
    void setHandStateToAttacking(/* table */);
    void setHandStateToWaiting(/* table */);
    @Deprecated
    void addHandToTurns(/* round, hand */);
    void clearRoundLooserHandState(/* listOfHands */);

    List<?> getAllowedActionsForHand(/*hand, board, rules*/);
    <T> T createAttackAction(/*card, hand, board*/);
    <T> T createDefendAction(/*attackingCard, defendingCard, hand, board, cardInteraction*/);
    <T> T createPassAction();
    <T> T createTakeAction(/*hand*/);
    @Deprecated
    void updateNextTurns(/*?-previous action, round, table, rules*/);

    default void onRoundEnd(/*board*/) {
        clearCardsFromBoard();
    }
    void clearCardsFromBoard(/*board*/);

    boolean endGameCondition(/*table*/);
}
