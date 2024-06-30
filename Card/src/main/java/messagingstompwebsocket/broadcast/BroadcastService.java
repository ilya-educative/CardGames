package messagingstompwebsocket.broadcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastService {
    @Autowired private SimpMessagingTemplate messagingTemplate;

    public void broadcastToAll(String destination, Object payload) {
        messagingTemplate.convertAndSend(destination, payload);
    }
    public void broadcastToUser(String user, String destination, Object payload) {
        messagingTemplate.convertAndSendToUser(user, destination, payload);
    }
    public void broadcastToUsers(List<String> users, String destination, Object payload) {
        users.forEach(user -> messagingTemplate.convertAndSendToUser(user, destination, payload));
    }
}
