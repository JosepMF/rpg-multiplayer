package entity.object.obj;

import entity.object.SuperObject;
import main.GamePanel;

public class MediumSword extends Sword {
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
}

