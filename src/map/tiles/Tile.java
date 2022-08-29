package map.tiles;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public String name;
    public int id;
    public boolean collision = false;

    public Tile(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
