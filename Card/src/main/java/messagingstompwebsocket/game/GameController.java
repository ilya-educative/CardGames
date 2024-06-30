package messagingstompwebsocket.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GameController {
    @Autowired private GameService gameService;

    @SendTo("/topic/game")
    public String gameNotification(@Payload String gamePayload) {
        return gamePayload;
    }

    @MessageMapping("/game/{gameId}/{action}")
    public void clientMessageHandler(@DestinationVariable String gameId, @DestinationVariable String action, Principal principal) {
        gameService.handleClientMessage(action, gameId, principal.getName());
    }
}
