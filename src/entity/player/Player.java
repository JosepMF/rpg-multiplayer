package entity.player;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyHandler;

public class Player extends SuperPlayer implements ActionPlayer {
    public int screenX;
    public int screenY;

    public Player(GamePanel gp, KeyHandler kh, long id) {

        this.speed = 3;

        this.gp = gp;
        this.kh = kh;
        this.id = id;

        this.width = gp.squareSize;
        this.height = gp.squareSize;

        this.worldX = gp.worldWith / 2 - (this.width / 2);
        this.worldY = gp.worldHeigth / 2 - (this.height / 2);

        this.screenX = gp.screenWidth / 2 - this.width / 2;
        this.screenY = gp.screenHeigth / 2 - this.height / 2;

        this.r = new Rectangle(screenX + width - width / 3, screenY + height / 3, width - width / 3, height - height / 3);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(screenX, screenY, width, height);
    }

    @Override
    public void update() {
        if (kh.up) {
            worldY -= speed;
            direction = "UP";
        }
        if (kh.down) {
            worldY += speed;
            direction = "DOWN";
        }
        if (kh.left) {
            worldX -= speed;
            direction = "LEFT";
        }
        if (kh.right) {
            worldX += speed;
            direction = "RIGHT";
        }
    }
}
