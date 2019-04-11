package dev.game.gameobject;

import dev.game.Game;
import dev.game.Handler;

import java.awt.*;

public abstract class GameObject {

    protected float x, y;
    protected int width, height;
    protected Handler handler;
    protected Rectangle bounds;

    public GameObject(Handler handler, float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public boolean checkObjectCollisions(float xOff, float yOff){

        for(GameObject o : handler.getMap().getObjectManager().getGameObjects())
        {
            if(o.equals(this))
            {
                continue;
            }
            if(o.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOff, yOff)))
            {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOff, float yOff){

        return new Rectangle((int)(x + bounds.x + xOff), (int)(y + bounds.y + yOff), bounds.width, bounds.height);
    }

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
