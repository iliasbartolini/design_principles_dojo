package com.thoughtworks.game_of_life.core;

/**
 * Created by gpad on 26/06/14.
 */
public class ZombieCell implements Cell {
    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean willBeAlive(int numberOfAliveNeighbours) {
        return false;
    }

    @Override
    public boolean willBeZombie(int numberOfAliveNeighbours) {
        return true;
    }
}
