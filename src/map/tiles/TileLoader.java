package map.tiles;

import java.awt.Color;

public class TileLoader {
    public Tile[] tiles;

    public TileLoader() {
        this.tiles = new Tile[10];

        loadTiles();
    }

    private void loadTiles() {
        // this code will must change when the tiles textures are implements

        tiles[0] = new Tile(Color.GREEN, "grass", 0);
        
        tiles[1] = new Tile(Color.YELLOW, "sand", 1);

        tiles[2] = new Tile(Color.CYAN, "water", 2);
        tiles[2].collitions = true;

        tiles[3] = new Tile(Color.GRAY, "wall", 3);
        tiles[3].collitions = true;
    }
}
