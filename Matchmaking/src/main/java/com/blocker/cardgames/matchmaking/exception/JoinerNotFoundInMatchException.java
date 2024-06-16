package com.blocker.cardgames.matchmaking.exception;

/**
 * Thrown when Joiner not found in Match. */
public class JoinerNotFoundInMatchException extends RuntimeException {
    public JoinerNotFoundInMatchException(String message) {
        super(message);
    }
}
