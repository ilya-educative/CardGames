package com.blocker.cardgames.round;

/**
 * Abstract class representing a round.
 */
public abstract class Round {
    /**
     * The unique identifier of the round.
     */
    protected final int id;

    protected boolean isRunning;

    /**
     * Constructs a new round and assigns it a unique identifier.
     */
    protected Round() {
        id = RoundID.id;
        RoundID.increment();
    }

    /**
     * Checks if this round is the first round of the game.
     *
     * @return {@code true} if this round is the first round, {@code false} otherwise.
     */
    public boolean isFirstRound() {
        return id == 0;
    }

    /**
     * Retrieves the unique identifier of this round.
     *
     * @return The identifier of this round.
     */
    public int id() {
        return id;
    }

    /**
     * Checks if this round is currently running.
     *
     * @return {@code true} if this round is running, {@code false} otherwise.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Change state of round.
     */
    public void isRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Static inner class responsible for generating unique round identifiers.
     */
    private static final class RoundID {
        /**
         * The current round identifier.
         */
        private static int id = 0;

        /**
         * Increments the round identifier to generate a new unique identifier.
         */
        private static void increment() {
            id++;
        }
    }
}
