package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
        assertThat(blackjack.getPlayerHand()).hasSize(2);
    }

    @Test
    @DisplayName("Hidden card is dealt do dealer")
    void hiddenCard() {
        Blackjack blackjack = new Blackjack(fixedDeck);
        assertThat(blackjack.getHiddenCard()).isNotNull();
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

    @Nested
    class CardValuesTest {
        @Test
        @DisplayName("Card sum value of Dealer and Player are correct")
        void cardSum() {
            Blackjack blackjack = new Blackjack(fixedDeck);
            assertThat(blackjack.getDealerSum()).isEqualTo(13);
            assertThat(blackjack.getPlayerSum()).isEqualTo(16);
        }

        @Test
        @DisplayName("Card sum value of Player is correct after hitting once")
        void correctPlayerSum() {
            Blackjack blackjack = new Blackjack(fixedDeck);
            blackjack.playerHit();
            assertThat(blackjack.getPlayerSum()).isEqualTo(16); //not 26 because adjustForAces();
        }

        @Test
        @DisplayName("Card sum value of Dealer is correct after hitting once")
        void correctDealerSum() {
            Blackjack blackjack = new Blackjack(fixedDeck);
            blackjack.dealerHit();
            assertThat(blackjack.getDealerSum()).isEqualTo(23);
        }
    }
}
