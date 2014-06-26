package com.thoughtworks.game_of_life.core;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.thoughtworks.game_of_life.core.Location.allWorldLocations;

public class World {

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    Map<Location, Cell> cells;

    public World()  {
        cells = initCells();
    }

    public Dimension getDimension() {
        return new Dimension(480, 480);
    }

    public void advance() {
        Map<Location, Cell> newCells = initCells();

        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            if (cells.get(location).willBeAlive(numberOfAliveNeighbours(location))){
                newCells.put(location, Cell.ALIVE);
            }
        }
        cells = newCells;
    }

    public boolean isEmpty() {
        for (Cell cell: cells.values()) {
            if (cell.isAlive()){
                return false;
            }
        }
        return true;
    }

    public void setLiving(Location location) {
        cells.put(location, Cell.ALIVE);
    }

    public boolean isAlive(Location location) {
        return cells.get(location).isAlive();
    }

    private Map<Location,Cell> initCells() {
        Map<Location, Cell> cells = new HashMap<>();
        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            cells.put(location, Cell.DEAD);
        }
        return cells;
    }

    public int numberOfAliveNeighbours(Location l) {
        int aliveNeighbours = 0;

        for (Location location : l.allNeighbours(DEFAULT_WIDTH, DEFAULT_HEIGHT)){
            if (cells.get(location).isAlive()){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

}
