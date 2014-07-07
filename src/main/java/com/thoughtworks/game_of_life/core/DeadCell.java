package com.thoughtworks.game_of_life.core;

public class DeadCell implements Cell{

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 3;
    }

    @Override
    public boolean willBeZombie(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours >= 4;
    }

    @Override
    public boolean isZombie() {
        return false;
    }
}
