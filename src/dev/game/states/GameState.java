package dev.game.states;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;
import dev.game.maps.Map;
import dev.game.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Tank tank1;
    private Tank tank2;
    private Map map;

    public GameState(Handler handler){
        super(handler);
        map = new Map(game, "\\src\\res\\mapresourses\\map1.txt");
        handler.setMap(map);

        tank1 = new Tank(1, game, Assets.tank, 64, 64, 100, 100);
        tank2 = new Tank(2, game, Assets.tank, 64, 64,  200, 100);

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

        tank1.render(g);
        tank2.render(g);
    }
}

