package messagingstompwebsocket.matchmaking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MatchmakingController {
    private final static Logger log = LoggerFactory.getLogger(MatchmakingController.class);

    @Autowired private MatchmakingService matchmakingService;

    @ResponseBody
    @PostMapping(Endpoint.MATCHMAKING_POST_JOIN + "/{create-new}")
    public String postJoinMatchmaking(@PathVariable("create-new") boolean createNew) {
        log.info("Received POST: create-new match request with value: " + createNew);
        return matchmakingService.getMatchId(createNew);
    }

    @SendTo(Endpoint.MATCHMAKING_TOPIC)
    public String matchmakingNotification(@Payload String payload) {
        log.info("Notifying users that subscribed on topic: "
                + Endpoint.MATCHMAKING_TOPIC
                + " with payload: "
                + payload);
        return payload;
    }

    @MessageMapping(Endpoint.MATCHMAKING_MESSAGE)
    public void clientMessageHandler(@DestinationVariable String matchId, @DestinationVariable String action, Principal principal) {
        log.info("Received message from client."
                + " matchId: '" + matchId + "'"
                + " action: '" + action + "'"
                + " user: '" + principal.getName() + "'");
        matchmakingService.handleClientMessage(action, matchId, principal.getName());
    }
}
