package com.blocker.cardgames.durakgame.api.classicgame.actionservice;

import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.cardcollection.bb.visiblecardcollection.VisibleCardCollection;
import com.blocker.cardgames.cardmap.bb.cardmap.CardMap;
import com.blocker.cardgames.durakgame.api.action.DurakAction;
import com.blocker.cardgames.durakgame.api.board.DurakBoard;
import com.blocker.cardgames.durakgame.api.config.DurakGameConfig;
import com.blocker.cardgames.durakgame.api.config.GameFeature;
import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.hand.DurakHandState;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassicActionServiceTest {
    private final ClassicActionService target = new ClassicActionService();

    @MethodSource("allowedActionsArguments")
    @ParameterizedTest
    void allowedActions(boolean canAct, DurakHandState handState, Map<StandardCard, Optional<StandardCard>> initialCardsOnBoard, List<StandardCard> cardsInHand, List<GameFeature> gameFeatures, List<DurakAction> expectedAllowedActions) {
        DurakHand durakHand = new DurakHand(new VisibleCardCollection<>(cardsInHand), 1);
        durakHand.canAct(canAct);
        durakHand.state(handState);
        DurakBoard durakBoard = new DurakBoard(new CardMap<>(initialCardsOnBoard));
        DurakGameConfig durakGameConfig = DurakGameConfig.builder()
                .gameFeatures(gameFeatures.toArray(new GameFeature[0]))
                .build();

        List<DurakAction> actualAllowedActions = target.allowedActions(durakHand, durakBoard, durakGameConfig);

        assertEquals(canAct, durakHand.canAct());
        assertEquals(handState, durakHand.state());
        assertArrayEquals(expectedAllowedActions.toArray(), actualAllowedActions.toArray());
    }

    public static Stream<Arguments> allowedActionsArguments() {
        return Stream.of(
                Arguments.of(
                        false,
                        DurakHandState.Attacking,
                        Collections.emptyMap(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList()        
                ),
                Arguments.of(
                        true,
                        DurakHandState.Attacking,
                        Collections.emptyMap(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        List.of(DurakAction.Pass)
                ),
                Arguments.of(
                        true,
                        DurakHandState.Attacking,
                        Collections.emptyMap(),
                        new ArrayList<>(List.of(StandardCard.sixOfSpades())),
                        Collections.emptyList(),
                        List.of(DurakAction.Attack)
                ),
                Arguments.of(
                        true,
                        DurakHandState.Attacking,
                        new HashMap<>(Map.of(StandardCard.sixOfSpades(), Optional.empty())),
                        new ArrayList<>(List.of(StandardCard.sixOfSpades())),
                        Collections.emptyList(),
                        List.of(DurakAction.Attack, DurakAction.Pass)
                ),
                Arguments.of(
                        true,
                        DurakHandState.Defending,
                        new HashMap<>(Map.of(StandardCard.sixOfSpades(), Optional.empty())),
                        new ArrayList<>(List.of(StandardCard.sixOfSpades())),
                        Collections.emptyList(),
                        List.of(DurakAction.Defend, DurakAction.Take)
                ),
                Arguments.of(
                        true,
                        DurakHandState.Defending,
                        new HashMap<>(Map.of(StandardCard.sixOfSpades(), Optional.empty())),
                        new ArrayList<>(List.of(StandardCard.sixOfSpades())),
                        List.of(GameFeature.Transfer),
                        List.of(DurakAction.Defend, DurakAction.Take, DurakAction.Transfer)
                )
        );
    }
}
