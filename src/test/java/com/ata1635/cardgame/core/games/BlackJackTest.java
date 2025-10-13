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
                new Card("A", "S"),   // 1st (top)
                new Card("10", "H"),
                new Card("5", "D"),
                new Card("K", "C"),
                new Card("3", "S")    // last (bottom)
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
}
