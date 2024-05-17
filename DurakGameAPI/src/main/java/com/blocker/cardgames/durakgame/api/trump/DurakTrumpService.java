package com.blocker.cardgames.durakgame.api.trump;

import com.blocker.cardgames.card.bb.standardcard.Suit;
import com.blocker.cardgames.durakgame.api.deck.DurakDeck;

public interface DurakTrumpService {
    void setTrump(DurakDeck durakDeck);

    Suit getTrump(DurakDeck durakDeck);
}
//final class TrumpServiceImpl implements TrumpService {
//    @Override public void setTrump(DurakDeck durakDeck) {
//        if (durakDeck.isEmpty()) {
//            Suit trump = Suit.randomSuit();
//            durakDeck.trump(trump);
//            return;
//        }
//        StandardCard trumpCard = durakDeck.next();
//        durakDeck.trumpCard(trumpCard);
//    }
//
//    @Override public Suit getTrump(DurakDeck durakDeck) {
//        return durakDeck.trump();
//    }
//}
