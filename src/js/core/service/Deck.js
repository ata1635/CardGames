import { Card } from '../model/Card.js';

export class Deck {
    constructor() {
        this.deck = [];
        this.buildDeck();
    }

    getDeck() {
        return [...this.deck];
    }

    setDeck(cards) {
        this.deck = [...cards];
    }

    buildDeck() {
        const values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
        const types = ["C", "D", "H", "S"];
        for (let type of types) {
            for (let value of values) {
                this.deck.push(new Card(value, type));
            }
        }
    }

    shuffleDeck() {
        for (let i = this.deck.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.deck[i], this.deck[j]] = [this.deck[j], this.deck[i]];
        }
    }

    drawCard() {
        if (this.deck.length === 0) throw new Error("Deck is empty");
        return this.deck.pop();
    }
}