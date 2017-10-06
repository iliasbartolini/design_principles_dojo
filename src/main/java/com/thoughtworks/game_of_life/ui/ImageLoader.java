package com.thoughtworks.game_of_life.ui;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

    private static final ImageLoader instance = new ImageLoader();

    public static Image loadImage(Class<?> className, String imageName) {
        return instance.load(className, imageName);
    }

    private final Map<String, Image> images;

    private ImageLoader() {
        images = new HashMap<>();
    }
    
    private Image load(Class<?> resourceLocation, String imageName) {
        if (!images.containsKey(imageName)) {
            Image image = Toolkit.getDefaultToolkit().getImage(resourceLocation.getResource(imageName));
            images.put(imageName, image);
        }
        return images.get(imageName);
    }
}