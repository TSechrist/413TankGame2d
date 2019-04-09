package dev.game.gameobject;

import dev.game.Game;
import dev.game.Handler;

import java.awt.*;

public abstract class GameObject {

    protected float x, y;
    protected int width, height;
    protected Handler handler;

    public GameObject(Handler handler, float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setY(float y) {
        this.y = y;
    }


}
