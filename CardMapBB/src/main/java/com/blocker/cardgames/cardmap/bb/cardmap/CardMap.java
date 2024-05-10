package com.blocker.cardgames.cardmap.bb.cardmap;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardmap.api.AbstractCardMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class CardMap<C extends Card> extends AbstractCardMap<C, Optional<C>> {
    private final Map<C, Optional<C>> cards;

    public CardMap(Map<C, Optional<C>> cards) {
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
