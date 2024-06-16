package com.blocker.cardgames.matchmaking.exception;

/**
 * Thrown when Joiner tries to join Match which is already full. */
public class FullMatchException extends RuntimeException {
    public FullMatchException(String message) {
        super(message);
    }
}
