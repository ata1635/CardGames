package com.ata1635.cardgame.core.games;

import javax.swing.*;
import java.awt.*;

public class BlackjackUI extends JFrame {

    private Blackjack blackjack;
    private JFrame frame;
    private JPanel gamePanel;

    public BlackjackUI() {
        blackjack = new Blackjack();
        frame = new JFrame("Black Jack");
        gamePanel = new JPanel();

        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));
        frame.add(gamePanel);

    }
}

