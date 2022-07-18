package entity.enemy.enemies;

import entity.enemy.SuperEnemy;
import main.GamePanel;

import java.awt.*;

public class Slime extends SuperEnemy {
    private int counter = 0;

    public Slime(GamePanel gp, int x, int y) {
        this.enemyID = 1;
        this.name = "Slime";
        this.speed = 10;
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
        counter++;
        if(counter == 5) {
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
            counter = 0;
        }
    }

    private void attack() {
        if (r.intersects(gp.player.r)) {
            gp.player.liveLevels -= damage;
        }
    }
}
