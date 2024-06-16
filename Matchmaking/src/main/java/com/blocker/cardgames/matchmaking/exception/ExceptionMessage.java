package com.blocker.cardgames.matchmaking.exception;

public interface ExceptionMessage {
    String ALREADY_IN_MATCHMAKING_QUEUE_s = "Joiner with uuid: %s already exist in queue.";
    String MULTIPLE_MATCHMAKING_s = "Joiner with uuid: %s tries to join another Match at the same time.";
    String FULL_MATCH_s_s = "Match with uuid: %s already full. Joiner with uuid: %s cannot join.";
    String JOINER_NOT_IN_MATCHMAKING_QUEUE_s = "Joiner with uuid: %s not found.";
    String JOINER_NOT_FOUND_IN_MATCH_s_s = "Joiner with uuid: %s not found in Match with uuid: %s";
}
