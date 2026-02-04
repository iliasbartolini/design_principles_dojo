package com.thoughtworks.game_of_life.core;

import java.util.HashMap;
import java.util.Map;

import static com.thoughtworks.game_of_life.core.Location.allWorldLocations;

public class World {

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 10;

    Map<Location, Cell> cells;

    public World() {
        cells = initCells();
    }

    public void advance() {
        var newCells = initCells();

        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            if (cells.get(location).willBeAlive(numberOfAliveNeighbours(location))) {
                newCells.put(location, new AliveCell());
            }
        }
        cells = newCells;
    }

    public boolean isEmpty() {
        return cells.values().stream().noneMatch(Cell::isAlive);
    }

    public void setLiving(Location location) {
        cells.put(location, new AliveCell());
    }

    public boolean isAlive(Location location) {
        return cells.get(location).isAlive();
    }

    private Map<Location, Cell> initCells() {
        Map<Location, Cell> cells = new HashMap<>();
        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            cells.put(location, new DeadCell());
        }
        return cells;
    }

    public int numberOfAliveNeighbours(Location l) {
        return (int) l.allNeighbours(DEFAULT_WIDTH, DEFAULT_HEIGHT).stream()
            .filter(location -> cells.get(location).isAlive())
            .count();
    }
}