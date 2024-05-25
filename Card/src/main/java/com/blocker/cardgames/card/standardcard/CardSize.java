package com.blocker.cardgames.card.standardcard;

public enum CardSize {
    Small(24), Medium(36), Full(52);

    private final int value;

    CardSize(int value) {
        this.value = value;
    }

    public int length() {
        return value;
    }
}
