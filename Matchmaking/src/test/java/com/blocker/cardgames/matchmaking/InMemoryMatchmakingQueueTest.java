package com.blocker.cardgames.matchmaking;

import com.blocker.cardgames.matchmaking.exception.AlreadyInMatchmakingQueueException;
import com.blocker.cardgames.matchmaking.exception.FullMatchException;
import com.blocker.cardgames.matchmaking.exception.JoinerNotFoundInMatchException;
import com.blocker.cardgames.matchmaking.exception.JoinerNotInMatchmakingQueueException;
import com.blocker.cardgames.matchmaking.exception.MultipleMatchmakingException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InMemoryMatchmakingQueueTest {
    @ParameterizedTest
    @MethodSource("joinMethodArguments")
    void join(Map<MockType, List<MockJoiner>> joiners, Map<MockType, Integer> expectedSize) {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);

        joiners.forEach((key, value) -> value.forEach(joiner -> target.join(key, joiner)));

        expectedSize.forEach((key, value) -> assertEquals(value, target.getMatchesByKey(key).size()));
    }

    @ParameterizedTest
    @MethodSource("joinThrowsExceptionMethodArguments")
    void joinThrowsExceptions(Class<? extends Throwable> expectedException,
                              Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>> prerequisites,
                              Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>> action) {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);

        prerequisites.accept(target);

        assertThrows(expectedException, () -> action.accept(target));
    }

    @Test
    void leave() {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);
        MockJoiner joiner = new MockJoiner();
        target.join(MockType.Common, joiner);

        target.leave(joiner);

        assertEquals(1, target.getMatchesByKey(MockType.Common).size());
        assertFalse(target.getMatchesByKey(MockType.Common).get(0).contains(joiner));
    }

    @Test
    void leaveThrowsJoinerNotFoundInMatchException() {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);
        target.join(MockType.Common, new MockJoiner());

        assertThrows(JoinerNotFoundInMatchException.class, () -> target.getMatchesByKey(MockType.Common).get(0)
                .leave(new MockJoiner()));
    }

    @Test
    void leaveThrowsJoinerNotInMatchmakingQueueException() {
        InMemoryMatchmakingQueue<MockType, MockJoiner> target = new InMemoryMatchmakingQueue<>(MockType.class);

        assertThrows(JoinerNotInMatchmakingQueueException.class, () -> target.leave(new MockJoiner()));
    }

    private static Stream<Arguments> joinMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Map.ofEntries(Map.entry(MockType.Common, new ArrayList<>(List.of(new MockJoiner())))),
                        Map.ofEntries(Map.entry(MockType.Common, 1))
                ),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(MockType.Common, new ArrayList<>(List.of(new MockJoiner(), new MockJoiner())))
                        ),
                        Map.ofEntries(Map.entry(MockType.Common, 1))
                ),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(MockType.Common, new ArrayList<>(List.of(new MockJoiner(), new MockJoiner(), new MockJoiner())))
                        ),
                        Map.ofEntries(Map.entry(MockType.Common, 2))
                ),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(MockType.Common, new ArrayList<>(List.of(new MockJoiner(), new MockJoiner(), new MockJoiner())))
                        ),
                        Map.ofEntries(Map.entry(MockType.Common, 2))
                ),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(MockType.Common, new ArrayList<>(List.of(new MockJoiner(), new MockJoiner(), new MockJoiner()))),
                                Map.entry(MockType.Uncommon, new ArrayList<>(List.of(new MockJoiner(), new MockJoiner(), new MockJoiner())))
                        ),
                        Map.ofEntries(
                                Map.entry(MockType.Common, 2),
                                Map.entry(MockType.Uncommon, 2)
                        )
                )
        );
    }

    private static Stream<Arguments> joinThrowsExceptionMethodArguments() {
        MockJoiner joiner = new MockJoiner();
        return Stream.of(
                Arguments.of(
                        AlreadyInMatchmakingQueueException.class,
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> matchmakingQueue.join(MockType.Common, joiner),
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> {
                            matchmakingQueue.getMatchesByKey(MockType.Common).get(0).join(joiner);
                        }
                ),
                Arguments.of(
                        MultipleMatchmakingException.class,
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> matchmakingQueue.join(MockType.Common, joiner),
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> matchmakingQueue.join(MockType.Uncommon, joiner)
                ),
                Arguments.of(
                        FullMatchException.class,
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> {
                            matchmakingQueue.join(MockType.Common, new MockJoiner());
                            matchmakingQueue.join(MockType.Common, new MockJoiner());
                        },
                        (Consumer<InMemoryMatchmakingQueue<MockType, MockJoiner>>) (matchmakingQueue) -> matchmakingQueue.getMatchesByKey(MockType.Common).get(0).join(new MockJoiner())
                )
        );
    }

    private final static class MockJoiner extends Joiner {
    }

    private enum MockType {
        Common, Uncommon
    }
}