package com.blocker.cardgames.matchmaking.exception;

/**
 * Thrown when Joiner UUID is found in different matches. Joiner cannot join multiple Matches at the same time. */
public class MultipleMatchmakingException extends RuntimeException {
    public MultipleMatchmakingException(String message) {
        super(message);
    }
}
