package messagingstompwebsocket.config;

import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class HandshakeHandlerImpl extends DefaultHandshakeHandler {
    private final static Logger log = LoggerFactory.getLogger(HandshakeHandlerImpl.class);

    @Override protected Principal determineUser(
            ServerHttpRequest request,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Handshake established with: [%s]".formatted(randomUUID));
        return new UserPrincipal(randomUUID);
    }
}
