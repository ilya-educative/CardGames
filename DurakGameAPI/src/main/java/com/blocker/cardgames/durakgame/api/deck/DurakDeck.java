package com.blocker.cardgames.durakgame.api.deck;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.card.bb.standardcard.Suit;
import com.blocker.cardgames.cardcollection.bb.blindcardcollection.BlindCardCollection;

import java.util.Collections;
import java.util.Optional;

public final class DurakDeck {
    private final BlindCardCollection<StandardCard> blindCardCollection;
    private StandardCard trumpCard;
    private Suit trump;

    public DurakDeck(BlindCardCollection<StandardCard> blindCardCollection) {
        this.blindCardCollection = blindCardCollection;
    }

    public int size() {
        return blindCardCollection.size();
    }

    public boolean isEmpty() {
        return blindCardCollection.isEmpty();
    }

    public boolean hasCards() {
        return blindCardCollection.hasCards();
    }

    public StandardCard next() {
        return blindCardCollection.iterator().next();
    }

    public void shuffle() {
        Collections.shuffle(blindCardCollection.getCards());
    }

    public void trump(Suit trump) {
        this.trump = trump;
    }

    public Suit trump() {
        return trump;
    }

    public void trumpCard(StandardCard standardCard) {
        trumpCard = standardCard;
        trump(trumpCard.suit());
    }

    public Optional<StandardCard> trumpCard() {
        return Optional.ofNullable(trumpCard);
    }
}
