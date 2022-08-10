package main;

import entity.Entity;
import entity.object.ObjectLoader;
import entity.object.SuperObject;

import java.util.Arrays;

public class CollisionChecker {
    GamePanel gp;

    ObjectLoader ol;

    public CollisionChecker(GamePanel gp, ObjectLoader ol) {
        this.gp = gp;
        this.ol = ol;
    }

    // check collisions with tiles
    public void tilesCollisionController(Entity entity) {
        int col = (entity.worldX + (entity.width / 2)) / gp.squareSize;
        int row = (entity.worldY + (entity.height / 2)) / gp.squareSize;

        int tileNum = gp.mapLoader.mapTileNum[col][row];

        // TODO: change this f*ck1ng method to other algorithm more efficiency
        if (gp.mapLoader.tileLoader.tiles[tileNum].collisions) {
            entity.preDirection = entity.direction;
            switch (entity.direction) {
                case "UP":
                case "DOWN":
                    entity.worldY -= ((row * gp.squareSize) - entity.worldY);
                    break;
                case "LEFT":
                case "RIGHT":
                    entity.worldX -= ((col * gp.squareSize) - entity.worldX);
                    break;
            }
        }
        entity.collisionOn = gp.mapLoader.tileLoader.tiles[tileNum].collisions;
    }

    public void checkObjectsCollisions(Entity entity) {
        int col = (entity.worldX + (entity.width / 2)) / gp.squareSize;
        int row = (entity.worldY + (entity.height / 2)) / gp.squareSize;

        if (ol.objectsOnTheWorld[col][row] != null) {
            for (int i = 0; i <= entity.objInventory.length; i++) {
                if (entity.objInventory[i] == null) {
                    entity.objInventory[i] = ol.objectsOnTheWorld[col][row];
                    ol.objectsOnTheWorld[col][row] = null;
                    ol.loadObjectsOnArray();
                    System.out.println(ol.objectsOnTheWorld[col][row]);
                    break;
                } else if (entity.objInventory[entity.objInventory.length - 1] != null) {
                    break;
                }
            }
        }
    }
}
