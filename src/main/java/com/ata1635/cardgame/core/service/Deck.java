package com.ata1635.cardgame.core.service;

import com.ata1635.cardgame.core.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private final Random random = new Random();

    public Deck() {
        deck = new ArrayList<>();
        buildDeck();
    }

    public List<Card> getDeck() {
        return new ArrayList<Card>(deck);
    }

    public void buildDeck() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }
    }

    public void shuffleDeck() {
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size()); //gives a random Integer 1-52
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard); //switches position with j
            deck.set(j, currentCard); //switches position with i
        }
    }

}
