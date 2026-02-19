package com.thoughtworks.game_of_life.core;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.thoughtworks.game_of_life.core.Location.allLocations;

public class World {

    public static final int WORLD_WIDTH = 10;
    public static final int WORLD_HEIGHT = 10;

    Map<Location, Cell> cells;

    public World() {
        cells = initCells();
    }

    public void advance() {
        var newCells = initCells();

        for (Location location : allLocations(WORLD_WIDTH, WORLD_HEIGHT)) {
            if (cells.get(location).willBeAlive(numberOfAliveNeighbours(location))) {
                newCells.put(location, new AliveCell());
            }
        }
        cells = newCells;
    }

    public boolean isEmpty() {
        return cells.values().stream().noneMatch(Cell::isAlive);
    }

    public void setLivingCell(Location atLocation) {
        cells.put(atLocation, new AliveCell());
    }

    public boolean isAlive(Location location) {
        return cells.get(location).isAlive();
    }

    private Map<Location, Cell> initCells() {
        return allLocations(WORLD_WIDTH, WORLD_HEIGHT).stream()
            .collect(Collectors.toMap(location -> location, location -> new DeadCell()));
    }

    public int numberOfAliveNeighbours(Location location) {
        return (int) location.getBoundedNeighbours(WORLD_WIDTH, WORLD_HEIGHT).stream()
            .filter(neighbour -> cells.get(neighbour).isAlive())
            .count();
    }
}