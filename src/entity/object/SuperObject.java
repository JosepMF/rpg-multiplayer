package entity.object;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public abstract class SuperObject extends Entity {
    public GamePanel gp;
    public Color color;

    // draw object
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // drawing object
        g2.setColor(color);
        g2.fillOval(screenX,screenY,gp.squareSize,gp.squareSize);

        // load rectangle object
        r = new Rectangle();
        r.x = screenX;
        r.y = screenY;
        r.width = width;
        r.height = height;
    }

    public abstract void action();
}
