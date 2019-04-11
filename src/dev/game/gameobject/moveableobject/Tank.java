package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gfx.Assets;
import dev.game.tiles.Tile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tank extends MoveableObject {

    private final int SPEED = 8;
    private final int ROTATE_SPEED = 8;

    private BufferedImage img;
    private int angle = 0;
    private float vx, vy;
    private int width, height;
    private int playerNumber;

    public Tank(int playerNumber, Handler handler, BufferedImage img, int width, int height, float x, float y){

        super(playerNumber, handler, x, y, width, height);
        this.img = img;
        this.playerNumber = playerNumber;

    }

    @Override
    public void tick() {

        getInput();
        handler.getCamera().centerOnTank(this);
    }

    private void getInput(){

        if(playerNumber == 1)
        {
            if(handler.getKeyManager().up1)
                this.moveForward();
            if(handler.getKeyManager().down1)
                this.moveBackward();
            if(handler.getKeyManager().left1)
                this.rotateLeft();
            if(handler.getKeyManager().right1)
                this.rotateRight();
        }
        if(playerNumber == 2)
        {
            if(handler.getKeyManager().up2)
                this.moveForward();
            if(handler.getKeyManager().down2)
                this.moveBackward();
            if(handler.getKeyManager().left2)
                this.rotateLeft();
            if(handler.getKeyManager().right2)
                this.rotateRight();
        }

    }

    private void moveForward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        int cx1 = ((int)x + (int)vx) / Tile.TILE_WIDTH;
        int cx2 = cx1 + 1;
        int cy1 = ((int)y + (int)vy) / Tile.TILE_HEIGHT;
        int cy2 = cy1 + 1;
        if(!checkObjectCollisions(vx, vy))
        {
            x += vx;
            y += vy;
        }

//        if((!super.CollisionWithTile(cx1, cy1)) &&
//           (!super.CollisionWithTile(cx1, cy2)) &&
//           (!super.CollisionWithTile(cx2, cy1)) &&
//           (!super.CollisionWithTile(cx2, cy2)))
//        {
//            x += vx;
//            y += vy;
//        }


//        checkBorder();

    }
    private void moveBackward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        int cx1 = ((int)x - (int)vx) / Tile.TILE_WIDTH;
        int cx2 = cx1 + 1;
        int cy1 = ((int)y - (int)vy) / Tile.TILE_HEIGHT;
        int cy2 = cy1 + 1;
        if((!super.CollisionWithTile(cx1, cy1)) &&
                (!super.CollisionWithTile(cx1, cy2)) &&
                (!super.CollisionWithTile(cx2, cy1)) &&
                (!super.CollisionWithTile(cx2, cy2)))
        {
            x -= vx;
            y -= vy;
        }
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

        AffineTransform rotation = AffineTransform.getTranslateInstance(x - handler.getCamera().getxOff(), y - handler.getCamera().getyOff());
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, rotation, null);
        g.setColor(Color.red);
        g.drawRect((int)(x + bounds.x - handler.getCamera().getxOff()),
                (int)(y + bounds.y - handler.getCamera().getyOff()),
                bounds.width, bounds.height);
//        g.drawImage(Assets.smile1, (int)x, (int)y, null);
    }
}
