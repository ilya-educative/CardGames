package com.blocker.cardgames.durakgame.api.classicgame.boardservice;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.visiblecardcollection.VisibleCardCollection;
import com.blocker.cardgames.cardmap.bb.cardmap.CardMap;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.table.DurakTable;
import com.blocker.cardgames.table.bb.multipleslotstable.MultipleSlotsTable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassicBoardServiceTest {
    private final ClassicBoardService target = new ClassicBoardService();

    @MethodSource("clearBoardArguments")
    @ParameterizedTest
    void clearBoard(
            Map<StandardCard, Optional<StandardCard>> initialCardsOnBoard,
            List<StandardCard> initialCardsInHand,
            boolean expectedIsRoundLooser,
            List<StandardCard> expectedCardsInHand) {
        DurakBoard durakBoard = new DurakBoard(new CardMap<>(initialCardsOnBoard));

        DurakHand actualHand = new DurakHand(new VisibleCardCollection<>(initialCardsInHand), 1);
        actualHand.isRoundLooser(expectedIsRoundLooser);
        Map<Integer, Optional<DurakHand>> hands = Map.of(1, Optional.of(actualHand));
        DurakTable durakTable = new DurakTable(new MultipleSlotsTable<>(hands));

        target.clearBoard(durakBoard, durakTable);

        assertEquals(expectedIsRoundLooser, actualHand.isRoundLooser());
        assertEquals(expectedCardsInHand, actualHand.view());
        assertTrue(durakBoard.isEmpty());
    }

    public static Stream<Arguments> clearBoardArguments() {
        return Stream.of(
                Arguments.of(
                        cardsOnBoard(Map.entry(StandardCard.sixOfSpades(), Optional.of(StandardCard.sevenOfDiamonds()))),
                        new ArrayList<>(),
                        true,
                        new ArrayList<>(List.of(StandardCard.sixOfSpades(), StandardCard.sevenOfDiamonds()))
                ),
                Arguments.of(
                        cardsOnBoard(),
                        new ArrayList<>(),
                        true,
                        new ArrayList<>()
                ),
                Arguments.of(
                        cardsOnBoard(Map.entry(StandardCard.sixOfSpades(), Optional.of(StandardCard.sevenOfDiamonds()))),
                        new ArrayList<>(List.of(StandardCard.eightOfHearts())),
                        true,
                        new ArrayList<>(List.of(StandardCard.eightOfHearts(), StandardCard.sixOfSpades(), StandardCard.sevenOfDiamonds()))
                ),
                Arguments.of(
                        cardsOnBoard(),
                        new ArrayList<>(List.of(StandardCard.eightOfHearts())),
                        true,
                        new ArrayList<>(List.of(StandardCard.eightOfHearts()))
                ),
                Arguments.of(
                        cardsOnBoard(Map.entry(StandardCard.sixOfSpades(), Optional.of(StandardCard.sevenOfDiamonds()))),
                        new ArrayList<>(),
                        false,
                        new ArrayList<>()
                ),
                Arguments.of(
                        cardsOnBoard(),
                        new ArrayList<>(),
                        false,
                        new ArrayList<>()
                ),
                Arguments.of(
                        cardsOnBoard(Map.entry(StandardCard.sixOfSpades(), Optional.of(StandardCard.sevenOfDiamonds()))),
                        new ArrayList<>(List.of(StandardCard.eightOfHearts())),
                        false,
                        new ArrayList<>(List.of(StandardCard.eightOfHearts()))
                ),
                Arguments.of(
                        cardsOnBoard(),
                        new ArrayList<>(List.of(StandardCard.eightOfHearts())),
                        false,
                        new ArrayList<>(List.of(StandardCard.eightOfHearts()))
                )
        );
    }

    @SafeVarargs private static Map<StandardCard, Optional<StandardCard>> cardsOnBoard(Map.Entry<StandardCard, Optional<StandardCard>>... entries) {
        Map<StandardCard, Optional<StandardCard>> cardsOnBoard = new HashMap<>();
        for (Map.Entry<StandardCard, Optional<StandardCard>> entry : entries) {
            cardsOnBoard.put(entry.getKey(), entry.getValue());
        }
        return cardsOnBoard;
    }
}
