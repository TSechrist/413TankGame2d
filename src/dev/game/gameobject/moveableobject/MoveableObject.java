package dev.game.gameobject.moveableobject;

import dev.game.gameobject.GameObject;

public abstract class MoveableObject extends GameObject {

    protected int health;

    public MoveableObject(int playerNumber, float x, float y, int width, int height){
        super(x, y, width, height);
        health = 100;

    }
}
