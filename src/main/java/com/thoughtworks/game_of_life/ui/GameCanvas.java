package com.thoughtworks.game_of_life.ui;

import com.thoughtworks.game_of_life.core.World;
import com.thoughtworks.game_of_life.ui.screens.IntroScreen;
import com.thoughtworks.game_of_life.ui.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas implements KeyListener {

    private final Dimension dimension;
    private Screen currentScreen;

    public GameCanvas(Dimension dimension, World world) {
        this.dimension = dimension;
        this.currentScreen = new IntroScreen(world);
    }

    public void initialize(JPanel panel) {
        setBounds(new Rectangle(dimension));
        panel.add(this);
        setIgnoreRepaint(true);
        createBufferStrategy(2);
        addKeyListener(this);
        requestFocus();
    }

    public void draw() throws Exception {
        BufferStrategy strategy = getBufferStrategy();
        Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        graphics.setColor(Color.white);
        graphics.fill(new Rectangle(dimension));

        currentScreen = currentScreen.getNextScreen();
        currentScreen.draw(graphics);

        graphics.dispose();
        strategy.show();
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        currentScreen.keyPressed();
    }

    public void keyReleased(KeyEvent e) { }
}