package com.thoughtworks.game_of_life.ui;

import com.thoughtworks.game_of_life.core.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameRunner {
    private static final int FRAME_INTERVAL = 30;

    public static void main(String[] args) throws Exception {
        GameRunner runner = new GameRunner();
        runner.initialize();
        runner.run();
    }

    private boolean open;
    private GameCanvas canvas;
    private Game game;

    private void initialize() throws Exception {
        game = new Game();
        Dimension dimension = game.getDimension();
        canvas = new GameCanvas(dimension, game);

        JFrame container = new JFrame("Conway's Game of Life");

        JPanel panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(dimension);
        panel.setLayout(null);

        container.pack();
        container.setResizable(false);
        container.setVisible(true);
        open = true;

        container.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                open = false;
                System.exit(0);
            }
        });

        canvas.initialize(panel);
    }

    private void run() throws Exception {
        while (open) {
            canvas.draw();

            try {
                Thread.sleep(FRAME_INTERVAL);
            } catch (InterruptedException e) {
            }
        }
    }
}

