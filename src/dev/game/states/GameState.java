package dev.game.states;

import dev.game.Game;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;
import dev.game.maps.Map;
import dev.game.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Tank tank1;
    private Tank tank2;
    private Map map;

    public GameState(Game game){
        super(game);
        tank1 = new Tank(1, game, Assets.tank, 64, 64, 100, 100);
        tank2 = new Tank(2, game, Assets.tank, 64, 64,  200, 100);
        map = new Map("\\src\\res\\mapresourses\\map1.txt");

    }

    @Override
    public void tick() {
        map.tick();
        tank1.tick();
        tank2.tick();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);

//        Tile.tiles[1].render(g, 1000, 500);
//        Tile.tiles[1].render(g, 500, 500);
//        Tile.tiles[2].render(g, 1250, 250);
//        Tile.tiles[2].render(g, 250, 250);


        tank1.render(g);
        tank2.render(g);
    }
}

