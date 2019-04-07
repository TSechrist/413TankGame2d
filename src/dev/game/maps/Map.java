package dev.game.maps;

import dev.game.tiles.Tile;
import dev.game.util.Util;

import java.awt.*;

public class Map {

    private int width, height;
    private int spawnX1, spawnX2, spawnY1, spawnY2;
    private int[][] tiles;

    public Map(String path) {

        loadWorld(path);
    }

    public void tick(){


    }

    public void render(Graphics g){

        for(int i = 0; i < height; i++)
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
        String[] tokens = file.split("\\s+");
        width = Util.parseInt(tokens[0]);
        height = Util.parseInt(tokens[1]);
        spawnX1 = Util.parseInt(tokens[2]);
        spawnY1 = Util.parseInt(tokens[3]);
        spawnX2 = Util.parseInt(tokens[4]);
        spawnY2 = Util.parseInt(tokens[5]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 6]);
            }
        }

    }
}
