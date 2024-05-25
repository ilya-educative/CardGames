package com.blocker.cardgames.card.standardcard;

public enum Rank {
    Two("2"), Three("3"), Four("4"), Five("5"),
    Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
    Jack("J"), Queen("Q"), King("K"), Ace("A"),
    Joker("Joker");

    private final String symbol;

    Rank(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static final Rank[] valuesFromTwo = new Rank[]{Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};
    public static final Rank[] valuesFromSix = new Rank[]{Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};
    public static final Rank[] valuesFromNine = new Rank[]{Nine, Ten, Jack, Queen, King, Ace};
}
