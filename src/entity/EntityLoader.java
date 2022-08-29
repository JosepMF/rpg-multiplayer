package entity;

import entity.objects.ObjectLoader;
import entity.player.Player;
import main.GamePanel;

import java.awt.*;

public class EntityLoader {
    // player
    public Player player;

    // objects
    public ObjectLoader objectLoader;

    public EntityLoader(GamePanel gp) {
        // init player
        player = new Player(gp);

        // init object loader
        objectLoader = new ObjectLoader(gp);
    }

    public void update() {
        player.update();
    }

    public void draw(Graphics2D g2) {
        objectLoader.draw(g2);
        player.draw(g2);
    }
}
