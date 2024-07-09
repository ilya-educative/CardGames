package com.blocker.cardgames.server.matchmaking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@SuppressWarnings("unused")
public class MatchmakingController {
    private final static Logger log = LoggerFactory.getLogger(MatchmakingController.class);

    private final MatchmakingService matchmakingService;

    public MatchmakingController(MatchmakingService matchmakingService) {
        this.matchmakingService = matchmakingService;
    }

    @SendTo("/topic/matchmaking")
    public Object matchmakingNotification(@Payload Object message) {
        log.info("Matchmaking notification received: {}", message);
        // fixme: check if this method is needed at all
        return message;
    }

    @MessageMapping("/matchmaking/{action}")
    public void matchmakingRequest(
            @DestinationVariable MatchmakingAction action,
            @Payload(required = false) MatchmakingRequestMessage message,
            Principal principal) {
        log.info("Matchmaking message received: {}, {}", action, message);
        matchmakingService.handleClientMessage(action, message, principal.getName());
    }
}
