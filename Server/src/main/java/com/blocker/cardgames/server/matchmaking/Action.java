package com.blocker.cardgames.server.matchmaking;

import com.blocker.cardgames.server.broadcast.BroadcastData;

@FunctionalInterface
public interface Action {
    BroadcastData execute(MatchmakingRequestMessage requestMessage, Player player);
}
