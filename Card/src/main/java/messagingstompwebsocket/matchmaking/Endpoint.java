package messagingstompwebsocket.matchmaking;

public interface Endpoint {
    String WEBSOCKET = "/gs-guide-websocket";

    String MATCHMAKING_POST_JOIN = "/matchmaking";
    String MATCHMAKING_TOPIC = "/topic/matchmaking";
    String USER_MATCHMAKING_TOPIC = "/user/topic/matchmaking";
    String MATCHMAKING_MESSAGE = "/matchmaking/{matchId}/{action}";
}
