package entity.object.obj;

import entity.object.SuperObject;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class GoodSword extends SuperObject {
    public GoodSword(int colNumber, int rowNumber, GamePanel gp) {
        this.gp = gp;
        this.name = "good_sword";
        this.damage = (float)0.5;
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.worldX = this.colNumber * this.gp.squareSize;
        this.worldY = this.rowNumber * this.gp.squareSize;
        this.width = this.gp.squareSize;
        this.height = this.gp.squareSize;
        this.loadImage();
    }
    @Override
    public void action() {
        for (int i = 0; i <= gp.enemyLoader.enemies.length - 1; i++) {
            if(gp.enemyLoader.enemies[i] != null) {
                gp.enemyLoader.enemies[i].liveLevels -= damage;
            }
        }
    }

    private void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/goodSword.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

