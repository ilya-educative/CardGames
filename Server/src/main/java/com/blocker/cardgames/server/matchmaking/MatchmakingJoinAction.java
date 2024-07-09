package com.blocker.cardgames.server.matchmaking;

import com.blocker.cardgames.matchmaking.InMemoryMatchmakingQueue;
import com.blocker.cardgames.server.broadcast.Broadcast;
import com.blocker.cardgames.server.broadcast.BroadcastData;
import org.springframework.stereotype.Component;

@Component
public class MatchmakingJoinAction implements Action {
    private final InMemoryMatchmakingQueue<MatchType, Player> matchmakingQueue;

    public MatchmakingJoinAction(InMemoryMatchmakingQueue<MatchType, Player> matchmakingQueue) {
        this.matchmakingQueue = matchmakingQueue;
    }

    @Override
    @Broadcast(destination = "/topic/matchmaking")
    public BroadcastData execute(MatchmakingRequestMessage requestMessage, Player player) {
        MatchType matchType = MatchType.valueOf(requestMessage.gameType());
        var match = matchmakingQueue.join(matchType, player);
        var list = match.queue().stream()
                .map(Object::toString)
                .toList();
        return new BroadcastData(list, match);
    }
}
