package com.thoughtworks.game_of_life.core;

import java.util.*;

import static com.thoughtworks.game_of_life.core.Location.allWorldLocations;

public class World {

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 10;


    Map<Location, Cell> cells;
    private EvolutionListener _listener = new EvolutionListener() {
        @Override
        public void onNewZombies(List<Location> zombies) {

        }
    };

    public World()  {
        cells = initCells();
    }

    public void advance() {
        Map<Location, Cell> newCells = initCells();
        List<Location> zombiesLocation = new ArrayList<Location>();

        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            if (cells.get(location).willBeAlive(numberOfAliveNeighbours(location))){
                newCells.put(location, new AliveCell());
            }
            if (cells.get(location).willBeZombie(numberOfAliveNeighbours(location))){
                zombiesLocation.add(location);
                newCells.put(location, new ZombieCell());
            }
        }
        cells = newCells;

        _listener.onNewZombies(zombiesLocation);

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
        cells.put(location, new AliveCell());
    }

    public boolean isAlive(Location location) {
        return cells.get(location).isAlive();
    }

    private Map<Location,Cell> initCells() {
        Map<Location, Cell> cells = new HashMap<Location, Cell>();
        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            cells.put(location, new DeadCell());
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

    public void onAdvance(EvolutionListener listener) {
        _listener = listener;
    }
}
