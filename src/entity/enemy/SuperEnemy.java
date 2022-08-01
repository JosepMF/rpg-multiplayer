package entity.enemy;

import entity.Entity;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperEnemy extends Entity {
    public GamePanel gp;
    public Color color;
    public String name;
    public int enemyID;
    public BufferedImage image; // use this when the textures of enemy's will create.
    protected int sx;
    protected int sy;
    protected int trackedAreaDistance;
    protected boolean isTrackedPlayer = false;

    public void draw(Graphics2D g2) {
        sx = worldX - gp.player.worldX + gp.player.screenX;
        sy = worldY - gp.player.worldY + gp.player.screenY;

        r.x = sx;
        r.y = sy;

        g2.setColor(color);
        g2.fillOval(sx, sy, width, height);
    }

    public void damageItSelf(float damage) {
        liveLevels -= damage;
    }

    protected void setTrackedArea() {
        if(gp.player.worldX > worldX - trackedAreaDistance              &&
                gp.player.worldY > worldY - trackedAreaDistance         &&
                gp.player.worldX < worldX + width + trackedAreaDistance &&
                gp.player.worldY < worldY + height +trackedAreaDistance
        ) {
            isTrackedPlayer = true;
        }
    }

    // update method mey is different in some cases.
    public abstract void update();
}
