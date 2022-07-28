package entity.object.obj;

import entity.object.SuperObject;
import main.GamePanel;

public class MediumSword extends SuperObject {
    public MediumSword(int colNumber, int rowNumber, GamePanel gp) {
        this.gp = gp;
        this.name = "medium_sword";
        this.damage = (float)0.25;
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.worldX = this.colNumber * this.gp.squareSize;
        this.worldY = this.rowNumber * this.gp.squareSize;
        this.width = this.gp.squareSize;
        this.height = this.gp.squareSize;
        this.loadImage("../res/mediumSword.png");
    }
    @Override
    public void action() {
        for (int i = 0; i <= gp.enemyLoader.enemies.length - 1; i++) {
            if(gp.enemyLoader.enemies[i] != null) {
                gp.enemyLoader.enemies[i].liveLevels -= damage;
            }
        }
    }
}

