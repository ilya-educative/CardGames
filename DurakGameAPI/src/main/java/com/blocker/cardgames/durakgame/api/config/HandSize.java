package com.blocker.cardgames.durakgame.api.config;

public enum HandSize {
    Five(5), Six(6), Seven(7);

    private final int value;

    HandSize(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
