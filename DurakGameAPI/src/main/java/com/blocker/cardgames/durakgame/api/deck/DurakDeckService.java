package com.blocker.cardgames.durakgame.api.deck;

import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface DurakDeckService {
    void shuffle(DurakDeck durakDeck);

    void splitCardsFromDeckToHands(DurakDeck durakDeck, DurakTable durakTable, DurakGameConfig durakGameConfig);
}
//final class DeckServiceImpl implements DeckService {
//    @Override public void shuffle(DurakDeck durakDeck) {
//        durakDeck.shuffle();
//    }
//
//    @Override public void splitCardsFromDeckToHands(DurakDeck durakDeck, DurakTable durakTable, DurakGameConfig durakGameConfig) {
//        durakTable.getHands().forEach(hand -> {
//            while (hand.size() < durakGameConfig.handSize() && durakDeck.hasCards()) {
//                StandardCard card = durakDeck.next();
//                hand.addCard(card);
//            }
//        });
//    }
//}
