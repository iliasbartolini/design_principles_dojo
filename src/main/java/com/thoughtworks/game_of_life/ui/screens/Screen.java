package com.thoughtworks.game_of_life.ui.screens;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Screen {
    void draw(Graphics2D graphics);
    void keyPressed(KeyEvent e);
    Screen getNextScreen() throws Exception;
}