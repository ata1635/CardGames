package com.ata1635.cardgame.core.model;

public class Card {
    private String value;
    private String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        return value + "-" + type;
    }

    public int getValue() {
        if ("AJQK".contains(value)) { //Ace Jack Queen King
            if ("A".equals(value)) {
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value); //values 2-10
    }

    public boolean isAce() {
        return "A".equals(value);
    }

    public String getImagePath() {
        return "/cards/" + toString() + ".png";
    }
}
