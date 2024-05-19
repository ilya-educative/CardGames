package com.blocker.cardgames.cardmap.bb.cardmap;

import com.blocker.cardgames.card.api.Card;
import com.blocker.cardgames.cardmap.api.AbstractCardMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CardMap<C extends Card> extends AbstractCardMap<C, Optional<C>> {
    private final Map<C, Optional<C>> cards;

    public CardMap(Map<C, Optional<C>> cards) {
        this.cards = cards;
    }

    @Override public Set<Entry<C, Optional<C>>> entrySet() {
        return cards.entrySet();
    }

    @Override public List<C> getCards() {
        return cards.entrySet().stream()
                .flatMap(entry -> {
                    Stream.Builder<C> builder = Stream.builder();
                    builder.add(entry.getKey());
                    entry.getValue().ifPresent(builder::add);
                    return builder.build();
                })
                .collect(Collectors.toList());
    }
}
