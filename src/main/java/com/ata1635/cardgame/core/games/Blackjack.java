package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private Deck deck;

    public Blackjack() {
        deck = new Deck();
        deck.shuffleDeck();

        startGame();
    }

    public void startGame() {

        //dealer
        Card hiddenCard;
        ArrayList<Card> dealerHand;
        int dealerSum;
        int dealerAceCount; //devalue the Ace from 11 to 1

        //player
        ArrayList<Card> playerHand;
        int playerSum;
        int playerAceCount;

    }
}
