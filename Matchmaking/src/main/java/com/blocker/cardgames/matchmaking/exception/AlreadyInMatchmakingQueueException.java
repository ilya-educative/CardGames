package com.blocker.cardgames.matchmaking.exception;

/**
 * Thrown when the same Joiner UUID exist in the same match. */
public class AlreadyInMatchmakingQueueException extends RuntimeException {
    public AlreadyInMatchmakingQueueException(String message) {
        super(message);
    }
}
