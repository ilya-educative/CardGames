package com.blocker.cardgames.card.standardcard;

import com.blocker.cardgames.card.Card;

import java.util.Objects;

public final class StandardCard extends Card {
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
//        final String color = switch (suit.color()) {
//            case Red -> "\u001B[31m";
//            case Black -> "\u001B[30m";
//        };
//        return color + suit.symbol() + " " + rank.symbol() + "\u001B[0m";
        return "[%s of %s]".formatted(rank.symbol(), suit.name());
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

    public static CardsBuilder cardsBuilder() {
        return new CardsBuilder();
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
            Objects.requireNonNull(rank);
            Objects.requireNonNull(suit);
            return new StandardCard(rank, suit);
        }
    }

    public static final class CardsBuilder {
        private boolean withJokers = false;
        private CardSize cardSize = CardSize.Medium;

        private CardsBuilder() {
        }

        public CardsBuilder withSize(CardSize cardSize) {
            this.cardSize = cardSize;
            return this;
        }

        public CardsBuilder withJokers() {
            withJokers = true;
            return this;
        }

        public StandardCard[] build() {
            int length = this.cardSize.length() + (withJokers ? 2 : 0);
            StandardCard[] cards = new StandardCard[length];
            int index = 0;

            Rank[] ranks = switch (this.cardSize) {
                case Small -> Rank.valuesFromNine;
                case Medium -> Rank.valuesFromSix;
                case Full -> Rank.valuesFromTwo;
            };

            for (Suit suit : Suit.values()) {
                for (Rank rank : ranks) {
                    cards[index++] = builder().rank(rank).suit(suit).build();
                }
            }

            if (withJokers) {
                cards[index++] = redJoker;
                cards[index] = blackJoker;
            }

            return cards;
        }
    }

    public static final StandardCard twoOfHearts = builder().rank(Rank.Two).suit(Suit.Hearts).build();
    public static final StandardCard threeOfHearts = builder().rank(Rank.Three).suit(Suit.Hearts).build();
    public static final StandardCard fourOfHearts = builder().rank(Rank.Four).suit(Suit.Hearts).build();
    public static final StandardCard fiveOfHearts = builder().rank(Rank.Five).suit(Suit.Hearts).build();
    public static final StandardCard sixOfHearts = builder().rank(Rank.Six).suit(Suit.Hearts).build();
    public static final StandardCard sevenOfHearts = builder().rank(Rank.Seven).suit(Suit.Hearts).build();
    public static final StandardCard eightOfHearts = builder().rank(Rank.Eight).suit(Suit.Hearts).build();
    public static final StandardCard nineOfHearts = builder().rank(Rank.Nine).suit(Suit.Hearts).build();
    public static final StandardCard tenOfHearts = builder().rank(Rank.Ten).suit(Suit.Hearts).build();
    public static final StandardCard jackOfHearts = builder().rank(Rank.Jack).suit(Suit.Hearts).build();
    public static final StandardCard queenOfHearts = builder().rank(Rank.Queen).suit(Suit.Hearts).build();
    public static final StandardCard kingOfHearts = builder().rank(Rank.King).suit(Suit.Hearts).build();
    public static final StandardCard aceOfHearts = builder().rank(Rank.Ace).suit(Suit.Hearts).build();

    public static final StandardCard twoOfDiamonds = builder().rank(Rank.Two).suit(Suit.Diamonds).build();
    public static final StandardCard threeOfDiamonds = builder().rank(Rank.Three).suit(Suit.Diamonds).build();
    public static final StandardCard fourOfDiamonds = builder().rank(Rank.Four).suit(Suit.Diamonds).build();
    public static final StandardCard fiveOfDiamonds = builder().rank(Rank.Five).suit(Suit.Diamonds).build();
    public static final StandardCard sixOfDiamonds = builder().rank(Rank.Six).suit(Suit.Diamonds).build();
    public static final StandardCard sevenOfDiamonds = builder().rank(Rank.Seven).suit(Suit.Diamonds).build();
    public static final StandardCard eightOfDiamonds = builder().rank(Rank.Eight).suit(Suit.Diamonds).build();
    public static final StandardCard nineOfDiamonds = builder().rank(Rank.Nine).suit(Suit.Diamonds).build();
    public static final StandardCard tenOfDiamonds = builder().rank(Rank.Ten).suit(Suit.Diamonds).build();
    public static final StandardCard jackOfDiamonds = builder().rank(Rank.Jack).suit(Suit.Diamonds).build();
    public static final StandardCard queenOfDiamonds = builder().rank(Rank.Queen).suit(Suit.Diamonds).build();
    public static final StandardCard kingOfDiamonds = builder().rank(Rank.King).suit(Suit.Diamonds).build();
    public static final StandardCard aceOfDiamonds = builder().rank(Rank.Ace).suit(Suit.Diamonds).build();

    public static final StandardCard twoOfClubs = builder().rank(Rank.Two).suit(Suit.Clubs).build();
    public static final StandardCard threeOfClubs = builder().rank(Rank.Three).suit(Suit.Clubs).build();
    public static final StandardCard fourOfClubs = builder().rank(Rank.Four).suit(Suit.Clubs).build();
    public static final StandardCard fiveOfClubs = builder().rank(Rank.Five).suit(Suit.Clubs).build();
    public static final StandardCard sixOfClubs = builder().rank(Rank.Six).suit(Suit.Clubs).build();
    public static final StandardCard sevenOfClubs = builder().rank(Rank.Seven).suit(Suit.Clubs).build();
    public static final StandardCard eightOfClubs = builder().rank(Rank.Eight).suit(Suit.Clubs).build();
    public static final StandardCard nineOfClubs = builder().rank(Rank.Nine).suit(Suit.Clubs).build();
    public static final StandardCard tenOfClubs = builder().rank(Rank.Ten).suit(Suit.Clubs).build();
    public static final StandardCard jackOfClubs = builder().rank(Rank.Jack).suit(Suit.Clubs).build();
    public static final StandardCard queenOfClubs = builder().rank(Rank.Queen).suit(Suit.Clubs).build();
    public static final StandardCard kingOfClubs = builder().rank(Rank.King).suit(Suit.Clubs).build();
    public static final StandardCard aceOfClubs = builder().rank(Rank.Ace).suit(Suit.Clubs).build();

    public static final StandardCard twoOfSpades = builder().rank(Rank.Two).suit(Suit.Spades).build();
    public static final StandardCard threeOfSpades = builder().rank(Rank.Three).suit(Suit.Spades).build();
    public static final StandardCard fourOfSpades = builder().rank(Rank.Four).suit(Suit.Spades).build();
    public static final StandardCard fiveOfSpades = builder().rank(Rank.Five).suit(Suit.Spades).build();
    public static final StandardCard sixOfSpades = builder().rank(Rank.Six).suit(Suit.Spades).build();
    public static final StandardCard sevenOfSpades = builder().rank(Rank.Seven).suit(Suit.Spades).build();
    public static final StandardCard eightOfSpades = builder().rank(Rank.Eight).suit(Suit.Spades).build();
    public static final StandardCard nineOfSpades = builder().rank(Rank.Nine).suit(Suit.Spades).build();
    public static final StandardCard tenOfSpades = builder().rank(Rank.Ten).suit(Suit.Spades).build();
    public static final StandardCard jackOfSpades = builder().rank(Rank.Jack).suit(Suit.Spades).build();
    public static final StandardCard queenOfSpades = builder().rank(Rank.Queen).suit(Suit.Spades).build();
    public static final StandardCard kingOfSpades = builder().rank(Rank.King).suit(Suit.Spades).build();
    public static final StandardCard aceOfSpades = builder().rank(Rank.Ace).suit(Suit.Spades).build();

    public static final StandardCard redJoker = builder().rank(Rank.Joker).suit(Suit.Hearts).build();
    public static final StandardCard blackJoker = builder().rank(Rank.Joker).suit(Suit.Spades).build();
}
