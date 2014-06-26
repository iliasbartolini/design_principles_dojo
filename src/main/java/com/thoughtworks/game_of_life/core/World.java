package com.thoughtworks.game_of_life.core;

import java.awt.*;

public class World {

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    Cell[][] cells;

    public World()  {
        cells = initCells(new Cell[DEFAULT_WIDTH][DEFAULT_HEIGHT]);
    }

    public Dimension getDimension() {
        return new Dimension(480, 480);
    }

    public void advance() {
        Cell[][] newCells = initCells(new Cell[DEFAULT_WIDTH][DEFAULT_HEIGHT]);

        for (int x = 0; x < DEFAULT_WIDTH; x++) {
            for (int y = 0; y < DEFAULT_HEIGHT; y++) {
                if (cells[x][y].willBeAlive(numberOfAliveNeighbours(x, y))){
                    newCells[x][y] = Cell.ALIVE;
                }
            }
        }
        cells = newCells;
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
        cells[x][y] = Cell.ALIVE;
    }

    public boolean isAliveAt(int x, int y) {
        return cells[x][y].isAlive();
    }

    private Cell[][] initCells(Cell[][] newCells) {
        for (int x = 0; x < DEFAULT_WIDTH; x++) {
            for (int y = 0; y < DEFAULT_HEIGHT; y++) {
                newCells[x][y] = Cell.DEAD;
            }
        }
        return newCells;
    }

    public int numberOfAliveNeighbours(int i, int j) {
        int aliveNeighbours = 0;

        int lowerX = Math.max(0, i-1);
        int upperX = Math.min(DEFAULT_WIDTH-1, i+1);

        int lowerY = Math.max(0, j-1);
        int upperY = Math.min(DEFAULT_HEIGHT-1, j+1);

        for (int x = lowerX; x <= upperX; x++) {
            for (int y = lowerY; y <= upperY; y++) {
                if ((x != i || y != j) && cells[x][y].isAlive()){
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

}
