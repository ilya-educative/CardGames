package com.blocker.cardgames.cardcollection.blindcardcollection;

import com.blocker.cardgames.card.mock.MockCard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlindCardCollectionTest {
    @Test
    void shouldGetFromTop() {
        MockCard[] cards = new MockCard[]{
                MockCard.builder().value(1).build(),
                MockCard.builder().value(2).build(),
                MockCard.builder().value(3).build(),
        };
        BlindCardCollection<MockCard> cardCollection = new BlindCardCollection<>(cards);

        MockCard expected = MockCard.builder().value(1).build();
        Optional<MockCard> actual = cardCollection.getFromTop();
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(2).build();
        actual = cardCollection.getFromTop();
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(3).build();
        actual = cardCollection.getFromTop();
        assertEquals(expected, actual.orElseThrow());

        actual = cardCollection.getFromTop();
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldShuffle() {
        MockCard[] expected = new MockCard[]{
                MockCard.builder().value(1).build(),
                MockCard.builder().value(2).build(),
                MockCard.builder().value(3).build(),
                MockCard.builder().value(4).build(),
                MockCard.builder().value(5).build(),
                MockCard.builder().value(6).build(),
                MockCard.builder().value(7).build(),
                MockCard.builder().value(8).build(),
                MockCard.builder().value(9).build(),
                MockCard.builder().value(10).build()
        };
        BlindCardCollection<MockCard> cardCollection = new BlindCardCollection<>(expected);

        cardCollection.shuffle();

        MockCard[] actual = new MockCard[10];
        int index = 0;
        while (cardCollection.hasCards()) {
            actual[index++] = cardCollection.getFromTop().orElseThrow();
        }

        assertEquals(expected.length, actual.length);
        assertFalse(Arrays.equals(expected, actual));
        assertTrue(Arrays.asList(expected).containsAll(Arrays.asList(actual)));
        assertTrue(Arrays.asList(actual).containsAll(Arrays.asList(expected)));
    }
}