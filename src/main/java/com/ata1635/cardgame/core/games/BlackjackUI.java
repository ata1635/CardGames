package com.ata1635.cardgame.core.games;

import javax.swing.*;

public class BlackjackUI extends JFrame {

    private Blackjack blackjack;

    public BlackjackUI() {
        blackjack = new Blackjack();

        JFrame frame = new JFrame("Black Jack");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

