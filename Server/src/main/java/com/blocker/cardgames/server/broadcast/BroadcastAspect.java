package com.blocker.cardgames.server.broadcast;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class BroadcastAspect {
    private final static Logger log = LoggerFactory.getLogger(BroadcastAspect.class);

    private final SimpMessagingTemplate messagingTemplate;

    public BroadcastAspect(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Pointcut("@annotation(broadcast)")
    public void broadcastPointcut(Broadcast broadcast) {
    }

    @AfterReturning(pointcut = "broadcastPointcut(broadcast)", returning = "result", argNames = "joinPoint,broadcast,result")
    @SuppressWarnings("unused")
    public void broadcast(JoinPoint joinPoint, Broadcast broadcast, Object result) {
        if (result instanceof BroadcastData data) {
            log.info("broadcast data: {}", data);
            broadcastToUsers(data.users(), broadcast.destination(), data.payload());
        } else {
            log.info("cannot broadcast result because of unrecognizable type: {}", result);
        }
    }

    private void broadcastToUsers(List<String> users, String destination, Object payload) {
        log.info("broadcastToUsers called with users: {}, destination: {}, payload: {}", users, destination, payload);
        users.forEach(user -> messagingTemplate.convertAndSendToUser(user, destination, payload));
    }
}
