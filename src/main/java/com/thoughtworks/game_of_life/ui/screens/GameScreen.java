package com.thoughtworks.game_of_life.ui.screens;


import com.thoughtworks.game_of_life.core.World;
import com.thoughtworks.game_of_life.ui.presenters.GamePresenter;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScreen implements Screen {
    private final World world;
    private final GamePresenter gamePresenter;

    public GameScreen() throws Exception {
        this(new World());
    }

    private GameScreen(World world) {
        this(world, new GamePresenter(world));
    }

    GameScreen(World world, GamePresenter gamePresenter) {
        this.world = world;
        this.gamePresenter = gamePresenter;
    }

    public void draw(Graphics2D graphics) {
        world.advance();
        gamePresenter.draw(graphics);
    }

    public Screen getNextScreen() {
        return this;
    }

    public void keyPressed(KeyEvent e) { }
}
