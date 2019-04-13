package dev.game.gameobject.moveableobject;

import dev.game.Handler;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet extends MoveableObject {

    private BufferedImage img;
    private int angle;

    public Bullet(Handler handler, BufferedImage img, float x, float y, int angle, int height, int width) {
        super(handler, x + 32, y + 32, height, width);
        this.img = img;
        this.angle = angle;
    }

    @Override
    public void tick() {

        vx = (float) Math.round((SPEED * 1.5) * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round((SPEED * 1.5) * Math.sin(Math.toRadians(angle)));

        if(!checkObjectCollisions(vx, vy))
        {
            this.x += vx;
            this.y += vy;
        }

        if(this.checkObjectCollisions(vx, vy)){

            handler.getMap().getObjectManager().removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {

        AffineTransform rotation = AffineTransform.getTranslateInstance(this.x - handler.getCamera().getxOff(), this.y - handler.getCamera().getyOff());
        rotation.rotate(Math.toRadians(this.angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, rotation, null);
        g.setColor(Color.green);
        g.drawRect((int)(this.x + bounds.x - handler.getCamera().getxOff()),
                (int)(y + bounds.y - handler.getCamera().getyOff()),
                bounds.width, bounds.height);
    }


}
