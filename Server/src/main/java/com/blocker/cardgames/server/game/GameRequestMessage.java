package com.blocker.cardgames.server.game;

public record GameRequestMessage(Integer cardIndexInHand, Integer cardIndexOnBoard) {
}
