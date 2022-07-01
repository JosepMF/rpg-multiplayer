package map;

import main.GamePanel;
import map.tiles.TileLoader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapLoader {
    GamePanel gp;
    TileLoader tileLoader;
    int[][] mapTileNum;

    public MapLoader(GamePanel gp) {
        this.gp = gp;

        mapTileNum = new int[gp.colNumber][gp.rowNumber];

        tileLoader = new TileLoader();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("res/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            
            while (col < gp.colNumber && row < gp.rowNumber) {
                String line = br.readLine();
                
                while(col < gp.colNumber) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.colNumber) {
                    col = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int x = 0;
        int y = 0;
        int row = 0;
        int col = 0;
        while (col < gp.colNumber && row < gp.rowNumber) {
            int num = mapTileNum[col][row];

            g2.setColor(tileLoader.tiles[num].color);
            g2.fillRect(x, y, gp.squareSize, gp.squareSize);

            x += gp.squareSize;
            col++;

            if (col == gp.colNumber) {
                x = 0;
                col = 0;
                y += gp.squareSize;
                row++;
            }
        }
    }
}
