package com.blocker.cardgames.server.broadcast;

import java.util.List;

public record BroadcastData(List<String> users, Object payload) {
}
