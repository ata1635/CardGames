package com.ata1635.cardgame;

import com.ata1635.cardgame.core.games.Blackjack;
import com.ata1635.cardgame.core.games.BlackjackUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> new BlackjackUI());
    }
}
