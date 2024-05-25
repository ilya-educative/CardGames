package com.blocker.cardgames.card.standardcard;

import java.util.Random;

public enum Suit {
    Hearts("♥", SuitColor.Red), Diamonds("♦", SuitColor.Red),
    Clubs("♣", SuitColor.Black), Spades("♠", SuitColor.Black);

    private final String symbol;
    private final SuitColor color;

    Suit(String symbol, SuitColor color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String symbol() {
        return symbol;
    }

    public SuitColor color() {
        return color;
    }

    public static Suit randomSuit() {
        Random random = new Random();
        Suit[] suits = values();
        return suits[random.nextInt(suits.length)];
    }

    public static final Suit[] redSuits = new Suit[]{Hearts, Diamonds};
    public static final Suit[] blackSuits = new Suit[]{Spades, Clubs};
}
