package entity.object.obj;

import main.GamePanel;

public class BadSword extends Sword {
    public BadSword(int colNumber, int rowNumber, GamePanel gp) {
        this.gp = gp;
        this.name = "bad_sword";
        this.damage = (float)0.1;
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.worldX = this.colNumber * this.gp.squareSize;
        this.worldY = this.rowNumber * this.gp.squareSize;
        this.width = this.gp.squareSize;
        this.height = this.gp.squareSize;
        this.loadImage("../res/badSword.png");
    }
}
