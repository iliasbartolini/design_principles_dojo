package com.thoughtworks.game_of_life.core;

public class Cell {
    public static final Cell ALIVE = new Cell(true);
    public static final Cell DEAD = new Cell(false);

    private final boolean alive;

    private Cell() {
        alive = false;
    }

    private Cell(boolean isAlive) {
        alive = isAlive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return (alive && (numberOfAliveNeighbours == 2));
    }

}
