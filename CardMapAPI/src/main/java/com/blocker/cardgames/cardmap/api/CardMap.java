package com.blocker.cardgames.cardmap.api;

import com.blocker.cardgames.card.api.Card;

import java.util.AbstractMap;

/**
 * Represents an abstract mapping of cards to values of arbitrary types.
 * <p>
 * This class extends {@link java.util.AbstractMap} and provides a skeletal implementation
 * of the {@link java.util.Map} interface for storing card objects and their associated values.
 * </p>
 * <p>
 * Concrete subclasses of {@code CardMap} can be created to represent various mappings of cards.
 * </p>
 * <p>
 * The key in this map represents the card object, and the value represents an associated value
 * of arbitrary type.
 * </p>
 *
 * @param <K> The type of card that serves as the key in this map.
 * @param <V> The type of values stored in this map.
 */
public abstract class CardMap<K extends Card, V> extends AbstractMap<K, V> {
}
