package ui;

import entity.Entity;
import entity.player.Player;
import main.GamePanel;

import java.awt.*;
import java.util.Arrays;

public class UI {
    GamePanel gp;

    public UI(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        showInventory(g2);
    }

    private void showInventory(Graphics2D g2) {
        if (this.gp.kh.e) {
            Player player = gp.entityLoader.player;

            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, this.gp.WIDTH, this.gp.HEIGHT);
            g2.setColor(Color.WHITE);
            g2.drawLine(gp.WIDTH / 2, 0, gp.WIDTH / 2, gp.HEIGHT);

            // inventory
            int y = 70;
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("arial", Font.ITALIC, 50));
            for (int i = 0; i <= player.inventory.length - 1; i++) {
                if (player.inventory[i] != null) {
                    g2.drawString(player.inventory[i].entityName, 50, y);
                } else {
                    g2.drawString("empty", 50, y);
                }
                if (i == player.inventoryIndex) {
                    g2.fillOval(5, y - 25, 20, 20);
                }
                y += 70;
            }

            // status
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("arial", Font.ITALIC, 50));
            g2.drawString("LV: " + player.liveLevel, (int) (gp.WIDTH / 1.9), 60);
            g2.drawString("DAMAGE: " + player.damage, (int) (gp.WIDTH / 1.9), 150);
            g2.drawString("ARMOR: " + player.protection, (int) (gp.WIDTH / 1.9), 250);
            g2.drawString("ROLE: " + null, (int) (gp.WIDTH / 1.9), 350);
        }
    }
}
