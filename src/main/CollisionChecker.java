package main;

import entity.Entity;
import entity.object.ObjectLoader;

public class CollisionChecker {
    GamePanel gp;

    ObjectLoader ol;

    public CollisionChecker(GamePanel gp, ObjectLoader ol) {
        this.gp = gp;
        this.ol = ol;
    }

    // check collisions with tiles
    public void tilesCollisionController(Entity entity) {
        int col = (entity.worldX+(entity.width/2))/gp.squareSize;
        int row = (entity.worldY+(entity.height/2))/gp.squareSize;

        int tileNum = gp.mapLoader.mapTileNum[col][row];

        if(gp.mapLoader.tileLoader.tiles[tileNum].collitions) {
            entity.collisionOn = true;
        }
    }

    protected void checkAllCollisions() {
        // check collisions with objects
        ol.checkCollisions();
    }
}
