package messagingstompwebsocket.test;

import com.example.messagingstompwebsocket.matchmaking.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.Scanner;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static String URL = "://localhost:8080";
    private String matchId;

    public static void main(String[] args) {
        Client client = new Client();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity("http" + URL + Endpoint.MATCHMAKING_POST_JOIN + "/true", null, String.class);
        client.matchId = response.getBody();
        log.info("received matchId: '%s'".formatted(client.matchId));


        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());

        String url = "ws://localhost:8080/gs-guide-websocket";
        StompSessionHandler sessionHandler = new MyStompSessionHandler(client);
        stompClient.connect(url, sessionHandler);


        log.info("Press Enter to exit . . .");
        new Scanner(System.in).nextLine();
    }

    private static class MyStompSessionHandler extends StompSessionHandlerAdapter {
        private final Client client;

        private final static Logger log = LoggerFactory.getLogger(MyStompSessionHandler.class);

        private MyStompSessionHandler(Client client) {
            this.client = client;
        }

        @Override public void afterConnected(StompSession session, StompHeaders connectedHeaders) {

            log.info("connection established. Attempting to subscribe on topic: %s".formatted(Endpoint.USER_MATCHMAKING_TOPIC));
            session.subscribe(Endpoint.USER_MATCHMAKING_TOPIC, new StompFrameHandler() {
                @Override public Type getPayloadType(StompHeaders headers) {
                    System.out.println("Settings payloadType to String.class");
                    return String.class;
                }

                @Override public void handleFrame(StompHeaders headers, Object payload) {
                    log.info("received message from topic: '%s' with payload: '%s'".formatted(Endpoint.MATCHMAKING_TOPIC, payload));
                }
            });

            log.info("attempting to send message through websocket '%s' + with matchId: '%s' and action '%s'"
                    .formatted(Endpoint.MATCHMAKING_MESSAGE, client.matchId, "Join"));
            session.send("/app/matchmaking/%s/%s".formatted(client.matchId, "Join"), "");
        }

        @Override public void handleFrame(StompHeaders headers, Object payload) {
            log.info("idk what is this but with payload: '%s'".formatted(payload));
        }
    }
}
