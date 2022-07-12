package entity;

import java.awt.Rectangle;

public class Entity {
    public int worldX, worldY;
    public int width, height;
    public Rectangle r;
    public boolean collisionOn = false;
    public String direction = "UP";
    public String preDirection = "UP";
    public int speed;

}
