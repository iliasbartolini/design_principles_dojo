package com.thoughtworks.game_of_life.core;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.game_of_life.core.Location.at;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WorldTest {

    private World world;

    @Before
    public void setUp() throws Exception {
        world = new World();
    }

    @Test
    public void world_should_be_initially_empty() {
        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void world_should_be_non_empty_after_adding_a_live_cell() {
        world.setLiving(at(1, 1));

        assertThat(world.isEmpty(), is(false));
    }

    @Test
    public void empty_world_should_be_empty_after_advancing() {

        world.advance();

        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void live_cells_with_fewer_than_two_live_neighbours_dies() {
        world.setLiving(at(2, 2));
        world.setLiving(at(2, 3));

        world.advance();

        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void live_cells_with_two_live_neighbours_survives() {
        world.setLiving(at(2, 2));
        world.setLiving(at(2, 3));
        world.setLiving(at(2, 4));

        world.advance();

        assertThat(world.isAlive(at(2, 3)), is(true));
        assertThat(world.isEmpty(), is(false));
    }

    @Test
    public void live_cells_with_three_live_neighbours_survives() {
        world.setLiving(at(2, 3));

        world.setLiving(at(2, 2));
        world.setLiving(at(2, 4));
        world.setLiving(at(3, 3));

        world.advance();

        assertThat(world.isAlive(at(2, 3)), is(true));
    }

    @Test
    public void live_cells_with_more_than_three_live_neighbours_dies() {
        world.setLiving(at(2, 3));

        world.setLiving(at(2, 2));
        world.setLiving(at(2, 4));
        world.setLiving(at(3, 3));
        world.setLiving(at(1, 3));

        world.advance();

        assertThat(world.isAlive(at(2, 3)), is(false));
    }

    @Test
    public void dead_cell_with_exactly_three_live_neighbours_becomes_alive() {

        world.setLiving(at(2, 2));
        world.setLiving(at(2, 4));
        world.setLiving(at(3, 3));

        world.advance();

        assertThat(world.isAlive(at(2, 3)), is(true));
    }

    class Stafava
    {
        public boolean Called;

        public Stafava(boolean b) {
            this.Called = b;
        }
    }

    @Test
    public void live_cell_with_more_than_fourth_live_neighbours_zombies()
    {
        world.setLiving(at(2, 3));

        world.setLiving(at(2, 2));
        world.setLiving(at(2, 4));
        world.setLiving(at(3, 3));
        world.setLiving(at(1, 3));

        final Stafava executed = new Stafava(false);
        world.onAdvance(new EvolutionListener() {
            @Override
            public void onNewZombies(List<Location> zombies) {
                executed.Called = true;
                assertThat(zombies, IsEqual.equalTo(Arrays.asList(Location.at(2, 3))));
            }
        });

        world.advance();

        assertThat(executed.Called, is(true));


    }

}