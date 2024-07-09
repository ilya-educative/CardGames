package com.blocker.cardgames.server.matchmaking;

import com.blocker.cardgames.matchmaking.InMemoryMatchmakingQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchmakingBeanConfig {
    @Bean
    public InMemoryMatchmakingQueue<MatchType, Player> inMemoryMatchmakingQueue() {
        return new InMemoryMatchmakingQueue<>(MatchType.class);
    }
}
