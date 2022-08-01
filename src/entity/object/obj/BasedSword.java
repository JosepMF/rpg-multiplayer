package entity.object.obj;

import main.GamePanel;

public class BasedSword extends Sword {
    public BasedSword(int colNumber, int rowNumber, GamePanel gp) {
        this.gp = gp;
        this.name = "based_sword";
        this.damage = (float)999999.0;
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.worldX = this.colNumber * this.gp.squareSize;
        this.worldY = this.rowNumber * this.gp.squareSize;
        this.width = this.gp.squareSize;
        this.height = this.gp.squareSize;
        this.loadImage("../res/basedSword.png");
    }
}

