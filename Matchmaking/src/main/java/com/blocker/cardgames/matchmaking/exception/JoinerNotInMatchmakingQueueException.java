package com.blocker.cardgames.matchmaking.exception;

/**
 * Thrown when Joiner is not in a Matchmaking queue. */
public class JoinerNotInMatchmakingQueueException extends RuntimeException {
    public JoinerNotInMatchmakingQueueException(String message) {
        super(message);
    }
}
