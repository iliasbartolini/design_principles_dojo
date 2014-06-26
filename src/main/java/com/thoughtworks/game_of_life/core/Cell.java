package com.thoughtworks.game_of_life.core;

public class Cell {
    private boolean alive;

    public Cell(){
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive() {
        alive = true;
    }
}
