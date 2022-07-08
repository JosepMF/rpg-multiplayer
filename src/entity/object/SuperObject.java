package entity.object;

import main.GamePanel;

import java.awt.*;

public class SuperObject {
    public GamePanel gp;
    public int worldX, worldY;
    public Color color;

    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        g2.setColor(color);
        g2.fillOval(screenX,screenY,gp.squareSize,gp.squareSize);
    }
}
