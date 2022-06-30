package map.tiles;

import java.awt.Color;

public class Tile {
    /**
     * 
     *  In the future, this class will is change to print images,
     *  but to the moment, print rectangles to test the map generator
     * 
     * */ 

     public Color color;
     public String name;
     public int id;
     public boolean collitions = false;

     public Tile(Color color, String name, int id) {
        this.color = color;
        this.name = name;
        this.id = id;
     }
}
