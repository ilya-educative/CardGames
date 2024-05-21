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

    public static Builder builder() {
        return new Builder();
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

    public static StandardCard twoOfHearts() {
        return builder().rank(Rank.Two).suit(Suit.Hearts).build();
    }

    public static StandardCard threeOfHearts() {
        return builder().rank(Rank.Three).suit(Suit.Hearts).build();
    }

    public static StandardCard fourOfHearts() {
        return builder().rank(Rank.Four).suit(Suit.Hearts).build();
    }

    public static StandardCard fiveOfHearts() {
        return builder().rank(Rank.Five).suit(Suit.Hearts).build();
    }

    public static StandardCard sixOfHearts() {
        return builder().rank(Rank.Six).suit(Suit.Hearts).build();
    }

    public static StandardCard sevenOfHearts() {
        return builder().rank(Rank.Seven).suit(Suit.Hearts).build();
    }

    public static StandardCard eightOfHearts() {
        return builder().rank(Rank.Eight).suit(Suit.Hearts).build();
    }

    public static StandardCard nineOfHearts() {
        return builder().rank(Rank.Nine).suit(Suit.Hearts).build();
    }

    public static StandardCard tenOfHearts() {
        return builder().rank(Rank.Ten).suit(Suit.Hearts).build();
    }

    public static StandardCard jackOfHearts() {
        return builder().rank(Rank.Jack).suit(Suit.Hearts).build();
    }

    public static StandardCard queenOfHearts() {
        return builder().rank(Rank.Queen).suit(Suit.Hearts).build();
    }

    public static StandardCard kingOfHearts() {
        return builder().rank(Rank.King).suit(Suit.Hearts).build();
    }

    public static StandardCard aceOfHearts() {
        return builder().rank(Rank.Ace).suit(Suit.Hearts).build();
    }

    public static StandardCard twoOfDiamonds() {
        return builder().rank(Rank.Two).suit(Suit.Diamonds).build();
    }

    public static StandardCard threeOfDiamonds() {
        return builder().rank(Rank.Three).suit(Suit.Diamonds).build();
    }

    public static StandardCard fourOfDiamonds() {
        return builder().rank(Rank.Four).suit(Suit.Diamonds).build();
    }

    public static StandardCard fiveOfDiamonds() {
        return builder().rank(Rank.Five).suit(Suit.Diamonds).build();
    }

    public static StandardCard sixOfDiamonds() {
        return builder().rank(Rank.Six).suit(Suit.Diamonds).build();
    }

    public static StandardCard sevenOfDiamonds() {
        return builder().rank(Rank.Seven).suit(Suit.Diamonds).build();
    }

    public static StandardCard eightOfDiamonds() {
        return builder().rank(Rank.Eight).suit(Suit.Diamonds).build();
    }

    public static StandardCard nineOfDiamonds() {
        return builder().rank(Rank.Nine).suit(Suit.Diamonds).build();
    }

    public static StandardCard tenOfDiamonds() {
        return builder().rank(Rank.Ten).suit(Suit.Diamonds).build();
    }

    public static StandardCard jackOfDiamonds() {
        return builder().rank(Rank.Jack).suit(Suit.Diamonds).build();
    }

    public static StandardCard queenOfDiamonds() {
        return builder().rank(Rank.Queen).suit(Suit.Diamonds).build();
    }

    public static StandardCard kingOfDiamonds() {
        return builder().rank(Rank.King).suit(Suit.Diamonds).build();
    }

    public static StandardCard aceOfDiamonds() {
        return builder().rank(Rank.Ace).suit(Suit.Diamonds).build();
    }

    public static StandardCard twoOfClubs() {
        return builder().rank(Rank.Two).suit(Suit.Clubs).build();
    }

    public static StandardCard threeOfClubs() {
        return builder().rank(Rank.Three).suit(Suit.Clubs).build();
    }

    public static StandardCard fourOfClubs() {
        return builder().rank(Rank.Four).suit(Suit.Clubs).build();
    }

    public static StandardCard fiveOfClubs() {
        return builder().rank(Rank.Five).suit(Suit.Clubs).build();
    }

    public static StandardCard sixOfClubs() {
        return builder().rank(Rank.Six).suit(Suit.Clubs).build();
    }

    public static StandardCard sevenOfClubs() {
        return builder().rank(Rank.Seven).suit(Suit.Clubs).build();
    }

    public static StandardCard eightOfClubs() {
        return builder().rank(Rank.Eight).suit(Suit.Clubs).build();
    }

    public static StandardCard nineOfClubs() {
        return builder().rank(Rank.Nine).suit(Suit.Clubs).build();
    }

    public static StandardCard tenOfClubs() {
        return builder().rank(Rank.Ten).suit(Suit.Clubs).build();
    }

    public static StandardCard jackOfClubs() {
        return builder().rank(Rank.Jack).suit(Suit.Clubs).build();
    }

    public static StandardCard queenOfClubs() {
        return builder().rank(Rank.Queen).suit(Suit.Clubs).build();
    }

    public static StandardCard kingOfClubs() {
        return builder().rank(Rank.King).suit(Suit.Clubs).build();
    }

    public static StandardCard aceOfClubs() {
        return builder().rank(Rank.Ace).suit(Suit.Clubs).build();
    }

    public static StandardCard twoOfSpades() {
        return builder().rank(Rank.Two).suit(Suit.Spades).build();
    }

    public static StandardCard threeOfSpades() {
        return builder().rank(Rank.Three).suit(Suit.Spades).build();
    }

    public static StandardCard fourOfSpades() {
        return builder().rank(Rank.Four).suit(Suit.Spades).build();
    }

    public static StandardCard fiveOfSpades() {
        return builder().rank(Rank.Five).suit(Suit.Spades).build();
    }

    public static StandardCard sixOfSpades() {
        return builder().rank(Rank.Six).suit(Suit.Spades).build();
    }

    public static StandardCard sevenOfSpades() {
        return builder().rank(Rank.Seven).suit(Suit.Spades).build();
    }

    public static StandardCard eightOfSpades() {
        return builder().rank(Rank.Eight).suit(Suit.Spades).build();
    }

    public static StandardCard nineOfSpades() {
        return builder().rank(Rank.Nine).suit(Suit.Spades).build();
    }

    public static StandardCard tenOfSpades() {
        return builder().rank(Rank.Ten).suit(Suit.Spades).build();
    }

    public static StandardCard jackOfSpades() {
        return builder().rank(Rank.Jack).suit(Suit.Spades).build();
    }

    public static StandardCard queenOfSpades() {
        return builder().rank(Rank.Queen).suit(Suit.Spades).build();
    }

    public static StandardCard kingOfSpades() {
        return builder().rank(Rank.King).suit(Suit.Spades).build();
    }

    public static StandardCard aceOfSpades() {
        return builder().rank(Rank.Ace).suit(Suit.Spades).build();
    }
}
