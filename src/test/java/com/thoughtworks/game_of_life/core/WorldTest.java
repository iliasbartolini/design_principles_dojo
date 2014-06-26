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

}