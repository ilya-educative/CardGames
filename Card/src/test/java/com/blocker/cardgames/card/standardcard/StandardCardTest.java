package com.blocker.cardgames.card.standardcard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.blocker.cardgames.card.standardcard.StandardCard.CardsBuilder;
import static com.blocker.cardgames.card.standardcard.StandardCard.aceOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.aceOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.aceOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.aceOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.blackJoker;
import static com.blocker.cardgames.card.standardcard.StandardCard.cardsBuilder;
import static com.blocker.cardgames.card.standardcard.StandardCard.eightOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.eightOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.eightOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.eightOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.fiveOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.fourOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.fourOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.fourOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.fourOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.jackOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.jackOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.jackOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.jackOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.kingOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.kingOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.kingOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.kingOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.nineOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.nineOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.nineOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.nineOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.queenOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.queenOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.queenOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.queenOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.redJoker;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.sevenOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.sixOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.tenOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.tenOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.tenOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.tenOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.threeOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.threeOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.threeOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.threeOfSpades;
import static com.blocker.cardgames.card.standardcard.StandardCard.twoOfClubs;
import static com.blocker.cardgames.card.standardcard.StandardCard.twoOfDiamonds;
import static com.blocker.cardgames.card.standardcard.StandardCard.twoOfHearts;
import static com.blocker.cardgames.card.standardcard.StandardCard.twoOfSpades;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StandardCardTest {
    @MethodSource("argumentsForCardsBuilder")
    @ParameterizedTest
    void shouldReturnArrayWith24Cards(StandardCard[] expected, CardsBuilder cardsBuilder) {
        StandardCard[] actual = cardsBuilder.build();

        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> argumentsForCardsBuilder() {
        return Stream.of(
                Arguments.of(
                        new StandardCard[]{
                                nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts,
                                nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, aceOfDiamonds,
                                nineOfClubs, tenOfClubs, jackOfClubs, queenOfClubs, kingOfClubs, aceOfClubs,
                                nineOfSpades, tenOfSpades, jackOfSpades, queenOfSpades, kingOfSpades, aceOfSpades
                        },
                        cardsBuilder().withSize(CardSize.Small)
                ),
                Arguments.of(
                        new StandardCard[]{
                                sixOfHearts, sevenOfHearts, eightOfHearts, nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts,
                                sixOfDiamonds, sevenOfDiamonds, eightOfDiamonds, nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, aceOfDiamonds,
                                sixOfClubs, sevenOfClubs, eightOfClubs, nineOfClubs, tenOfClubs, jackOfClubs, queenOfClubs, kingOfClubs, aceOfClubs,
                                sixOfSpades, sevenOfSpades, eightOfSpades, nineOfSpades, tenOfSpades, jackOfSpades, queenOfSpades, kingOfSpades, aceOfSpades
                        },
                        cardsBuilder().withSize(CardSize.Medium)
                ),
                Arguments.of(
                        new StandardCard[]{
                                twoOfHearts, threeOfHearts, fourOfHearts, fiveOfHearts, sixOfHearts, sevenOfHearts, eightOfHearts, nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts,
                                twoOfDiamonds, threeOfDiamonds, fourOfDiamonds, fiveOfDiamonds, sixOfDiamonds, sevenOfDiamonds, eightOfDiamonds, nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, aceOfDiamonds,
                                twoOfClubs, threeOfClubs, fourOfClubs, fiveOfClubs, sixOfClubs, sevenOfClubs, eightOfClubs, nineOfClubs, tenOfClubs, jackOfClubs, queenOfClubs, kingOfClubs, aceOfClubs,
                                twoOfSpades, threeOfSpades, fourOfSpades, fiveOfSpades, sixOfSpades, sevenOfSpades, eightOfSpades, nineOfSpades, tenOfSpades, jackOfSpades, queenOfSpades, kingOfSpades, aceOfSpades
                        },
                        cardsBuilder().withSize(CardSize.Full)
                ),
                Arguments.of(
                        new StandardCard[]{
                                nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts,
                                nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, aceOfDiamonds,
                                nineOfClubs, tenOfClubs, jackOfClubs, queenOfClubs, kingOfClubs, aceOfClubs,
                                nineOfSpades, tenOfSpades, jackOfSpades, queenOfSpades, kingOfSpades, aceOfSpades,
                                redJoker, blackJoker
                        },
                        cardsBuilder().withSize(CardSize.Small).withJokers()
                ),
                Arguments.of(
                        new StandardCard[]{
                                nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts,
                                nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, aceOfDiamonds,
                                nineOfClubs, tenOfClubs, jackOfClubs, queenOfClubs, kingOfClubs, aceOfClubs,
                                nineOfSpades, tenOfSpades, jackOfSpades, queenOfSpades, kingOfSpades, aceOfSpades,
                                redJoker, blackJoker
                        },
                        cardsBuilder().withSize(CardSize.Medium).withSize(CardSize.Small).withJokers()
                )
        );
    }
}