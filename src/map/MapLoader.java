package map;

import main.GamePanel;
import map.tiles.TileLoader;

import java.awt.Graphics2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapLoader {
    GamePanel gp;
    public TileLoader tileLoader;
    public int[][] mapTileNum;

    public MapLoader(GamePanel gp) {
        this.gp = gp;

        mapTileNum = new int[gp.colWorldNumber][gp.rowWorldNumber];

        tileLoader = new TileLoader();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("res/map01.txt");
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

            int wx = worldCol * gp.squareSize; // world x
            int wy = worldRow * gp.squareSize; // world y
            int sx = wx - gp.player.worldX + gp.player.screenX; // screen x
            int sy = wy - gp.player.worldY + gp.player.screenY; // screen y
            
            if(wx > gp.player.worldX - gp.player.screenX - gp.squareSize &&
               wy > gp.player.worldY - gp.player.screenY - gp.squareSize &&
               wx < gp.player.worldX + gp.player.screenX + gp.squareSize*2 &&
               wy < gp.player.worldY + gp.player.screenY + gp.squareSize*2) {
                // tile drawer
                g2.drawImage(tileLoader.tiles[num].image, sx, sy, gp.squareSize, gp.squareSize, null);
            }
            worldCol++;

            if (worldCol == gp.colWorldNumber) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
