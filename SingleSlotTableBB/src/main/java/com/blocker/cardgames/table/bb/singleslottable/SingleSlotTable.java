package com.blocker.cardgames.table.bb.singleslottable;

import com.blocker.cardgames.table.api.Table;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public final class SingleSlotTable<T> implements Table<T> {
    private static final int ID = 1;
    private Optional<T> value;

    public SingleSlotTable() {
        value = Optional.empty();
    }

    @Override public boolean leave(int id) {
        if (id == ID) {
            value = Optional.empty();
            return true;
        }
        return false;
    }

    @Override public boolean join(int id, T type) {
        if (id == ID && value.isEmpty()) {
            value = Optional.ofNullable(type);
            return true;
        }
        return false;
    }

    @Override public Optional<Integer> firstAvailableSlot() {
        if (value.isEmpty()) return Optional.of(ID);
        return Optional.empty();
    }

    @Override public Optional<Integer> findIdBy(Predicate<T> predicate) {
        if (value.isEmpty()) return Optional.empty();
        if (predicate.test(value.get())) return Optional.of(ID);
        return Optional.empty();
    }

    @Override public Optional<T> findOneBy(Predicate<T> predicate) {
        if (value.isEmpty()) return Optional.empty();
        if (predicate.test(value.get())) return value;
        return Optional.empty();
    }

    @Override public int size() {
        return 1;
    }

    @Override public List<T> availableTypes() {
        return value.map(List::of).orElse(Collections.emptyList());
    }
}
