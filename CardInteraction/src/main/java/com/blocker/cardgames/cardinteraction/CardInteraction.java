package com.blocker.cardgames.cardinteraction;

import com.blocker.cardgames.card.Card;

import java.util.function.BiPredicate;

/**
 * A functional interface for defining whether interaction between cards is possible.
 *
 * @param <C> the type of cards involved in the interaction
 */
@FunctionalInterface
public interface CardInteraction<C extends Card> extends BiPredicate<C, C> {
    /**
     * Tests whether a specific interaction can occur between two cards.
     *
     * @param target the target card to interact with
     * @param source the source card initiating the interaction
     * @return {@code true} if the interaction is possible, {@code false} otherwise
     */
    @Override boolean test(C target, C source);
}
