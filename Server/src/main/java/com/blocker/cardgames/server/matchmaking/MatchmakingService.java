package com.blocker.cardgames.server.matchmaking;

import org.springframework.stereotype.Service;

@Service
public class MatchmakingService {
    public void handleClientMessage(MatchmakingAction action, MatchmakingRequestMessage message, String user) {
        switch (action) {
            case Join, Leave, Confirm -> {}
        }
    }
}
