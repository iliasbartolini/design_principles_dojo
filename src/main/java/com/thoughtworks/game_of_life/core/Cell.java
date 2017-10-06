package com.thoughtworks.game_of_life.core;

interface Cell {
    boolean isAlive();
    boolean willBeAlive(int numberOfAliveNeighbours);
}