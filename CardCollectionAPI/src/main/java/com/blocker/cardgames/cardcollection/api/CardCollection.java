package com.blocker.cardgames.cardcollection.api;

import com.blocker.cardgames.card.api.Card;

import java.util.AbstractCollection;

/**
 * Represents an abstract collection of cards.
 *
 * <p>
 * This class extends {@link java.util.AbstractCollection} and provides common functionality for collections
 * that hold instances of {@link Card} or its subclasses.
 * </p>
 *
 * <p>
 * Concrete subclasses of {@code CardCollection} can be created to represent different types of card collections.
 * </p>
 *
 * @param <C> The type of card that this collection holds.
 */
public abstract class CardCollection<C extends Card> extends AbstractCollection<C> {
    /**
     * Checks whether the collection contains any cards.
     *
     * @return {@code true} if the collection contains cards, {@code false} otherwise.
     */
    public final boolean hasCards() {
        return !isEmpty();
    }
}
