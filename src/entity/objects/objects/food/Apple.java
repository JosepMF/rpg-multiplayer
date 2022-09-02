package entity.objects.objects.food;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Apple extends Entity {
    private BufferedImage image;

    public Apple(GamePanel gp) {
        // init global variables
        this.gp = gp;

        // init dimensions
        this.width = gp.tileSize / 2;
        this.height = gp.tileSize / 2;

        // init settings of this entity
        this.entityName = "Apple";
        this.liveLevel = 1;

        // load textures
        loadTextures();
    }

    private void loadTextures() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("./res/apple.png")));
            System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        int playerWX = (int)gp.entityLoader.player.getPositionOnTheWorld().getX();
        int playerWY = (int)gp.entityLoader.player.getPositionOnTheWorld().getY();

        int playerSX = (int)gp.entityLoader.player.getPositionOnTheScreen().getX();
        int playerSY = (int)gp.entityLoader.player.getPositionOnTheScreen().getY();

        screenX = worldX - playerWX + playerSX; // screen x
        screenY = worldY - playerWY + playerSY; // screen y

        g2.drawImage(image, screenX, screenY, width, height, null);
    }

    @Override
    public void update() {
        gp.entityLoader.player.liveLevel += liveLevel;
    }
}
