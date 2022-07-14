package entity.enemy.enemies;

import entity.enemy.SuperEnemy;
import main.GamePanel;

import java.awt.*;

public class Slime extends SuperEnemy {
    public Slime(GamePanel gp, int x, int y) {
        this.enemyID = 1;
        this.name = "Slime";
        this.speed = 1;
        this.damage = (float)0.01;
        this.liveLevels = 1;

        this.gp = gp;
        this.direction = "RIGHT";

        this.width = gp.squareSize;
        this.height = gp.squareSize;

        this.worldX = x;
        this.worldY = y;

        this.r = new Rectangle(worldX, worldY, width, height);
    }

    @Override
    public void update() {
        controllers();
        attack();
    }

    private void controllers() {
        if (gp.player.worldX > worldX) {
            worldX += speed;
        } else {
            worldX -= speed;
        }
        if (gp.player.worldY > worldY) {
            worldY += speed;
        } else {
            worldY -= speed;
        }
    }

    private void attack() {
        if (r.intersects(gp.player.r)) {
            gp.player.liveLevels -= damage;
        }
    }
}
