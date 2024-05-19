package com.blocker.cardgames.durakgame.api;

import com.blocker.cardgames.card.bb.standardcard.Rank;
import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.card.bb.standardcard.Suit;

public final class StandardCardUtility {
    private StandardCardUtility() {
    }

    public static final StandardCard SIX_OF_SPADES = create(Suit.Spades, Rank.Six);
    public static final StandardCard SEVEN_OF_DIAMONDS = create(Suit.Diamonds, Rank.Seven);
    public static final StandardCard EIGHT_OF_HEARTS = create(Suit.Hearts, Rank.Eight);

    private static StandardCard create(Suit suit, Rank rank) {
        return StandardCard
                .builder()
                .rank(rank)
                .suit(suit)
                .build();
    }
}
