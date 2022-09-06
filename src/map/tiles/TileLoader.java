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

        mapTileNum = new int[gp.colWorldNumber][gp.rowWorldNumber];

        this.loadTiles();
        this.loadMap();
    }

    private void loadTiles() {
        try {
            tileArray[0] = new Tile("earth", 1);
            tileArray[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/earth.png")));
            tileArray[1] = new Tile("grass", 2);
            tileArray[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/grass.png")));
            tileArray[2] = new Tile("water", 3);
            tileArray[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/water.png")));
            tileArray[2].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("../world/map01.txt");
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

            int playerWX = (int)gp.entityLoader.player.getPositionOnTheWorld().getX();
            int playerWY = (int)gp.entityLoader.player.getPositionOnTheWorld().getY();

            int playerSX = (int)gp.entityLoader.player.getPositionOnTheScreen().getX();
            int playerSY = (int)gp.entityLoader.player.getPositionOnTheScreen().getY();

            int wx = worldCol * gp.tileSize; // world x
            int wy = worldRow * gp.tileSize; // world y
            int sx = wx - playerWX + playerSX; // screen x
            int sy = wy - playerWY + playerSY; // screen y

            if (wx > playerWX - playerSX - gp.tileSize &&
                    wy > playerWY - playerSY - gp.tileSize &&
                    wx < playerWX + playerSX + gp.tileSize * 2 &&
                    wy < playerWY + playerSY + gp.tileSize * 2) {
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
