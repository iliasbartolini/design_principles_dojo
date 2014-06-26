package com.thoughtworks.game_of_life.core;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public final int x;
    public final int y;

    private Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location at(int x, int y) {
        return new Location(x, y);
    }

    public static List<Location> allWorldLocations(int width, int height) {
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations.add(new Location(x, y));
            }
        }
        return locations;
    }

    public List<Location> allNeighbours(int worldWidth, int worldHeight) {
        ArrayList<Location> neighbours = new ArrayList<Location>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != location.x) return false;
        if (y != location.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
