package com.blocker.cardgames.durakgame.api.deck;

import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

public interface DurakDeckService {
    DurakDeck createDeck(DurakGameConfig durakGameConfig);

    void shuffle(DurakDeck durakDeck);

    void splitCardsFromDeckToHands(DurakDeck durakDeck, DurakTable durakTable, DurakGameConfig durakGameConfig);
}

