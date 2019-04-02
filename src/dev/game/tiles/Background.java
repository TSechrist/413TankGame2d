package dev.game.tiles;

import dev.game.Game;
import dev.game.gfx.Assets;

import java.awt.*;

public class Background extends Tile{

    public Background(int id){
        super(Assets.background, id);
    }

    @Override
    public boolean isSolid() {
        return super.isSolid();
    }

    @Override
    public void render(Graphics g, int x, int y){

        g.drawImage(texture, x, y, Game.width, Game.height, null);
//        g.drawImage(texture, x, y, 1500, 1000, null);
    }
}
