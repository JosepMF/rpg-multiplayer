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
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(screenX,screenY,width,height);
    }

    @Override
    public void update() {
        if(this.gp.kh.w) {
            System.out.println("up");
        }
        if(this.gp.kh.a) {
            System.out.println("left");
        }
        if(this.gp.kh.s) {
            System.out.println("down");
        }
        if(this.gp.kh.d) {
            System.out.println("right");
        }
    }
}
