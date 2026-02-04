package com.thoughtworks.game_of_life.core;

public record AliveCell() implements Cell {

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
    }
}