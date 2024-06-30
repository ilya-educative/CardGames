package com.blocker.cardgames.server.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@SuppressWarnings("unused")
public class GameController {
    private final static Logger log = LoggerFactory.getLogger(GameController.class);

    @SendTo("/topic/game")
    public GameResponseMessage gameNotification(@Payload GameResponseMessage message) {
        log.info("Game notification received: {}", message);
        return message;
    }

    @MessageMapping("/game/{gameId}/{action}")
    public void gameRequest(
            @DestinationVariable String gameId,
            @DestinationVariable GameAction action,
            @Payload(required = false) GameRequestMessage message) {
        log.info("Received game request: {}, {}, {}", gameId, action, message);
    }
}
