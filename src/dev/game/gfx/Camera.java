package dev.game.gfx;

import dev.game.Game;
import dev.game.gameobject.GameObject;

public class Camera {

    private float xOff, yOff;
    private Game game;

    public Camera(Game game, float xOff, float yOff) {

        this.game = game;
        this.xOff = xOff;
        this.yOff = yOff;

    }

    public void move(float xMove, float yMove){

        xOff += xMove;
        yOff += yMove;
    }

    public void centerOnTank(GameObject o){

        xOff = o.getX() - game.getWidth() / 2 + o.getWidth() / 2;
        yOff = o.getY() - game.getHeight() / 2 + o.getHeight() / 2;
    }

    public float getxOff() {
        return xOff;
    }

    public void setxOff(float xOff) {
        this.xOff = xOff;
    }

    public float getyOff() {
        return yOff;
    }

    public void setyOff(float yOff) {
        this.yOff = yOff;
    }
}
