package com.blocker.cardgames.cardinteraction.durakgame.classiccardinteraction;

import com.blocker.cardgames.card.standardcard.StandardCard;
import com.blocker.cardgames.card.standardcard.Suit;
import com.blocker.cardgames.cardinteraction.CardInteraction;

public final class ClassicDurakGameCardInteraction implements CardInteraction<StandardCard> {
    private final Suit trump;

    public ClassicDurakGameCardInteraction(Suit trump) {
        this.trump = trump;
    }

    @Override public boolean test(StandardCard defendingCard, StandardCard attackingCard) {
        if (attackingCard.suit().equals(defendingCard.suit())) {
            return defendingCard.rank().compareTo(attackingCard.rank()) > 0;
        } else return defendingCard.suit().equals(trump);
    }
}
