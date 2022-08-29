package entity.player;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class Player extends Entity {
    public Player(GamePanel gp) {
        // global variables
        this.gp = gp;

        // dimensions
        this.width = this.gp.tileSize;
        this.height = this.gp.tileSize;

        // point screen
        this.screenX = (this.gp.WIDTH / 2) - this.width;
        this.screenY = (this.gp.HEIGHT / 2) - this.height;

        // speed
        this.speed = 7;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(screenX,screenY,width,height);
    }

    @Override
    public void update() {
        if(this.gp.kh.w) {
            worldY-=speed;
        }
        if(this.gp.kh.a) {
            worldX-=speed;
        }
        if(this.gp.kh.s) {
            worldY+=speed;
        }
        if(this.gp.kh.d) {
            worldX+=speed;
        }
    }
}
