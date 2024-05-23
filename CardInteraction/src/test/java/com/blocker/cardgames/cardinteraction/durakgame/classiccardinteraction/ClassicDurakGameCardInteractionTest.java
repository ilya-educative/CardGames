package com.blocker.cardgames.cardinteraction.durakgame.classiccardinteraction;

import com.blocker.cardgames.card.standardcard.StandardCard;
import com.blocker.cardgames.card.standardcard.Suit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfHearts;
import static com.blocker.cardgames.card.standardcard.Suit.Hearts;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassicDurakGameCardInteractionTest {

    @ParameterizedTest
    @MethodSource("argumentsForDurakCardInteraction")
    void shouldTestDurakCardInteraction(Suit trump, StandardCard defendingCard, StandardCard attackingCard, boolean expected) {
        ClassicDurakGameCardInteraction cardInteraction = new ClassicDurakGameCardInteraction(trump);

        boolean actual = cardInteraction.test(defendingCard, attackingCard);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argumentsForDurakCardInteraction() {
        return Stream.of(
                Arguments.of(Hearts, sixOfDiamonds(), sixOfClubs(), false),
                Arguments.of(Hearts, sixOfClubs(), sixOfClubs(), false),
                Arguments.of(Hearts, sixOfHearts(), sixOfClubs(), true),
                Arguments.of(Hearts, sixOfClubs(), sixOfHearts(), false),

                Arguments.of(Hearts, fiveOfDiamonds(), sixOfClubs(), false),
                Arguments.of(Hearts, fiveOfClubs(), sixOfClubs(), false),
                Arguments.of(Hearts, fiveOfHearts(), sixOfClubs(), true),
                Arguments.of(Hearts, fiveOfClubs(), sixOfHearts(), false),

                Arguments.of(Hearts, sevenOfDiamonds(), sixOfClubs(), false),
                Arguments.of(Hearts, sevenOfClubs(), sixOfClubs(), true),
                Arguments.of(Hearts, sevenOfHearts(), sixOfClubs(), true),
                Arguments.of(Hearts, sevenOfClubs(), sixOfHearts(), false)
        );
    }
}