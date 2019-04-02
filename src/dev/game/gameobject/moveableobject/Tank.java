package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tank extends MoveableObject {

    private final int SPEED = 4;
    private final int ROTATE_SPEED = 8;

    private Game game;
    private BufferedImage img;
    private int angle = 0;
    private int vx;
    private int vy;
    private int width;
    private int height;
    private int playerNumber;

    public Tank(int playerNumber, Game game, BufferedImage img, int width, int height, float x, float y){

        super(playerNumber, x, y, width, height);
        this.width = width;
        this.height = height;
        this.game = game;
        this.img = img;
        this.playerNumber = playerNumber;
    }

    @Override
    public void tick() {

        getInput();
    }

    private void getInput(){

        if(playerNumber == 1)
        {
            if(game.getKeyManager().up1)
                this.moveForward();
            if(game.getKeyManager().down1)
                this.moveBackward();
            if(game.getKeyManager().left1)
                this.rotateLeft();
            if(game.getKeyManager().right1)
                this.rotateRight();
        }
        if(playerNumber == 2)
        {
            if(game.getKeyManager().up2)
                this.moveForward();
            if(game.getKeyManager().down2)
                this.moveBackward();
            if(game.getKeyManager().left2)
                this.rotateLeft();
            if(game.getKeyManager().right2)
                this.rotateRight();
        }

    }

    private void moveForward() {
        vx = (int) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
//        checkBorder();

    }
    private void moveBackward() {
        vx = (int) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
//        checkBorder();

    }
    private void rotateLeft() {
        this.angle = ((this.angle % 360) - this.ROTATE_SPEED);

    }
    private void rotateRight() {
        this.angle = ((this.angle % 360) + this.ROTATE_SPEED);

    }

    @Override
    public void render(Graphics g) {

        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, rotation, null);
//        g.drawImage(Assets.smile1, (int)x, (int)y, null);
    }
}
