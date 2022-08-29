package entity;

import entity.player.Player;
import main.GamePanel;

import java.awt.*;

public class EntityLoader {
    // player
    public Player player;

    public EntityLoader(GamePanel gp) {
        // init player
        player = new Player(gp);
    }

    public void update() {
        player.update();
    }

    public void draw(Graphics2D g2) {
        player.draw(g2);
    }
}
