package entity;

import entity.object.SuperObject;

import java.awt.Rectangle;

public class Entity {
    public SuperObject[] objInventory;
    public int worldX, worldY;
    public int width, height;
    public Rectangle r;
    public boolean collisionOn = false;
    public String direction = "UP";
    public String preDirection = "UP";
    public int speed;

}
