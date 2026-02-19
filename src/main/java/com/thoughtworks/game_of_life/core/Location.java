package com.thoughtworks.game_of_life.core;

import java.util.ArrayList;
import java.util.List;

public record Location(int x, int y) {

    public static Location at(int x, int y) {
        return new Location(x, y);
    }

    public static List<Location> allLocations(int width, int height) {
        var locations = new ArrayList<Location>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations.add(new Location(x, y));
            }
        }
        return locations;
    }

    public List<Location> getBoundedNeighbours(int width, int height) {
        var neighbours = new ArrayList<Location>();

        int minX = 0;
        int minY = 0;
        int maxX = width - 1;
        int maxY = height - 1;

        int lowerNeighbourX = Math.max(minX, x - 1);
        int upperNeighbourX = Math.min(maxX, x + 1);
        int lowerNeighbourY = Math.max(minY, y - 1);
        int upperNeighbourY = Math.min(maxY, y + 1);

        for (int i = lowerNeighbourX; i <= upperNeighbourX; i++) {
            for (int j = lowerNeighbourY; j <= upperNeighbourY; j++) {
                if (!at(i,j).equals(this)) {
                    neighbours.add(at(i, j));
                }
            }
        }
        return neighbours;
    }
}