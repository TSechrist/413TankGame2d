package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage box1, box2, background, tank, ground, bullet, menuScreen, powerup, gameover;

    public static void init(){
        ground = ImageLoader.loadImage("/res/textures/Ground.jpg");
        tank = ImageLoader.loadImage("/res/textures/Tank1.jpg");
        box1 = ImageLoader.loadImage("/res/textures/box2.bmp");
        box2 = ImageLoader.loadImage("/res/textures/box1.bmp");
        background = ImageLoader.loadImage("/res/textures/Background.jpg");
        bullet = ImageLoader.loadImage("/res/textures/bullet2.jpg");
        menuScreen = ImageLoader.loadImage("/res/textures/TitleScreen.jpg");
        powerup = ImageLoader.loadImage("/res/textures/PowerUp.jpg");
        gameover = ImageLoader.loadImage("/res/textures/Gameover.jpg");

    }
}
