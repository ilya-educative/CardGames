package com.blocker.cardgames.round.simpleround;

import com.blocker.cardgames.round.Round;

import java.util.function.Supplier;

/**
 * Represents a simple round.
 *
 * <p>Instances of this class should not be created directly using the constructor.
 * Instead, use the {@link Round.Factory#create(Supplier)} method to create instances.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * Round.Factory factory = new Round.Factory();
 * SimpleRound round = factory.create(SimpleRound::new);
 * }
 * </pre>
 */
public final class SimpleRound extends Round {
    /**
     * <p>Instances of this class should not be created directly using the constructor.
     * Instead, use the {@link Round.Factory#create(Supplier)} method to create instances.</p>
     *
     * <p>Example usage:</p>
     * <pre>
     * {@code
     * Round.Factory factory = new Round.Factory();
     * SimpleRound round = factory.create(SimpleRound::new);
     * }
     * </pre>
     */
    public SimpleRound() {
    }
}
