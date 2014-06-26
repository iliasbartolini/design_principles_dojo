package com.thoughtworks.game_of_life.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WorldTest {

    private World world;

    @Before
    public void setUp() throws Exception {
        world = new World();
    }

    @Test
    public void world_should_be_initially_empty(){
        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void world_should_be_non_empty_after_adding_a_live_cell(){
        world.setLivingAt(1,1);

        assertThat(world.isEmpty(), is(false));
    }

    @Test
    public void empty_world_should_be_empty_after_advancing(){

        world.advance();

        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void live_cells_with_fewer_than_two_live_neighbours_dies(){
        world.setLivingAt(2,2);
        world.setLivingAt(2,3);

        world.advance();

        assertThat(world.isEmpty(), is(true));
    }

    @Test
    public void live_cells_with_two_live_neighbours_survives(){
        world.setLivingAt(2,2);
        world.setLivingAt(2,3);
        world.setLivingAt(2,4);

        world.advance();

        assertThat(world.isAliveAt(2,3), is(true));
        assertThat(world.isEmpty(), is(false));
    }

    @Test
    public void live_cells_with_three_live_neighbours_survives(){
        world.setLivingAt(2,3);

        world.setLivingAt(2,2);
        world.setLivingAt(2,4);
        world.setLivingAt(3,3);

        world.advance();

        assertThat(world.isAliveAt(2,3), is(true));
    }

    @Test
    public void live_cells_with_more_than_three_live_neighbours_dies(){
        world.setLivingAt(2,3);

        world.setLivingAt(2,2);
        world.setLivingAt(2,4);
        world.setLivingAt(3,3);
        world.setLivingAt(1,3);

        world.advance();

        assertThat(world.isAliveAt(2,3), is(false));
    }

    @Test
    public void dead_cell_with_exactly_three_live_neighbours_becomes_alive(){

        world.setLivingAt(2,2);
        world.setLivingAt(2,4);
        world.setLivingAt(3,3);

        world.advance();

        assertThat(world.isAliveAt(2,3), is(true));
    }


}