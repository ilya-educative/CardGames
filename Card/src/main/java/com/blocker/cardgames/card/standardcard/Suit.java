package com.blocker.cardgames.card.standardcard;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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

    public static List<Suit> allSuits() {
        return List.of(values());
    }

    public static Suit randomSuit() {
        Random random = new Random();
        List<Suit> allSuits = allSuits();
        return allSuits.get(random.nextInt(allSuits.size()));
    }

    public static List<Suit> redSuits() {
        return suitsByColor(SuitColor.Red);
    }

    public static List<Suit> blackSuits() {
        return suitsByColor(SuitColor.Black);
    }

    private static List<Suit> suitsByColor(SuitColor color) {
        return Stream.of(values())
                .filter(suit -> suit.color == color)
                .toList();
    }
}
