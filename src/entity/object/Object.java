package entity.object;

import entity.Entity;
import main.GamePanel;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

public class Object extends Entity {
    public String nameObject;
    public long id;
    
    public Object(long id, String nameObject, int x, int y, GamePanel gp) {

        this.id = id;
        this.nameObject = nameObject;

        this.worldX = x;
        this.worldY = y; 

        this.width = gp.squareSize;
        this.height = gp.squareSize; 

        this.r = new Rectangle(x,y,width,height);
    }

    public boolean checkCollitions(Rectangle r) {
        return this.r.intersects(r);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(worldX, worldY, width, height);
    }
}
