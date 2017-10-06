package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.Location;
import com.thoughtworks.game_of_life.core.World;

public class CellToPresenterFactory {
    public static Presenter toPresenter(World world, Location location) {
        if (world.isAlive(location)){
            return new AliveCellPresenter(location);
        } else {
            return new DeadCellPresenter(location);
        }
    }
}