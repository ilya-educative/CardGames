package com.blocker.cardgames.durakgame.api.config;

public final class DurakGameConfig {
    public int handSize() {
        return 6;
    }
    // 1. Deck (size 24/36/52/54 if with Jokers')
    // 2. Rules (obi4nij, podkidnoj, perevodnoj, ...)
    // 3. Speed (affects time for turn)
    // 4. Table size (max amount of players in match) (2/3/4/5/6)
    // 5. How many cards to split on each round (5/6/7) (usually depends on rules and deck size)
    // 6. Who starts first (on table slot 'x' or who has the lowest rank for the same suit as trump)
    // 7. End game condition (one looser or tie is allowed (when last 2 cards are placed during one round))
    // 8.
}
