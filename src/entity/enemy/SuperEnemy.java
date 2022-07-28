package entity.enemy;

import entity.Entity;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperEnemy extends Entity {
    public GamePanel gp;
    public String name;
    public int enemyID;
    public BufferedImage image; // use this when the textures of enemy's will create.
    protected int sx;
    protected int sy;

    public void draw(Graphics2D g2) {
        sx = worldX - gp.player.worldX + gp.player.screenX;
        sy = worldY - gp.player.worldY + gp.player.screenY;

        r.x = sx;
        r.y = sy;

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(sx, sy, width, height);
    }

    // update method mey is different in some cases.
    public abstract void update();
}
