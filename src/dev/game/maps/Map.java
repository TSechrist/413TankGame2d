package dev.game.maps;

import dev.game.tiles.Tile;
import dev.game.util.Util;

import java.awt.*;

public class Map {

    private int width, height;
    private int[][] tiles;

    public Map(String path) {

        loadWorld(path);
    }

    public void tick(){


    }

    public void render(Graphics g){

        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < width; j++)
            {
                getTile(j, i).render(g, j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.ground;
        }
        else
        {
            return t;
        }
    }

    private void loadWorld(String path) {

        String file = Util.loadFileAsString(path);



//        width = 5;
//        height = 5;
//        tiles = new int[width][height];
//
//        for(int i = 0; i < width; i++)
//        {
//            for(int j = 0; j < height; j++)
//            {
//                tiles[i][j] = 0;
//            }
//        }
//
    }
}
