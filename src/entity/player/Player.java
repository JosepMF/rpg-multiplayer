package entity.player;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class Player extends Entity {
    int counter;

    // index inventory
    public int inventoryIndex = 0;

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

        // inventory
        this.inventory = new Entity[7];

        // entity settings
        this.damage = 1;
        this.liveLevel = 3;
        this.protection = 3;
        this.entityName = "Player";
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(screenX, screenY, width, height);
    }

    @Override
    public void update() {
        control();
        inventoryManager();
    }

    // control
    private void control() {
        if (!gp.kh.e) {
            if (this.gp.kh.w) {
                worldY -= speed;
            }
            if (this.gp.kh.a) {
                worldX -= speed;
            }
            if (this.gp.kh.s) {
                worldY += speed;
            }
            if (this.gp.kh.d) {
                worldX += speed;
            }
            if (counter == 200) {
                counter = 0;
            }
            counter++;
        }
    }

    private void inventoryManager() {
        if (gp.kh.e) {
            if (gp.kh.w && inventoryIndex > 0) {
                inventoryIndex--;
            }
            if (gp.kh.s && inventoryIndex < inventory.length - 1) {
                inventoryIndex++;
            }
        }
        if (gp.kh.enter) {
            Entity object = inventory[inventoryIndex];
            if (object != null) {
                System.out.println("sex");
                object.update();
                inventory[inventoryIndex] = null;
            }
        }
    }
}

