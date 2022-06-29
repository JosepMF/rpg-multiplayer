package map.tiles;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileLoader {
    GamePanel gp;

    public Tile[] tiles;

    public TileLoader(GamePanel gp) {
        this.gp = gp;
        this.tiles = new Tile[10];
    }

    private void loadTilesImages() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
