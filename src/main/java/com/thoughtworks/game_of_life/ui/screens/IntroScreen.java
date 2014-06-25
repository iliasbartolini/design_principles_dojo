package com.thoughtworks.game_of_life.ui.screens;


import com.thoughtworks.game_of_life.core.Game;
import com.thoughtworks.game_of_life.ui.ImageLoader;

import java.awt.*;
import java.awt.event.KeyEvent;

public class IntroScreen implements Screen {
    static final Image TITLE_SCREEN_IMAGE = ImageLoader.loadImage(Screen.class, "introScreen.png");

    private final Dimension dimension;
    private boolean startGame;

    public IntroScreen(Game game) {
        this.dimension = game.getDimension();
        this.startGame = false;
    }

    public void draw(Graphics2D graphics) {
        int height = TITLE_SCREEN_IMAGE.getHeight(null) * dimension.width / TITLE_SCREEN_IMAGE.getWidth(null);
        graphics.drawImage(TITLE_SCREEN_IMAGE, 0, 0, dimension.width, height, null);
    }

    public Screen getNextScreen() throws Exception {
        if (startGame) {
            return new GameScreen();
        }
        return this;
    }

    public void keyPressed(KeyEvent e) {
        startGame = true;
    }
}
