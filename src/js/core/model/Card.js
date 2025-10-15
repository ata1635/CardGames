export class Card {
    constructor(value, type) {
        this.value = value;
        this.type = type;
    }

    toString() {
        return `${this.value}-${this.type}`;
    }

    getValue() {
        switch (this.value) {
            case "A": return 11;
            case "J":
            case "Q":
            case "K": return 10;
            default: return parseInt(this.value, 10);
        }
    }

    isAce() {
        return this.value === "A";
    }

    getImagePath() {
        return `/cards/${this.toString()}.png`;
    }
}