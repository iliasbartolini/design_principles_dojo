package com.thoughtworks.game_of_life.ui;

import com.thoughtworks.game_of_life.core.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.thoughtworks.game_of_life.core.Location.at;

public class GameRunner {

    private static final int FRAME_INTERVAL = 30;
    public static final int TILE_SIZE = 48;

    public static void main(String[] args) throws Exception {
        GameRunner runner = new GameRunner();
        runner.initialize();
        runner.run();
    }

    private boolean open;
    private GameCanvas canvas;

    private void initialize() throws Exception {
        World world = new World();

        world.setLiving(at(7,1));
        world.setLiving(at(7,2));
        world.setLiving(at(7,3));
        world.setLiving(at(8,3));
        world.setLiving(at(9,2));

        Dimension dimension = new Dimension(TILE_SIZE * World.DEFAULT_WIDTH, TILE_SIZE * World.DEFAULT_HEIGHT);
        canvas = new GameCanvas(dimension, world);

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