package map.tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileLoader {
    public Tile[] tileArray;
    public int[][] mapTileNum;

    GamePanel gp;

    public TileLoader(GamePanel gp) {
        tileArray = new Tile[3];

        this.gp = gp;

        this.loadTiles();
        this.loadMap();
    }

    private void loadTiles() {
        try {
            tileArray[0] = new Tile("earth", 1);
            tileArray[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("")));
            tileArray[1] = new Tile("grass", 2);
            tileArray[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("")));
            tileArray[2] = new Tile("water", 3);
            tileArray[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("world/map01.txt");
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.colWorldNumber && row < gp.rowWorldNumber) {
                String line = br.readLine();

                while (col < gp.colWorldNumber) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.colWorldNumber) {
                    col = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldRow = 0;
        int worldCol = 0;

        while (worldCol < gp.colWorldNumber && worldRow < gp.rowWorldNumber) {
            int num = mapTileNum[worldCol][worldRow];

            int wx = worldCol * gp.tileSize; // world x
            int wy = worldRow * gp.tileSize; // world y
            int sx = wx - gp.entityLoader.player.worldX + gp.entityLoader.player.screenX; // screen x
            int sy = wy - gp.entityLoader.player.worldY + gp.entityLoader.player.screenY; // screen y

            if (wx > gp.entityLoader.player.worldX - gp.entityLoader.player.screenX - gp.tileSize &&
                    wy > gp.entityLoader.player.worldY - gp.entityLoader.player.screenY - gp.tileSize &&
                    wx < gp.entityLoader.player.worldX + gp.entityLoader.player.screenX + gp.tileSize * 2 &&
                    wy < gp.entityLoader.player.worldY + gp.entityLoader.player.screenY + gp.tileSize * 2) {
                // tile drawer
                g2.drawImage(tileArray[num].image, sx, sy, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if (worldCol == gp.colWorldNumber) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
