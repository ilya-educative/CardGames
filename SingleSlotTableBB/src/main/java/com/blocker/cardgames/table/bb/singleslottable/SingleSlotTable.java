package com.blocker.cardgames.table.bb.singleslottable;

import com.blocker.cardgames.table.api.Table;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public final class SingleSlotTable<T> implements Table<T> {
    private static final int ID = 1;
    private T value;

    @Override public boolean leave(int id) {
        return id == ID;
    }

    @Override public boolean join(int id, T type) {
        if (id == ID && value != null) {
            value = type;
            return true;
        }
        return false;
    }

    @Override public Optional<Integer> firstAvailableSlot() {
        if (value == null) return Optional.of(ID);
        return Optional.empty();
    }

    @Override public Optional<Integer> findIdBy(Predicate<T> predicate) {
        if (value == null) return Optional.empty();
        if (predicate.test(value)) return Optional.of(ID);
        return Optional.empty();
    }

    @Override public Optional<T> findById(int id) {
        return Optional.ofNullable(value);
    }

    @Override public Optional<T> findOneBy(Predicate<T> predicate) {
        if (value == null) return Optional.empty();
        if (predicate.test(value)) return Optional.of(value);
        return Optional.empty();
    }

    @Override public int size() {
        return 1;
    }

    @Override public List<T> availableTypes() {
        return findById(ID).map(List::of).orElse(Collections.emptyList());
    }
}
