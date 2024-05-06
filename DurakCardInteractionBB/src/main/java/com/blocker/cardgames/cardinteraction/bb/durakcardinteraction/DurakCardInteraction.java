package com.blocker.cardgames.cardinteraction.bb.durakcardinteraction;

import com.blocker.cardgames.card.bb.standardcard.Rank;
import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.card.bb.standardcard.Suit;
import com.blocker.cardgames.cardinteraction.api.CardInteraction;

public final class DurakCardInteraction implements CardInteraction<StandardCard> {
    private final Suit trump;

    public DurakCardInteraction(Suit trump) {
        this.trump = trump;
    }

    @Override public boolean test(StandardCard defendingCard, StandardCard attackingCard) {
        if (defendingCard.rank() == Rank.Joker) {
            return attackingCard.suit().color() == defendingCard.suit().color();
        } else if (defendingCard.suit().equals(attackingCard.suit())) {
            return defendingCard.rank().compareTo(attackingCard.rank()) > 0;
        } else return defendingCard.suit().equals(trump);
    }
}
