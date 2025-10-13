package com.ata1635.cardgame.core.games;

import com.ata1635.cardgame.core.model.Card;

import javax.swing.*;
import java.awt.*;

public class BlackjackUI extends JFrame {

    private final Blackjack blackjack = new Blackjack();

    private static final int CARD_HEIGHT = 154; //ration 1/1.4
    private static final int CARD_WIDTH = 110;

    private static final Color TABLE_GREEN = new Color(53, 101, 77);


    public BlackjackUI() {
        this.setTitle("Blackjack");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //draw hidden card
        JPanel gamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                try {
                    //draw hidden card
                    Image hiddenCardImg = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
                    g.drawImage(hiddenCardImg, 20, 20, CARD_WIDTH, CARD_HEIGHT, null);

                    //draw dealer hand
                    for (int i = 0; i < blackjack.getDealerHand().size(); i++) {
                        Card card = blackjack.getDealerHand().get(i);
                        Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                        g.drawImage(cardImg, CARD_WIDTH + 25 + (CARD_WIDTH + 5) * i, 20, CARD_WIDTH, CARD_HEIGHT, null);
                    }

                    //draw player hand
                    for (int i = 0; i < blackjack.getPlayerHand().size(); i++) {
                        Card card = blackjack.getPlayerHand().get(i);
                        Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                        g.drawImage(cardImg, 20 + (CARD_WIDTH + 5) * i, 320, CARD_WIDTH, CARD_HEIGHT, null);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        this.add(gamePanel);

        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.SOUTH);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(TABLE_GREEN);

        buttonPanel.setBackground(TABLE_GREEN);
        JButton hitButton = new JButton("Hit");
        JButton stayButton = new JButton("Stay");
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);

        hitButton.setFocusable(false);

        stayButton.setFocusable(false);

    }
}

