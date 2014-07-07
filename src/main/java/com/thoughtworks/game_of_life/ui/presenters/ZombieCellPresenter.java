package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.Location;
import com.thoughtworks.game_of_life.ui.GameRunner;

import java.awt.*;

/**
 * Created by gpad on 26/06/14.
 */
public class ZombieCellPresenter implements Presenter {
    private static final int SIDE = 4;
    private Location location;

    public ZombieCellPresenter(Location location) {
        this.location = location;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.RED);
        graphics.fill(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(location.x * GameRunner.TILE_SIZE, location.y * GameRunner.TILE_SIZE, GameRunner.TILE_SIZE, GameRunner.TILE_SIZE);
    }
}
