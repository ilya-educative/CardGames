package com.blocker.cardgames.cardcollection.visiblecardcollection;

import com.blocker.cardgames.card.mock.MockCard;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VisibleCardCollectionTest {
    @Test
    void shouldGetByIndex() {
        MockCard[] cards = new MockCard[]{
                MockCard.builder().value(1).build(),
                MockCard.builder().value(2).build(),
                MockCard.builder().value(3).build(),
        };
        VisibleCardCollection<MockCard> cardCollection = new VisibleCardCollection<>(cards);

        MockCard expected = MockCard.builder().value(1).build();
        Optional<MockCard> actual = cardCollection.getByIndex(0);
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(2).build();
        actual = cardCollection.getByIndex(1);
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(3).build();
        actual = cardCollection.getByIndex(2);
        assertEquals(expected, actual.orElseThrow());

        actual = cardCollection.getByIndex(3);
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldRemoveByIndex() {
        MockCard[] cards = new MockCard[]{
                MockCard.builder().value(1).build(),
                MockCard.builder().value(2).build(),
                MockCard.builder().value(3).build(),
        };
        VisibleCardCollection<MockCard> cardCollection = new VisibleCardCollection<>(cards);

        MockCard expected = MockCard.builder().value(2).build();
        Optional<MockCard> actual = cardCollection.removeByIndex(1);
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(3).build();
        actual = cardCollection.removeByIndex(1);
        assertEquals(expected, actual.orElseThrow());

        expected = MockCard.builder().value(1).build();
        actual = cardCollection.removeByIndex(0);
        assertEquals(expected, actual.orElseThrow());

        actual = cardCollection.removeByIndex(3);
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldInsertAtTop() {
        VisibleCardCollection<MockCard> cardCollection = new VisibleCardCollection<>(new MockCard[]{});
        cardCollection.insertAtTop(MockCard.builder().value(1).build());
        cardCollection.insertAtTop(MockCard.builder().value(2).build());
        cardCollection.insertAtTop(MockCard.builder().value(3).build());

        assertEquals(3, cardCollection.size());
    }
}