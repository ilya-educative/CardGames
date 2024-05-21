package com.blocker.cardgames.durakgame.api.classicgame.deckservice;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.blindcardcollection.BlindCardCollection;
import com.blocker.cardgames.cardcollection.bb.visiblecardcollection.VisibleCardCollection;
import com.blocker.cardgames.durakgame.api.config.DeckSize;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.config.HandSize;
import com.blocker.cardgames.durakgame.api.deck.DurakDeck;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.hand.DurakHandState;
import com.blocker.cardgames.durakgame.api.table.DurakTable;
import com.blocker.cardgames.table.bb.multipleslotstable.MultipleSlotsTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassicDeckServiceTest {
    private final ClassicDeckService target = new ClassicDeckService();

    @MethodSource("createDeckArguments")
    @ParameterizedTest
    void createDeck(DeckSize deckSize, int expectedDeckSize) {
        DurakGameConfig durakGameConfig = DurakGameConfig.builder()
                .deckSize(deckSize)
                .build();

        DurakDeck actualDeck = target.createDeck(durakGameConfig);

        assertEquals(expectedDeckSize, actualDeck.size());
    }

    public static Stream<Arguments> createDeckArguments() {
        return Stream.of(
                Arguments.of(DeckSize.TwentyFour, 24),
                Arguments.of(DeckSize.ThirtySix, 36),
                Arguments.of(DeckSize.FiftyTwo, 52)
        );
    }

    @Test
    void shuffle() {
        List<StandardCard> expectedCards = StandardCard.listBuilder().with36Cards().build();

        DurakDeck durakDeck = new DurakDeck(new BlindCardCollection<>(expectedCards));

        target.shuffle(durakDeck);

        assertEquals(expectedCards.size(), durakDeck.size());
        assertTrue(expectedCards.containsAll(durakDeck.view()));
        assertTrue(durakDeck.view().containsAll(expectedCards));
    }

    @Test
    void splitCardsFromDeckToHands() {
        List<StandardCard> cardsInDeck = new ArrayList<>(Arrays.asList(
                StandardCard.queenOfClubs(), StandardCard.queenOfDiamonds(),
                StandardCard.kingOfClubs(), StandardCard.kingOfDiamonds(),
                StandardCard.aceOfClubs(), StandardCard.aceOfDiamonds()
        ));
        BlindCardCollection<StandardCard> blindCardCollection = new BlindCardCollection<>(cardsInDeck);
        DurakDeck durakDeck = new DurakDeck(blindCardCollection);

        List<StandardCard> cardsForDurakHand0 = new ArrayList<>(List.of(
                StandardCard.twoOfClubs(), StandardCard.twoOfDiamonds(), StandardCard.twoOfHearts(), StandardCard.twoOfSpades()
        ));
        DurakHand durakHand0 = new DurakHand(new VisibleCardCollection<>(cardsForDurakHand0), 1);
        durakHand0.state(DurakHandState.Attacking);
        durakHand0.startedRound(true);

        List<StandardCard> cardsForDurakHand1 = new ArrayList<>(List.of(
                StandardCard.threeOfClubs(), StandardCard.threeOfDiamonds(), StandardCard.threeOfHearts()
        ));
        DurakHand durakHand1 = new DurakHand(new VisibleCardCollection<>(cardsForDurakHand1), 2);
        durakHand1.state(DurakHandState.Defending);

        List<StandardCard> cardsForDurakHand2 = new ArrayList<>(List.of(
                StandardCard.fourOfClubs(), StandardCard.fourOfDiamonds(), StandardCard.fourOfHearts(), StandardCard.fourOfSpades()
        ));
        DurakHand durakHand2 = new DurakHand(new VisibleCardCollection<>(cardsForDurakHand2), 3);
        durakHand2.state(DurakHandState.Attacking);

        Map<Integer, Optional<DurakHand>> handsAtTable = new HashMap<>();
        handsAtTable.put(1, Optional.of(durakHand0));
        handsAtTable.put(2, Optional.of(durakHand1));
        handsAtTable.put(3, Optional.of(durakHand2));
        DurakTable durakTable = new DurakTable(new MultipleSlotsTable<>(handsAtTable));

        DurakGameConfig durakGameConfig = DurakGameConfig.builder()
                .handSize(HandSize.Six)
                .build();

        target.splitCardsFromDeckToHands(durakDeck, durakTable, durakGameConfig);

        assertEquals(6, durakHand0.size());
        assertTrue(durakHand0.view().containsAll(List.of(StandardCard.queenOfClubs(), StandardCard.queenOfDiamonds())));
        assertEquals(5, durakHand1.size());
        assertTrue(durakHand1.view().containsAll(List.of(StandardCard.aceOfClubs(), StandardCard.aceOfDiamonds())));
        assertEquals(6, durakHand2.size());
        assertTrue(durakHand2.view().containsAll(List.of(StandardCard.kingOfClubs(), StandardCard.kingOfDiamonds())));
        assertEquals(0, durakDeck.size());
        assertTrue(durakDeck.view().containsAll(List.of(StandardCard.aceOfClubs(), StandardCard.aceOfDiamonds())));
    }
}