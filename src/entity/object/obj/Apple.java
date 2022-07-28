package entity.object.obj;

import entity.object.SuperObject;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Apple extends SuperObject {
    public Apple(int colNumber, int rowNumber, GamePanel gp) {
        this.gp = gp;
        this.name = "apple";
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.worldX = this.colNumber * gp.squareSize;
        this.worldY = this.rowNumber * gp.squareSize;
        this.width = gp.squareSize;
        this.height = gp.squareSize;
        this.loadImage("../res/apple.png");
    }

    @Override
    public void action() {
        gp.player.liveLevels++;
    }
}
