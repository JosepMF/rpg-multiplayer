package entity.object;

import entity.Entity;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperObject extends Entity {
    public GamePanel gp;
    public BufferedImage image;
    public String name;
    public int colNumber;
    public int rowNumber;

    // draw object
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // drawing object
        g2.drawImage(image,screenX,screenY,gp.squareSize,gp.squareSize, null);

        // load rectangle object
        r = new Rectangle();
        r.x = screenX;
        r.y = screenY;
        r.width = width;
        r.height = height;
    }

    public abstract void action();
}
