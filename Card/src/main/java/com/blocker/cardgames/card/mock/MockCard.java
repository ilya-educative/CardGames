package com.blocker.cardgames.card.mock;

import com.blocker.cardgames.card.Card;

import java.util.Objects;

public final class MockCard extends Card {
    private final int value;

    public MockCard(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override public String toString() {
        return String.valueOf(value);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MockCard mockCard = (MockCard) o;
        return value == mockCard.value;
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int value;

        private Builder() {
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public MockCard build() {
            return new MockCard(value);
        }
    }
}
