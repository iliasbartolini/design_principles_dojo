package com.thoughtworks.game_of_life.core;

import java.awt.*;

public class World {

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    Cell[][] cells;

    public World()  {
        cells = new Cell [DEFAULT_WIDTH][DEFAULT_HEIGHT];

        for (int x = 0; x < DEFAULT_WIDTH; x++) {
            for (int y = 0; y < DEFAULT_HEIGHT; y++) {
                cells[x][y] = new Cell();
            }
        }
    }

    public Dimension getDimension() {
        return new Dimension(480, 480);
    }

    public void advance() {

    }

    public boolean isEmpty() {
        for (Cell[] row: cells) {
            for (Cell cell: row){
                if (cell.isAlive()){
                    return false;
                }
            }
        }
        return true;
    }

    public void setLivingAt(int x, int y) {
        cells[x][y].setAlive();
    }
}
