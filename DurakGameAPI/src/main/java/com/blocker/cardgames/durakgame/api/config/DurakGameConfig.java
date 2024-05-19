package com.blocker.cardgames.durakgame.api.config;

public final class DurakGameConfig {
    private final GameType gameType;
    private final GameFeature[] gameFeatures;

    private final GameSpeed gameSpeed;

    private final DeckSize deckSize;
    private final TableSize tableSize;
    private final HandSize handSize;

    private final FirstTurn firstTurn;
    private final GameOverCondition gameOverCondition;

    public DurakGameConfig(GameType gameType, GameFeature[] gameFeatures, GameSpeed gameSpeed, DeckSize deckSize, TableSize tableSize, HandSize handSize, FirstTurn firstTurn, GameOverCondition gameOverCondition) {
        this.gameType = gameType;
        this.gameFeatures = gameFeatures;
        this.gameSpeed = gameSpeed;
        this.deckSize = deckSize;
        this.tableSize = tableSize;
        this.handSize = handSize;
        this.firstTurn = firstTurn;
        this.gameOverCondition = gameOverCondition;
    }

    public int handSize() {
        return 6;
    }
}
