package com.thoughtworks.game_of_life.core;

public class AliveCell implements Cell {

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
    }
}