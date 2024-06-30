package com.blocker.cardgames.server.matchmaking;

import com.blocker.cardgames.server.broadcast.Broadcast;
import com.blocker.cardgames.server.broadcast.BroadcastData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchmakingJoinAction implements Action {
    @Override
    @Broadcast(destination = "/topic/matchmaking")
    public BroadcastData execute() {
        return new BroadcastData(List.of("a", "b"), 12);
    }
}
