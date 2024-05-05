package com.blocker.cardgames.card.bb.standardcard;

import com.blocker.cardgames.card.api.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StandardCard implements Card {
    private final Rank rank;
    private final Suit suit;

    private StandardCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    @Override public String toString() {
        final String color = switch (suit.color()) {
            case Red -> "\u001B[31m";
            case Black -> "\u001B[30m";
        };
        return color + suit.symbol() + " " + rank.symbol() + "\u001B[0m";
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardCard that = (StandardCard) o;
        return rank == that.rank && suit == that.suit;
    }

    @Override public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public static final class Builder {
        private Rank rank;
        private Suit suit;

        private Builder() {
        }

        public Builder rank(Rank rank) {
            this.rank = rank;
            return this;
        }

        public Builder suit(Suit suit) {
            this.suit = suit;
            return this;
        }

        public StandardCard build() {
            return new StandardCard(rank, suit);
        }
    }

    public static ListBuilder listBuilder() {
        return new ListBuilder();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ListBuilder {
        private final List<StandardCard> cards;

        private ListBuilder() {
            this.cards = new ArrayList<>();
        }

        public ListBuilder with24Cards() {
            List<StandardCard> with36Cards = Suit.allSuits()
                    .stream()
                    .flatMap(suit -> Rank.allRanksFromNine()
                            .stream()
                            .map(rank -> builder()
                                    .rank(rank)
                                    .suit(suit)
                                    .build())
                    )
                    .toList();
            cards.addAll(with36Cards);
            return this;
        }

        public ListBuilder with36Cards() {
            List<StandardCard> with36Cards = Suit.allSuits()
                    .stream()
                    .flatMap(suit -> Rank.allRanksFromSix()
                            .stream()
                            .map(rank -> builder()
                                    .rank(rank)
                                    .suit(suit)
                                    .build())
                    )
                    .toList();
            cards.addAll(with36Cards);
            return this;
        }

        public ListBuilder with52Cards() {
            List<StandardCard> with36Cards = Suit.allSuits()
                    .stream()
                    .flatMap(suit -> Rank.allRanksFromTwo()
                            .stream()
                            .map(rank -> builder()
                                    .rank(rank)
                                    .suit(suit)
                                    .build())
                    )
                    .toList();
            cards.addAll(with36Cards);
            return this;
        }

        public ListBuilder withJokers() {
            StandardCard redJoker = builder()
                    .rank(Rank.Joker)
                    .suit(Suit.Hearts)
                    .build();
            StandardCard blackJoker = builder()
                    .rank(Rank.Joker)
                    .suit(Suit.Spades)
                    .build();
            cards.add(redJoker);
            cards.add(blackJoker);
            return this;
        }

        public List<StandardCard> build() {
            return cards;
        }
    }
}
