package map.tiles;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Tile {
    /**
     * 
     *  In the future, this class will is change to print images,
     *  but to the moment, print rectangles to test the map generator
     * 
     * */ 

     public BufferedImage image;
     public String name;
     public int id;
     public boolean collisions = false;

     public Tile(String name, int id) {
        this.name = name;
        this.id = id;
     }
}
