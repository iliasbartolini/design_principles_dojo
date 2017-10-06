package com.thoughtworks.game_of_life.ui.screens;


import com.thoughtworks.game_of_life.core.World;
import com.thoughtworks.game_of_life.ui.GameCanvas;
import com.thoughtworks.game_of_life.ui.GameRunner;
import com.thoughtworks.game_of_life.ui.ImageLoader;

import java.awt.*;

public class IntroScreen implements Screen {

    static final Image TITLE_SCREEN_IMAGE = ImageLoader.loadImage(GameCanvas.class, "introScreen.png");

    private final Dimension dimension;
    private boolean startGame;
    private final World world;

    public IntroScreen(World world) {
        this.world = world;
        this.dimension = new Dimension(GameRunner.TILE_SIZE * World.DEFAULT_WIDTH, GameRunner.TILE_SIZE * World.DEFAULT_HEIGHT);
        this.startGame = false;
    }

    public void draw(Graphics2D graphics) {
        int height = TITLE_SCREEN_IMAGE.getHeight(null) * dimension.width / TITLE_SCREEN_IMAGE.getWidth(null);
        graphics.drawImage(TITLE_SCREEN_IMAGE, 0, 0, dimension.width, height, null);
    }

    public Screen getNextScreen() throws Exception {
        if (startGame) {
            return new GameScreen(world);
        }
        return this;
    }

    public void keyPressed() {
        startGame = true;
    }
}