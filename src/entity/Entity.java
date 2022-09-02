
package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public abstract class Entity {

    // globals variables
    protected GamePanel gp;

    // entity speed
    protected int speed;

    // screen coordinates
    protected int screenX;
    protected int screenY;

    // world coordinates
    protected int worldX;
    protected int worldY;

    // entity bounds
    protected int width;
    protected int height;

    // entity settings
    public String entityName;
    public int liveLevel;
    public int damage;
    public int protection;
    public boolean isALive = true;
    public Entity[] inventory;

    // draw entity
    public abstract void draw(Graphics2D g2);

    // update entity
    public abstract void update();

    // get position on the world
    public Point getPositionOnTheWorld() {
        return new Point(worldX, worldY);
    }

    // set position of the entity on the world
    public void setPositionOnTheWorld(int col, int row) {
        this.worldX = (col * gp.tileSize) + width;
        this.worldY = (row * gp.tileSize) + height;
    }

    // get position on the screen
    public Point getPositionOnTheScreen() {
        return new Point(screenX, screenY);
    }

    public Dimension getDimensions() {
        return new Dimension(width, height);
    }
}
