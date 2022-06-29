package entity.player;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyHandler;

public class Player extends SuperPlayer implements ActionPlayer {
    public Player(GamePanel gp, KeyHandler kh, long id) {
        
        this.speed = 3;
        
        this.gp = gp;
        this.kh = kh;
        this.id = id;
        
        this.width = gp.squareSize;
        this.height = gp.squareSize;
        
        this.x = gp.screenWidth / 2 - this.width / 2;
        this.y = gp.screenHeigth / 2 - this.height / 2;
        
        this.r = new Rectangle(x - width/2, y - height/2, width/2, height/2);
    }
    
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(x, y, width, height);
    }

    @Override
    public void update() {
        if (kh.up) {
            y -= speed;
            r.y = y;
        }
        if (kh.down) {
            y += speed;
            r.y = y;
        }
        if (kh.left) {
            x -= speed;
            r.x = x;
        }
        if (kh.right) {
            x += speed;
            r.x = x;
        }
        System.out.println(r.getX() + " " + r.getY());
    }
}
