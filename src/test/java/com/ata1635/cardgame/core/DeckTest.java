package com.ata1635.cardgame.core;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Nested
    class DeckBuilderTest {

        @Test
        @DisplayName("Deck has 52 cards")
        void testDeckHas52Cards() {
            assertThat(deck.getDeck()).hasSize(52);
        }

        @Test
        @DisplayName("Deck contains no duplicate cards")
        void testAllCardsUnique() {
            List<Card> cards = deck.getDeck();
            Set<String> uniqueCards = cards.stream()
                    .map(Card::toString)
                    .collect(Collectors.toSet());
            assertThat(uniqueCards).hasSize(52);
        }

        @Test
        @DisplayName("Deck contains all value-type combinations exactly once")
        void testAllValuesAndTypesPresent() {
            List<Card> cards = deck.getDeck();
            assertThat(cards).extracting(Card::toString).containsExactlyInAnyOrder(
                    "A-C", "2-C", "3-C", "4-C", "5-C", "6-C", "7-C", "8-C", "9-C", "10-C", "J-C", "Q-C", "K-C",
                    "A-D", "2-D", "3-D", "4-D", "5-D", "6-D", "7-D", "8-D", "9-D", "10-D", "J-D", "Q-D", "K-D",
                    "A-H", "2-H", "3-H", "4-H", "5-H", "6-H", "7-H", "8-H", "9-H", "10-H", "J-H", "Q-H", "K-H",
                    "A-S", "2-S", "3-S", "4-S", "5-S", "6-S", "7-S", "8-S", "9-S", "10-S", "J-S", "Q-S", "K-S"
            );
        }
    }

    @Nested
    class DeckShufflerTest {
        @Test
        @DisplayName("Shuffled deck has 52 cards")
        void testShuffledDeckSize() {
            deck.shuffleDeck();
            assertThat(deck.getDeck()).hasSize(52);
        }

        @Test
        @DisplayName("Shuffled deck contains all original cards")
        void testShuffledDeckContainsAllCards() {
            List<Card> deck2 = new ArrayList<>(deck.getDeck());
            deck.shuffleDeck();
            List<Card> shuffled = deck.getDeck();
            assertThat(shuffled).containsExactlyInAnyOrderElementsOf(deck2);
        }

    }

}
