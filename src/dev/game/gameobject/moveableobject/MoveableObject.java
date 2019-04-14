package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.GameObject;
import dev.game.gfx.Assets;

public abstract class MoveableObject extends GameObject {

    protected final int SPEED = 8;
    private final int ROTATE_SPEED = 8;

    protected int angle = 0;
    protected float vx, vy;

    public MoveableObject(int playerNumber, Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        health = 100;

    }
    public MoveableObject(Handler handler, float x, float y, int height, int width){
        super(handler, x, y, height, width);
        health = 100;

    }

    protected void moveForward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        if(!checkObjectCollisions(vx, vy))
        {
            x += vx;
            y += vy;
        }
    }
    protected void moveBackward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        if(!checkObjectCollisions(-vx, -vy))
        {
            x -= vx;
            y -= vy;
        }

    }
    protected void rotateLeft() {
        this.angle = ((this.angle % 360) - this.ROTATE_SPEED);

    }
    protected void rotateRight() {
        this.angle = ((this.angle % 360) + this.ROTATE_SPEED);

    }
    protected boolean CollisionWithTile(int x, int y){
        return handler.getMap().getTile(x, y).isSolid();
    }

    protected int getAngle(){
        return angle;
    }

    protected void tankShoot(){
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle))) * 10 - 32;
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle))) * 10 - 32;

        Bullet b = new Bullet(handler, Assets.bullet, x + vx, y + vy, this.angle, 32, 32);
        handler.getMap().getObjectManager().addObject(b);
    }
}
