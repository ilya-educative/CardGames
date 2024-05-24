package com.blocker.cardgames.table.multipleslottable;

import com.blocker.cardgames.table.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class MultipleSlotsTable<T> extends Table<T> {
    private final Map<Integer, Optional<T>> values;

    public MultipleSlotsTable(int size) {
        super(size);
        this.values = new HashMap<>();
        for (int i = 0; i < size; i++) {
            this.values.put(i, Optional.empty());
        }
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

    @Override public Optional<Integer> findSlotBy(Predicate<T> predicate) {
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

    @Override public Optional<T> findFirstBy(Predicate<T> predicate) {
        return values.values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(predicate)
                .findFirst();
    }

    @Override public List<T> availableTypes() {
        return values.values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
