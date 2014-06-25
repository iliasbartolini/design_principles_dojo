package com.thoughtworks.game_of_life.ui.screens;


import com.thoughtworks.game_of_life.core.Game;
import com.thoughtworks.game_of_life.ui.presenters.GamePresenter;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScreen implements Screen {
    private final Game game;
    private final GamePresenter gamePresenter;

    public GameScreen() throws Exception {
        this(new Game());
    }

    private GameScreen(Game game) {
        this(game, new GamePresenter(game));
    }

    GameScreen(Game game, GamePresenter gamePresenter) {
        this.game = game;
        this.gamePresenter = gamePresenter;
    }

    public void draw(Graphics2D graphics) {
        game.advance();
        gamePresenter.draw(graphics);
    }

    public Screen getNextScreen() {
        return this;
    }

    public void keyPressed(KeyEvent e) { }
}
