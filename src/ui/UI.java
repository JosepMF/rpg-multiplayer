package ui;

import entity.object.SuperObject;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class UI {
    GamePanel gp;
    KeyHandler kh;

    public UI(GamePanel gp, KeyHandler kh) {
        this.kh = kh;
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        showLive(g2);
        gameOverM(g2);
        inventory(g2);
    }

    private void showLive(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 40));
        g2.drawString("LV: " + gp.player.liveLevels, 50, 60);
    }

    private void gameOverM(Graphics2D g2) {
        if (gp.gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 40));
            g2.drawString("You won", gp.screenWidth / 2 - 40, 40);
        }
    }

    private void inventory(Graphics2D g2) {
        SuperObject[] objInventory = gp.player.objInventory;
        int iterator = 0;
        int sx;
        int sy;
        if (kh.inventory) {
            for (int i = 0; i <= objInventory.length - 1; i++) {
                sy = gp.screenHeigth - gp.squareSize;
                sx = iterator;
                if(gp.player.objectIndexSelected == i) {
                    g2.setColor(Color.RED);
                    g2.fillOval(sx, sy - gp.squareSize - 5, gp.squareSize, gp.squareSize);
                }
                if(objInventory[i] != null) {
                    g2.drawImage(objInventory[i].image, sx, sy, objInventory[i].width, objInventory[i].height, null);

                }
                else {
                    g2.setColor(Color.GRAY);
                    g2.fillRect(sx, sy, gp.squareSize, gp.squareSize);
                }
                iterator += gp.squareSize;
            }
        }
    }
}
