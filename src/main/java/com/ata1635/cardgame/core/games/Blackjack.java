package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private Deck deck;
    private Card hiddenCard;

    private ArrayList<Card> dealerHand;
    private int dealerSum;
    private int dealerAceCount; //devalue the Ace from 11 to 1

    private ArrayList<Card> playerHand;
    private int playerSum;
    private int playerAceCount;

    public Blackjack() {
        this.deck = new Deck();
        this.deck.shuffleDeck();
        startGame();
    }

    //constructor for testing
    public Blackjack(Deck custonDeck) {
        this.deck = custonDeck;
        startGame();
    }

    public void startGame() {
        ArrayList<Card> deck = new ArrayList<>(this.deck.getDeck());

        //dealer
        dealerHand = new ArrayList<Card>();
        dealerSum = 0;
        dealerAceCount = 0;

        hiddenCard = deck.remove(deck.size() - 1);
        dealerSum += hiddenCard.getValue();
        dealerAceCount += hiddenCard.isAce() ? 1 : 0;

        Card card = deck.remove(deck.size() - 1); //dealer only draws one card
        dealerSum += card.getValue();
        dealerAceCount += card.isAce() ? 1 : 0;
        dealerHand.add(card);

        System.out.println("DEALER:\n" + hiddenCard + "\n"
                + dealerHand + "\n" + dealerSum + "\n" + dealerAceCount + "\n");

        //player
        playerHand = new ArrayList<Card>();
        playerSum = 0;
        playerAceCount = 0;

        for (int i = 0; i < 2; i++) { //player draws 2 cards at start
            card = deck.remove(deck.size() - 1);
            playerSum += card.getValue();
            playerAceCount += card.isAce() ? 1 : 0;
            playerHand.add(card);
        }

        System.out.println("PLAYER:\n" + playerHand + "\n" + playerSum + "\n" + playerAceCount);
    }

    //getters for testing
    public List<Card> getDealerHand() { return dealerHand; }
    public List<Card> getPlayerHand() { return playerHand; }
    public Card getHiddenCard() { return hiddenCard; }
    public int getDealerAceCount() { return dealerAceCount; }
    public int getPlayerAceCount() { return playerAceCount; }
    public int getDealerSum() { return dealerSum; }
    public int getPlayerSum() { return playerSum; }

}
