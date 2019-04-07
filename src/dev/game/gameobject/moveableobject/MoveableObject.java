package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.gameobject.GameObject;

public abstract class MoveableObject extends GameObject {

    protected int health;

    public MoveableObject(int playerNumber, Game game, float x, float y, int width, int height){
        super(game, x, y, width, height);
        health = 100;

    }
}
