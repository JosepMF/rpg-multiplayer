package entity.enemy;

import entity.enemy.enemies.Slime;
import main.GamePanel;

import java.awt.*;

public class EnemyLoader {
    public SuperEnemy[] enemies;
    GamePanel gp;

    public EnemyLoader(GamePanel gp) {
        this.gp = gp;

        enemies = new SuperEnemy[10];
    }

    public void loadEnemies() {
        enemies[0] = new Slime(gp, 33*gp.squareSize, 47* gp.squareSize);
    }

    public void drawAndUpdate(Graphics2D g2) {
        for(SuperEnemy enemy : enemies) {
            if(enemy != null) {
                enemy.draw(g2);
                enemy.update();
            }
        }
    }
}
