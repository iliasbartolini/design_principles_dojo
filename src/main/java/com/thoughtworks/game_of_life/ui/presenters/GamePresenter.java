package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.Location;
import com.thoughtworks.game_of_life.core.World;

import java.awt.*;

import static com.thoughtworks.game_of_life.core.Location.allWorldLocations;

public class GamePresenter implements Presenter {

    private World world;

    public GamePresenter(World world) {
        this.world = world;
    }

    public void draw(Graphics2D graphics) {
        for (Location location : allWorldLocations(World.DEFAULT_WIDTH, World.DEFAULT_HEIGHT)){
            Presenter cellPresenter = CellToPresenterFactory.toPresenter(world, location);
            cellPresenter.draw(graphics);
        }
    }

}