package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.Location;
import com.thoughtworks.game_of_life.ui.GameRunner;

import java.awt.*;

public class AliveCellPresenter implements Presenter {

    private final Location location;

    public AliveCellPresenter(Location location) {
        this.location = location;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.black);
        graphics.fill(getBounds());
    }

    private Rectangle getBounds() {
        return new Rectangle(location.x * GameRunner.TILE_SIZE, location.y * GameRunner.TILE_SIZE, GameRunner.TILE_SIZE, GameRunner.TILE_SIZE);
    }
}