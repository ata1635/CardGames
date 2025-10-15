package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;
import com.ata1635.cardgame.core.service.Deck;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private final Deck deck;
    private Card hiddenCard;

    private ArrayList<Card> dealerHand;
    private ArrayList<Card> playerHand;

    private int dealerSum;
    private int playerSum;
    private int dealerAceCount; //devalue the Ace from 11 to 1
    private int playerAceCount;

    public Blackjack() {
        deck = new Deck();
        deck.shuffleDeck();
        startGame();
    }

    //constructor for testing
    public Blackjack(Deck custonDeck) {
        this.deck = custonDeck;
        startGame();
    }

    public void startGame() {
        //dealer
        dealerHand = new ArrayList<Card>();
        dealerSum = 0;
        dealerAceCount = 0;

        hiddenCard = deck.drawCard();
        dealerSum += hiddenCard.getValue();
        dealerAceCount += hiddenCard.isAce() ? 1 : 0;

        Card card = deck.drawCard(); //dealer only draws one card
        dealerSum += card.getValue();
        dealerAceCount += card.isAce() ? 1 : 0;
        dealerHand.add(card);
        adjustDealerAce();

        //player
        playerHand = new ArrayList<Card>();
        playerSum = 0;
        playerAceCount = 0;

        for (int i = 0; i < 2; i++) { //player draws 2 cards at start
            card = deck.drawCard();
            playerSum += card.getValue();
            playerAceCount += card.isAce() ? 1 : 0;
            playerHand.add(card);
        }
        adjustPlayerAce();
        printHands();
    }

    public Card playerHit() {
        Card card = deck.drawCard();
        playerHand.add(card);
        playerSum += card.getValue();
        playerAceCount += card.isAce() ? 1 : 0;
        adjustPlayerAce();
        printHands();
        return card;
    }

    public Card dealerHit() {
        Card card = deck.drawCard();
        dealerHand.add(card);
        dealerSum += card.getValue();
        dealerAceCount += card.isAce() ? 1 : 0;
        adjustDealerAce();
        printHands();
        return card;
    }

    private void adjustPlayerAce() {
        while (playerSum > 21 && playerAceCount > 0) {
            playerSum -= 10;
            playerAceCount--;
        }
    }

    private void adjustDealerAce() {
        while (dealerSum > 21 && dealerAceCount > 0) {
            dealerSum -= 10;
            dealerAceCount--;
        }
    }

    public boolean isPlayerBust() {
        return playerSum > 21;
    }

    public void dealerFinalHits() {
        while (dealerSum < 17) {
            Card card = deck.drawCard();
            dealerSum += card.getValue();
            dealerAceCount += card.isAce() ? 1 : 0;
            dealerHand.add(card);
            printHands();
        }
    }

    public void printHands() {
        System.out.println("DEALER:\n" + hiddenCard + "\n"
                + dealerHand + "\n" + dealerSum + "\n" + dealerAceCount + "\n");
        System.out.println("PLAYER:\n" + playerHand + "\n" + playerSum + "\n" + playerAceCount);
        System.out.println("\n ---------- \n");
    }

    public List<Card> getDealerHand() { return dealerHand; }
    public List<Card> getPlayerHand() { return playerHand; }
    public Card getHiddenCard() { return hiddenCard; }
    public int getDealerAceCount() { return dealerAceCount; }
    public int getPlayerAceCount() { return playerAceCount; }
    public int getDealerSum() { return dealerSum; }
    public int getPlayerSum() { return playerSum; }

}
