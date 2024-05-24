package com.blocker.cardgames.table;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Interface representing a table where any type can occupy table slots.
 *
 * @param <T> The type of data to occupy slots at the table.
 */
public abstract class Table<T> {
    private final int size;

    protected Table(int size) {
        this.size = size;
    }

    /**
     * Allows to leave from the table slot.
     *
     * @param id The unique identifier of the slot at the table.
     * @return {@code true} if the slot was successfully vacated, {@code false} otherwise.
     */
    protected abstract boolean leave(int id);

    /**
     * Allows a type to join the table.
     *
     * @param id   Table slot id.
     * @param type The type to join at the table.
     * @return {@code true} if the type successfully joined the table, {@code false} otherwise.
     */
    protected abstract boolean join(int id, T type);

    /**
     * Allows a type to join the table on the first available slot if exists.
     *
     * @param type The type to join the table.
     * @return {@code true} if the type successfully joined the table, {@code false} otherwise.
     */
    public boolean join(T type) {
        if (firstAvailableSlot().isPresent()) {
            int id = firstAvailableSlot().get();
            return join(id, type);
        } else return false;
    }

    /**
     * Finds the first available slot at the table.
     *
     * @return An {@code Optional} containing the ID of the first available slot, or empty if no slot is available.
     */
    protected abstract Optional<Integer> firstAvailableSlot();

    /**
     * Finds the slot id of a type that satisfies the given condition.
     *
     * @param predicate The condition to be satisfied by the type.
     * @return An {@code Optional} containing the slot id of the type that satisfies the condition, or empty if no such type is found.
     */
    protected abstract Optional<Integer> findSlotBy(Predicate<T> predicate);

    /**
     * Finds type by id
     *
     * @param id represents id for table position
     * @return {@code Optional} containing the type by id
     */
    protected abstract Optional<T> findById(int id);

    /**
     * Finds a type that satisfies the given condition.
     *
     * @param predicate The condition to be satisfied by the type.
     * @return An {@code Optional} containing the type that satisfies the condition, or empty if no such type is found.
     */
    protected abstract Optional<T> findFirstBy(Predicate<T> predicate);

    /**
     * Amount of slots at the table
     *
     * @return Amount of slots at the table.
     */
    public final int size() {
        return size;
    }

    /**
     * Retrieves a list of available types at the table slots.
     *
     * @return A {@code List} containing all available types at the table.
     */
    protected abstract List<T> availableTypes();

    /**
     * Finds all types that satisfy the given condition.
     *
     * @param predicate The condition to be satisfied by the types.
     * @return A {@code List} containing all types that satisfy the condition.
     */
    public List<T> findBy(Predicate<T> predicate) {
        return availableTypes()
                .stream()
                .filter(predicate)
                .toList();
    }

    /**
     * Computes the next slot id.
     *
     * @param id The slot id of the current type.
     * @return The slot id of the next type. Returns first slot if last slot is reached otherwise returns next slot.
     */
    protected final int nextId(int id) {
        return id + 1 >= size() ? 0 : id + 1;
    }
}
