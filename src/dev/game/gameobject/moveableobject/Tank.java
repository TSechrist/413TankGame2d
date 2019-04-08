package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tank extends MoveableObject {

    private final int SPEED = 4;
    private final int ROTATE_SPEED = 8;

    private BufferedImage img;
    private int angle = 0;
    private float vx, vy;
    private int width, height;
    private int playerNumber;

    public Tank(int playerNumber, Game game, BufferedImage img, int width, int height, float x, float y){

        super(playerNumber, game, x, y, width, height);
        this.img = img;
        this.playerNumber = playerNumber;
    }

    @Override
    public void tick() {

        getInput();
        game.getCamera().centerOnTank(this);
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
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
//        checkBorder();

    }
    private void moveBackward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
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

        AffineTransform rotation = AffineTransform.getTranslateInstance(x - game.getCamera().getxOff(), y - game.getCamera().getyOff());
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, rotation, null);
//        g.drawImage(Assets.smile1, (int)x, (int)y, null);
    }
}
