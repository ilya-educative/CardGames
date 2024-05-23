package com.blocker.cardgames.card.standardcard;

import java.util.List;

public enum Rank {
    Two("2"), Three("3"), Four("4"), Five("5"),
    Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
    Jack("J"), Queen("Q"), King("K"), Ace("A"),
    Joker("Joker");

    private final String symbol;

    Rank(String symbol) {
        this.symbol = symbol;
    }

    public static List<Rank> allRanksFromTwo() {
        return List.of(Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace);
    }

    public static List<Rank> allRanksFromSix() {
        return List.of(Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace);
    }

    public static List<Rank> allRanksFromNine() {
        return List.of(Nine, Ten, Jack, Queen, King, Ace);
    }

    public String symbol() {
        return symbol;
    }
}
