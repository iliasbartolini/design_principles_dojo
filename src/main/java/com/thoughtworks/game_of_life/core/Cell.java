package com.thoughtworks.game_of_life.core;

public sealed interface Cell permits AliveCell, DeadCell {
    boolean isAlive();
    boolean willBeAlive(int numberOfAliveNeighbours);
}