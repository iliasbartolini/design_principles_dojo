package com.thoughtworks.game_of_life.core;

import java.util.ArrayList;
import java.util.List;

public record Location(int x, int y) {

    public static Location at(int x, int y) {
        return new Location(x, y);
    }

    public static List<Location> allWorldLocations(int width, int height) {
        var locations = new ArrayList<Location>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations.add(new Location(x, y));
            }
        }
        return locations;
    }

    public List<Location> allNeighbours(int worldWidth, int worldHeight) {
        var neighbours = new ArrayList<Location>();

        int lowerX = Math.max(0, x - 1);
        int upperX = Math.min(worldWidth - 1, x + 1);

        int lowerY = Math.max(0, y - 1);
        int upperY = Math.min(worldHeight - 1, y + 1);

        for (int i = lowerX; i <= upperX; i++) {
            for (int j = lowerY; j <= upperY; j++) {
                if (i != x || j != y) {
                    neighbours.add(at(i, j));
                }
            }
        }
        return neighbours;
    }
}