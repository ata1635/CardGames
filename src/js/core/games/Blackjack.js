import { Deck } from '../service/Deck.js';

export class Blackjack {
    constructor(customDeck = null) {
        this.deck = customDeck || new Deck();
        this.deck.shuffleDeck();
        this.startGame();
    }

    startGame() {
        // Dealer
        this.dealerHand = [];
        this.dealerSum = 0;
        this.dealerAceCount = 0;

        this.hiddenCard = this.deck.drawCard();
        this.dealerSum += this.hiddenCard.getValue();
        this.dealerAceCount += this.hiddenCard.isAce() ? 1 : 0;

        const card = this.deck.drawCard(); // Dealer draws 1 card
        this.dealerSum += card.getValue();
        this.dealerAceCount += card.isAce() ? 1 : 0;
        this.dealerHand.push(card);
        this.adjustDealerAce();

        // Player
        this.playerHand = [];
        this.playerSum = 0;
        this.playerAceCount = 0;

        for (let i = 0; i < 2; i++) {
            const playerCard = this.deck.drawCard();
            this.playerSum += playerCard.getValue();
            this.playerAceCount += playerCard.isAce() ? 1 : 0;
            this.playerHand.push(playerCard);
        }
        this.adjustPlayerAce();
        this.printHands();
    }

    playerHit() {
        const card = this.deck.drawCard();
        this.playerHand.push(card);
        this.playerSum += card.getValue();
        this.playerAceCount += card.isAce() ? 1 : 0;
        this.adjustPlayerAce();
        this.printHands();
        return card;
    }

    dealerHit() {
        const card = this.deck.drawCard();
        this.dealerHand.push(card);
        this.dealerSum += card.getValue();
        this.dealerAceCount += card.isAce() ? 1 : 0;
        this.adjustDealerAce();
        this.printHands();
        return card;
    }

    adjustPlayerAce() {
        while (this.playerSum > 21 && this.playerAceCount > 0) {
            this.playerSum -= 10;
            this.playerAceCount--;
        }
    }

    adjustDealerAce() {
        while (this.dealerSum > 21 && this.dealerAceCount > 0) {
            this.dealerSum -= 10;
            this.dealerAceCount--;
        }
    }

    isPlayerBust() {
        return this.playerSum > 21;
    }

    dealerFinalHits() {
        while (this.dealerSum < 17) {
            const card = this.deck.drawCard();
            this.dealerSum += card.getValue();
            this.dealerAceCount += card.isAce() ? 1 : 0;
            this.dealerHand.push(card);
            this.printHands();
        }
    }

    printHands() {
        console.log("DEALER:\n", this.hiddenCard.toString(), "\n", this.dealerHand.map(c => c.toString()), "\nSum:", this.dealerSum, "Aces:", this.dealerAceCount);
        console.log("PLAYER:\n", this.playerHand.map(c => c.toString()), "\nSum:", this.playerSum, "Aces:", this.playerAceCount);
        console.log("\n ---------- \n");
    }

    getDealerHand() {
        return this.dealerHand;
    }

    getPlayerHand() {
        return this.playerHand;
    }

    getHiddenCard() {
        return this.hiddenCard;
    }

    getDealerAceCount() {
        return this.dealerAceCount;
    }

    getPlayerAceCount() {
        return this.playerAceCount;
    }

    getDealerSum() {
        return this.dealerSum;
    }

    getPlayerSum() {
        return this.playerSum;
    }
}