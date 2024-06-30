package messagingstompwebsocket.game;

import com.example.messagingstompwebsocket.broadcast.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    @Autowired private BroadcastService broadcastService;

    private final Map<String, List<String>> gamesWithUsers = new HashMap<>();

    public void handleClientMessage(String action, String gameId, String name) {
        GameAction gameAction = GameAction.valueOf(action);
        String payload = switch (gameAction) {
            case Attack -> "attack";
            case Defend -> "defend";
            case Pass -> "pass";
            case Take -> "take";
            case Surrender -> "surrender";
        };
        broadcastService.broadcastToUsers(gamesWithUsers.get(gameId), "/topic/game", payload);
    }

    private enum GameAction {
        Attack, Defend, Pass, Take, Surrender
    }
}
