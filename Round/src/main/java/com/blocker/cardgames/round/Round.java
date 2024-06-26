package com.blocker.cardgames.round;

import java.util.function.Supplier;

/**
 * Abstract class representing a round.
 */
public abstract class Round {
    /**
     * The unique identifier of the round.
     */
    protected int id;

    protected boolean isRunning;

    /**
     * Constructs a new round and assigns it a unique identifier.
     */
    protected Round() {
    }

    /**
     * Checks if this round is the first round of the game.
     *
     * @return {@code true} if this round is the first round, {@code false} otherwise.
     */
    public final boolean isFirstRound() {
        return id == 0;
    }

    /**
     * Sets the unique identifier of this round. Can be accessed only from {@link Round.Factory}
     */
    final void id(int id) {
        this.id = id;
    }

    /**
     * Retrieves the unique identifier of this round.
     *
     * @return The identifier of this round.
     */
    public final int id() {
        return id;
    }

    /**
     * Checks if this round is currently running.
     *
     * @return {@code true} if this round is running, {@code false} otherwise.
     */
    public final boolean isRunning() {
        return isRunning;
    }

    /**
     * Change state of round.
     */
    public final void isRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Factory class for creating rounds and incrementing their id.
     */
    public static final class Factory {
        private int id = 0;

        /**
         * Creates a new round instance and assigns it a unique identifier.
         *
         * @param roundSupplier The supplier that provides the round instance.
         * @param <T>           The type of the round.
         * @return The newly created round instance.
         */
        public <T extends Round> T create(Supplier<T> roundSupplier) {
            T round = roundSupplier.get();
            round.id(id++);
            return round;
        }
    }
}
