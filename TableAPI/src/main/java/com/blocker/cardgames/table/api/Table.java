package com.blocker.cardgames.table.api;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Interface representing a table where any type can occupy table slots.
 * @param <T> The type of data to occupy slots at the table.
 */
public interface Table<T> {
    /**
     * Allows to leave from the table slot.
     * @param id The unique identifier of the slot at the table.
     * @return {@code true} if the slot was successfully vacated, {@code false} otherwise.
     */
    boolean leave(int id);

    /**
     * Allows a type to join the table.
     * @param id Table slot id.
     * @param type The type to join at the table.
     * @return {@code true} if the type successfully joined the table, {@code false} otherwise.
     */
    boolean join(int id, T type);

    /**
     * Allows a type to join the table on the first available slot if exists.
     * @param type The type to join the table.
     * @return {@code true} if the type successfully joined the table, {@code false} otherwise.
     */
    default boolean join(T type) {
        if (firstAvailableSlot().isPresent()) {
            int id = firstAvailableSlot().get();
            return join(id, type);
        } else return false;
    }

    /**
     * Finds the first available slot at the table.
     * @return An {@code Optional} containing the ID of the first available slot, or empty if no slot is available.
     */
    Optional<Integer> firstAvailableSlot();

    /**
     * Finds the slot id of a type that satisfies the given condition.
     * @param predicate The condition to be satisfied by the type.
     * @return An {@code Optional} containing the slot id of the type that satisfies the condition, or empty if no such type is found.
     */
    Optional<Integer> findIdBy(Predicate<T> predicate);

    /**
     * Finds a type that satisfies the given condition.
     * @param predicate The condition to be satisfied by the type.
     * @return An {@code Optional} containing the type that satisfies the condition, or empty if no such type is found.
     */
    Optional<T> findOneBy(Predicate<T> predicate);

    /**
     * Amount of slots at the table
     * @return Amount of slots at the table. */
    int size();

    /**
     * Retrieves a list of available types at the table slots.
     * @return A {@code List} containing all available types at the table.
     */
    List<T> availableTypes();

    /**
     * Finds all types that satisfy the given condition.
     * @param predicate The condition to be satisfied by the types.
     * @return A {@code List} containing all types that satisfy the condition.
     */
    default List<T> findBy(Predicate<T> predicate) {
        return availableTypes()
                .stream()
                .filter(predicate)
                .toList();
    }

    /**
     * Computes the next slot id.
     * @param id The slot id of the current type.
     * @return The slot id of the next type. Returns first slot if last slot is reached otherwise returns next slot.
     */
    default int nextId(int id) {
        return id + 1 >= size() ? 0 : id + 1;
    }
}
