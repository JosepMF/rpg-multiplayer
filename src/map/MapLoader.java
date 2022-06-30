package map;

import main.GamePanel;
import map.tiles.TileLoader;

import java.awt.*;

public class MapLoader {
    GamePanel gp;
    TileLoader tileLoader;

    public MapLoader(GamePanel gp) {
        this.gp = gp;

        tileLoader = new TileLoader();
    }

    private void loadMap() {
        
    }

    public void draw(Graphics2D g2) {
        int x = 0;
        int y = 0;
        int row = 0;
        int col = 0;
        while (col < gp.colNumber*2 && row < gp.rowNumber) {
            g2.setColor(tileLoader.tiles[0].color);
            g2.fillRect(x,y,gp.squareSize,gp.squareSize);

            x += gp.squareSize;
            col++;

            if(col == gp.colNumber*2) {
                x = 0;
                col = 0;
                y += gp.squareSize;
                row++;
            }
        }
    }
}
