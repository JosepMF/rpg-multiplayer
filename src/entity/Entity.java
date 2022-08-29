
package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public abstract class Entity {

    // globals variables
    protected GamePanel gp;

    // screen coordinates
    public int screenX;
    public int screenY;

    // world coordinates
    public int worldX;
    public int worldY;

    // entity bounds
    protected int width;
    protected int height;

    // draw entity
    public abstract void draw(Graphics2D g2);

    // update entity
    public abstract void update();

    // get position on the world
    public Point getPositionOnTheWorld() {
        return new Point(worldX, worldY);
    }

    // get position on the screen
    public Point getPositionOnTheScreen() {
        return new Point(screenX, screenY);
    }

    public Dimension getDimensions() {
        return new Dimension(width, height);
    }
}
