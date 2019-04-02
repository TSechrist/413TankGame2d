package dev.game.gameobject;

import java.awt.*;

public abstract class GameObject {

    protected float x, y;
    protected int width, height;

    public GameObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);



}
