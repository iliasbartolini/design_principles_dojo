package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.World;

import java.awt.Graphics2D;

public class GamePresenter implements Presenter {

    private World world;

    public GamePresenter(World world) {
        this.world = world;
    }

    public void draw(Graphics2D graphics) {
    }

}