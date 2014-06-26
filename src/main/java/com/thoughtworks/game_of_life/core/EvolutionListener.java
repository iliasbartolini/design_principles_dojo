package com.thoughtworks.game_of_life.core;

import java.util.List;
import java.util.Map;

/**
 * Created by gpad on 26/06/14.
 */
public interface EvolutionListener {
    void onNewZombies(List<Location> zombies);
}
