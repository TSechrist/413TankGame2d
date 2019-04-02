package dev.game.states;

import dev.game.Game;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;
import dev.game.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Tank tank1;
    private Tank tank2;

    public GameState(Game game){
        super(game);
        tank1 = new Tank(1, game, Assets.smile1, 100, 100);
        tank2 = new Tank(2, game, Assets.smile2, 200, 100);

    }

    @Override
    public void tick() {
        tank1.tick();
        tank2.tick();
    }

    @Override
    public void render(Graphics g) {
        Tile.tiles[0].render(g, 0, 0);

        Tile.tiles[1].render(g, 1000, 500);
        Tile.tiles[1].render(g, 500, 500);
        Tile.tiles[1].render(g, 1250, 250);
        Tile.tiles[1].render(g, 0, 0);


        tank1.render(g);
        tank2.render(g);
    }
}

