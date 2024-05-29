package com.blocker.cardgames.round.simpleround;

import com.blocker.cardgames.round.Round;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleRoundTest {
    @Test
    void shouldReturnIsFirstRound() {
        Round.Factory roundFactory = new Round.Factory();
        SimpleRound actual = roundFactory.create(SimpleRound::new);

        assertTrue(actual.isFirstRound());

        actual = roundFactory.create(SimpleRound::new);

        assertFalse(actual.isFirstRound());
        assertEquals(1, actual.id());

        Round.Factory anotherRoundFactory = new Round.Factory();
        actual = anotherRoundFactory.create(SimpleRound::new);

        assertTrue(actual.isFirstRound());

        actual = anotherRoundFactory.create(SimpleRound::new);

        assertFalse(actual.isFirstRound());
        assertEquals(1, actual.id());
    }
}