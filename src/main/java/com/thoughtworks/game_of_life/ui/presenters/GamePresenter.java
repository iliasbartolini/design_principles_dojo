package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.Game;

import java.awt.Graphics2D;

public class GamePresenter implements Presenter {

    private Game game;

    public GamePresenter(Game game) {
        this.game = game;
    }

    public void draw(Graphics2D graphics) {
    }

}