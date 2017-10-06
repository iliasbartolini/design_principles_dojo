package com.thoughtworks.game_of_life.ui.screens;

import java.awt.*;

public interface Screen {
    void draw(Graphics2D graphics);
    void keyPressed();
    Screen getNextScreen();
}