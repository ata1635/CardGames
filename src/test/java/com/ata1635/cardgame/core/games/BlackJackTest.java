package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class BlackJackTest {

    private Deck fixedDeck;

    @BeforeEach
    void setUp() {
        fixedDeck = new Deck();
        fixedDeck.setDeck(new ArrayList<>(List.of(
                new Card("10", "H"), // first (bottom of deck)
                new Card("A", "S"),
                new Card("5", "D"),
                new Card("K", "C"),
                new Card("3", "S")    // last (top of deck)
        )));
    }

    @Test
    @DisplayName("Correct number of cards are dealt")
    void correctNumberOfCardsDealt() {
        Blackjack blackjack = new Blackjack(fixedDeck);
        assertThat(blackjack.getDealerHand()).hasSize(1);
        assertThat(blackjack.getHiddenCard()).isNotNull();
        assertThat(blackjack.getPlayerHand()).hasSize(2);
    }

    @Test
    @DisplayName("Dealer has no Ace in hand")
    void dealerNoAce() {
        Blackjack blackjack = new Blackjack(fixedDeck);
        assertThat(blackjack.getDealerAceCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Player has an Ace in hand")
    void playerHasAce() {
        Blackjack blackjack = new Blackjack(fixedDeck);
        assertThat(blackjack.getPlayerAceCount()).isEqualTo(1);
    }
}
