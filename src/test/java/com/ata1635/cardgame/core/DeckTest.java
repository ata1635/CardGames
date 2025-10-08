package com.ata1635.cardgame.core;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        deck.buildDeck();
    }

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


}
