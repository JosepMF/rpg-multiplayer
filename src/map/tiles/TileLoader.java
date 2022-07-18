package map.tiles;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileLoader {
    public Tile[] tiles;

    public TileLoader() {
        this.tiles = new Tile[10];

        loadTiles();
    }

    private void loadTiles() {
        // this code will must change when the tiles textures are implements
        try {

            tiles[0] = new Tile("grass", 0);
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("./res/grass.png"));

            tiles[1] = new Tile("wall", 1);
            tiles[1].collisions = true;
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("./res/wall.png"));

            tiles[2] = new Tile("wall", 1);
            tiles[2].collisions = true;
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("./res/tree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
