package com.blocker.cardgames.matchmaking;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InMemoryMatchmakingQueueTest {
    @Test
    @Order(1)
    void join() {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);
        MockJoiner joiner = new MockJoiner();

        target.join(MockType.Common, joiner, new MatchConfiguration());

        // assert that we have new queue created for this specific MockType with 1 joiner
        assertEquals(1, target.getMatchesByKey(MockType.Common).size());

        // join one more time and assert that queue contains 2 joiners in this MockType
        MockJoiner anotherJoiner = new MockJoiner();

        target.join(MockType.Common, anotherJoiner, new MatchConfiguration());

        assertEquals(1, target.getMatchesByKey(MockType.Common).size());

        // join another type and assert that new queue is created contained 1 joiner in this MockType
        MockJoiner anotherOneJoiner = new MockJoiner();

        target.join(MockType.Uncommon, anotherOneJoiner, new MatchConfiguration());

        assertEquals(1, target.getMatchesByKey(MockType.Uncommon).size());

        // join the same queue and assert that


    }

    @Test
    @Order(2)
    void leave() {

    }

    @Test
    @Order(3)
    void confirm() {

    }

    @Test
    @Order(4)
    void resetConfirmation() {

    }

    private final static class MockJoiner extends Joiner {}

    private enum MockType {
        Common, Uncommon
    }
}