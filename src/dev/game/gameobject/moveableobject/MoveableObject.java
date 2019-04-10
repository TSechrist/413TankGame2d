package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.GameObject;

public abstract class MoveableObject extends GameObject {

    protected int health;
    protected float xMove, yMove;

    public MoveableObject(int playerNumber, Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        health = 100;

    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){

        x += xMove;
    }

    public void moveY(){

        y += yMove;
    }

    protected boolean CollisionWithTile(int x, int y){
        return handler.getMap().getTile(x, y).isSolid();
    }
}
