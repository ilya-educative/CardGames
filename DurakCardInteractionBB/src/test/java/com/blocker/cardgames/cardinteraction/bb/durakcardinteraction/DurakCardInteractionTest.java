package com.blocker.cardgames.cardinteraction.bb.durakcardinteraction;

import com.blocker.cardgames.card.bb.standardcard.Rank;
import com.blocker.cardgames.card.bb.standardcard.StandardCard;
import com.blocker.cardgames.card.bb.standardcard.Suit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DurakCardInteractionTest {

    @ParameterizedTest
    @MethodSource("argumentsForDurakCardInteraction")
    void shouldTestDurakCardInteraction(Suit trump, StandardCard defendingCard, StandardCard attackingCard, boolean expected) {
        DurakCardInteraction cardInteraction = new DurakCardInteraction(trump);

        boolean actual = cardInteraction.test(defendingCard, attackingCard);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argumentsForDurakCardInteraction() {
        return Stream.of(
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Six).suit(Suit.Diamonds).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Six).suit(Suit.Hearts).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), true),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Hearts).build(), false),

                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Five).suit(Suit.Diamonds).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Five).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Five).suit(Suit.Hearts).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), true),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Five).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Hearts).build(), false),

                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Seven).suit(Suit.Diamonds).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Seven).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), true),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Seven).suit(Suit.Hearts).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Clubs).build(), true),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Seven).suit(Suit.Clubs).build(), StandardCard.builder().rank(Rank.Six).suit(Suit.Hearts).build(), false),

                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Joker).suit(Suit.Hearts).build(), StandardCard.builder().rank(Rank.Ace).suit(Suit.Hearts).build(), true),
                Arguments.of(Suit.Spades, StandardCard.builder().rank(Rank.Joker).suit(Suit.Hearts).build(), StandardCard.builder().rank(Rank.Ace).suit(Suit.Spades).build(), false),
                Arguments.of(Suit.Hearts, StandardCard.builder().rank(Rank.Joker).suit(Suit.Spades).build(), StandardCard.builder().rank(Rank.Ace).suit(Suit.Hearts).build(), false),
                Arguments.of(Suit.Spades, StandardCard.builder().rank(Rank.Joker).suit(Suit.Spades).build(), StandardCard.builder().rank(Rank.Ace).suit(Suit.Spades).build(), true)
        );
    }
}