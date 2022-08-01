package entity.enemy.enemies;

import entity.enemy.SuperEnemy;
import main.GamePanel;

import java.awt.*;

public class Slime extends SuperEnemy {
    public Slime(GamePanel gp, int x, int y) {
        this.enemyID = 1;
        this.name = "Slime";
        this.gp = gp;
        this.speed = 1;
        this.damage = (float) 0.01;
        this.liveLevels = 1;
        this.color = Color.GRAY;
        this.trackedAreaDistance = this.gp.squareSize * 10;

        this.direction = "RIGHT";

        this.width = this.gp.squareSize;
        this.height = this.gp.squareSize;

        this.worldX = x;
        this.worldY = y;

        this.r = new Rectangle(worldX, worldY, width, height);
    }

    @Override
    public void update() {
        setTrackedArea();
        controllers();
        attack();
    }

    private void controllers() {
        if(isTrackedPlayer) {
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
    }

    private void attack() {
        if (r.intersects(gp.player.r)) {
            gp.player.liveLevels -= damage;
        }
    }
}
