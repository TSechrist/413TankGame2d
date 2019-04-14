package dev.game.gameobject;

import dev.game.Handler;

import java.awt.*;

public class BreakableWall extends GameObject {


    public BreakableWall(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        health = 50;

    }

    @Override
    public void tick() {

    }

    @Override
    public void die(){


    }

    @Override
    public void render(Graphics g) {

    }
}