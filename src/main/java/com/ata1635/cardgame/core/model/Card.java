package com.ata1635.cardgame.core.model;

public class Card {
    private final String value;
    private final String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        return value + "-" + type;
    }

    public int getValue() {
        switch (value) {
            case "A": return 11;
            case "J":
            case "Q":
            case "K": return 10;
            default: return Integer.parseInt(value); //2-10
        }
    }

    public boolean isAce() {
        return "A".equals(value);
    }

    public String getImagePath() {
        return "/cards/" + toString() + ".png";
    }
}
