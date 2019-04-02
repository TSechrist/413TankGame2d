package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage smile1, smile2, box1, box2, background;

    public static void init(){
        smile1 = ImageLoader.loadImage("/res/textures/Smile1.bmp");
        smile2 = ImageLoader.loadImage("/res/textures/Smile2.bmp");
        box1 = ImageLoader.loadImage("/res/textures/box1.bmp");
        box2 = ImageLoader.loadImage("/res/textures/box2.bmp");
        background = ImageLoader.loadImage("/res/textures/Background.jpg");

    }
}
