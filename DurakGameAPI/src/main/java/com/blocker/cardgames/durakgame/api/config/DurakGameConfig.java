package com.blocker.cardgames.durakgame.api.config;

import java.util.List;

public class DurakGameConfig {
    private final GameType gameType;
    private final List<GameFeature> gameFeatures;
    private final GameSpeed gameSpeed;
    private final DeckSize deckSize;
    private final TableSize tableSize;
    private final HandSize handSize;
    private final FirstTurn firstTurn;
    private final GameOverCondition gameOverCondition;

    public DurakGameConfig(GameType gameType, List<GameFeature> gameFeatures, GameSpeed gameSpeed, DeckSize deckSize, TableSize tableSize, HandSize handSize, FirstTurn firstTurn, GameOverCondition gameOverCondition) {
        this.gameType = gameType;
        this.gameFeatures = gameFeatures;
        this.gameSpeed = gameSpeed;
        this.deckSize = deckSize;
        this.tableSize = tableSize;
        this.handSize = handSize;
        this.firstTurn = firstTurn;
        this.gameOverCondition = gameOverCondition;
    }

    public static Builder builder() {
        return new Builder();
    }

    public DeckSize deckSize() {
        return deckSize;
    }

    public static class Builder {
        private GameType gameType = GameType.Classic;
        private List<GameFeature> gameFeatures;
        private GameSpeed gameSpeed = GameSpeed.Normal;
        private DeckSize deckSize = DeckSize.ThirtySix;
        private TableSize tableSize = TableSize.Two;
        private HandSize handSize = HandSize.Six;
        private FirstTurn firstTurn = FirstTurn.WithLowestTrumpCard;
        private GameOverCondition gameOverCondition = GameOverCondition.Looser;

        private Builder() {
        }

        public Builder gameType(GameType gameType) {
            this.gameType = gameType;
            return this;
        }

        public Builder gameFeatures(GameFeature... gameFeatures) {
            this.gameFeatures = List.of(gameFeatures);
            return this;
        }

        public Builder gameSpeed(GameSpeed gameSpeed) {
            this.gameSpeed = gameSpeed;
            return this;
        }

        public Builder deckSize(DeckSize deckSize) {
            this.deckSize = deckSize;
            return this;
        }

        public Builder tableSize(TableSize tableSize) {
            this.tableSize = tableSize;
            return this;
        }

        public Builder handSize(HandSize handSize) {
            this.handSize = handSize;
            return this;
        }

        public Builder firstTurn(FirstTurn firstTurn) {
            this.firstTurn = firstTurn;
            return this;
        }

        public Builder gameOverCondition(GameOverCondition gameOverCondition) {
            this.gameOverCondition = gameOverCondition;
            return this;
        }

        public DurakGameConfig build() {
            return new DurakGameConfig(gameType, gameFeatures, gameSpeed, deckSize, tableSize, handSize, firstTurn, gameOverCondition);
        }
    }

    public List<GameFeature> features() {
        return gameFeatures;
    }

    public HandSize handSize() {
        return handSize;
    }
}
