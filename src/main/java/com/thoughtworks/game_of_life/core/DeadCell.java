package com.thoughtworks.game_of_life.core;

public class DeadCell implements Cell {

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 3;
    }
}