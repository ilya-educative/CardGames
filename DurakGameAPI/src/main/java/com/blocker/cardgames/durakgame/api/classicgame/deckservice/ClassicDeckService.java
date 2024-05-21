package com.blocker.cardgames.durakgame.api.classicgame.deckservice;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.blindcardcollection.BlindCardCollection;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.deck.DurakDeck;
import com.blocker.cardgames.durakgame.api.deck.DurakDeckService;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.table.DurakTable;

import java.util.Comparator;
import java.util.List;

public class ClassicDeckService implements DurakDeckService {
    @Override public DurakDeck createDeck(DurakGameConfig durakGameConfig) {
        List<StandardCard> cards = switch (durakGameConfig.deckSize()) {
            case TwentyFour -> StandardCard.listBuilder().with24Cards().build();
            case ThirtySix -> StandardCard.listBuilder().with36Cards().build();
            case FiftyTwo -> StandardCard.listBuilder().with52Cards().build();
        };
        return new DurakDeck(new BlindCardCollection<>(cards));
    }

    @Override public void shuffle(DurakDeck durakDeck) {
        durakDeck.shuffle();
    }

    @Override public synchronized void splitCardsFromDeckToHands(DurakDeck durakDeck, DurakTable durakTable, DurakGameConfig durakGameConfig) {
        splitCards(durakTable.startedRound(), durakDeck, durakGameConfig);

        durakTable.attackers()
                .stream()
                .filter(durakHand -> !durakHand.startedRound())
                .sorted(Comparator.comparingInt(DurakHand::slotId))
                .forEach(durakHand -> splitCards(durakHand, durakDeck, durakGameConfig));

        splitCards(durakTable.defender(), durakDeck, durakGameConfig);
    }

    private void splitCards(DurakHand durakHand, DurakDeck durakDeck, DurakGameConfig durakGameConfig) {
        while (durakHand.size() < durakGameConfig.handSize().value() && durakDeck.hasCards()) {
            StandardCard card = durakDeck.next();
            durakHand.addCard(card);
        }
    }
}
