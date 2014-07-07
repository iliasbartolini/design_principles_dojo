package com.thoughtworks.game_of_life.core;

public interface Cell {
    boolean isAlive();
    boolean willBeAlive(int numberOfAliveNeighbours);
    boolean willBeZombie(int numberOfAliveNeighbours);

    boolean isZombie();
}
