package messagingstompwebsocket.matchmaking;

import com.example.messagingstompwebsocket.broadcast.BroadcastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MatchmakingService {
    private final static Logger log = LoggerFactory.getLogger(MatchmakingService.class);

    @Autowired private BroadcastService broadcastService;

    private final Map<String, List<String>> matchesWithUsers = new HashMap<>();

    public void handleClientMessage(String action, String matchId, String user) {
        String payload = switch (MatchmakingAction.valueOf(action)) {
            case Join -> join(matchId, user);
            case Leave -> leave(matchId, user);
        };
        broadcastService.broadcastToUsers(
                matchesWithUsers.get(matchId),
                Endpoint.MATCHMAKING_TOPIC,
                payload);
    }

    private String join(String matchId, String user) {
        log.info("user: '%s' JOINED match: '%s'".formatted(user, matchId));
        matchesWithUsers.get(matchId).add(user);
        return "User: '%s' JOINED match: '%s'".formatted(user, matchId);
    }

    private String leave(String matchId, String user) {
        log.info("user: '%s' LEFT match: '%s'".formatted(user, matchId));
        matchesWithUsers.get(matchId).remove(user);
        return "User: '%s' LEFT match: '%s'".formatted(user, matchId);
    }

    public String getMatchId(boolean createNew) {
        if (createNew) {
            log.info("attempt to create new match");
            String matchId = UUID.randomUUID().toString();
            matchesWithUsers.put(matchId, new ArrayList<>());
            return matchId;
        } else {
            log.info("attempt to reuse existing match");
            return matchesWithUsers.keySet()
                    .stream()
                    .findFirst()
                    .orElseThrow();
        }
    }

    private enum MatchmakingAction {
        Join, Leave
    }
}
