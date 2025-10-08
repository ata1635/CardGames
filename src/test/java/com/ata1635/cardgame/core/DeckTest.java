package com.ata1635.cardgame.core;

import com.ata1635.cardgame.core.service.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
