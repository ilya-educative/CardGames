package com.blocker.cardgames.cardmap.bb.cardboardmap;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardmap.api.CardMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class CardBoardMap<C extends Card> extends CardMap<C, Optional<C>> {
    private final Map<C, Optional<C>> cards;

    public CardBoardMap(Map<C, Optional<C>> cards) {
        this.cards = cards;
    }

    @Override public Set<Entry<C, Optional<C>>> entrySet() {
        return cards.entrySet();
    }

    @Override public int size() {
        int keys = cards.keySet().size();
        int values = (int) values()
                .stream()
                .filter(Optional::isPresent)
                .count();
        return keys + values;
    }
}
