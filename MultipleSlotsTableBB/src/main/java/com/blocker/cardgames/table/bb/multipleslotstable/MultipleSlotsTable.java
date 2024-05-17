package com.blocker.cardgames.table.bb.multipleslotstable;

import com.blocker.cardgames.table.api.Table;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public final class MultipleSlotsTable<T> implements Table<T> {
    private final Map<Integer, Optional<T>> values;

    public MultipleSlotsTable(Map<Integer, Optional<T>> values) {
        this.values = values;
    }

    @Override public boolean leave(int id) {
        if (values.get(id).isPresent()) {
            values.put(id, Optional.empty());
            return true;
        }
        return false;
    }

    @Override public boolean join(int id, T type) {
        if (values.get(id).isEmpty()) {
            values.put(id, Optional.ofNullable(type));
            return true;
        }
        return false;
    }

    @Override public Optional<Integer> firstAvailableSlot() {
        return values.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .findFirst();
    }

    @Override public Optional<Integer> findIdBy(Predicate<T> predicate) {
        return values.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPresent())
                .filter(entry -> predicate.test(entry.getValue().get()))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    @Override public Optional<T> findById(int id) {
        return values.get(id);
    }

    @Override public Optional<T> findOneBy(Predicate<T> predicate) {
        return values.values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(predicate)
                .findFirst();
    }

    @Override public int size() {
        return values.keySet().size();
    }

    @Override public List<T> availableTypes() {
        return values.values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
