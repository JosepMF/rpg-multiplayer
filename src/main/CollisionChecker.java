package main;

import entity.Entity;
import utils.Directions;

public class CollisionChecker {
    GamePanel gp;


    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void startCheckCollisions() {
        objectsCollisionsChecker(gp.entityLoader.player);
    }

    public void objectsCollisionsChecker(Entity entity) {
        int col = (int) (entity.getPositionOnTheWorld().getX() + (entity.getDimensions().width / 2)) / gp.tileSize;
        int row = (int) (entity.getPositionOnTheWorld().getY() + (entity.getDimensions().height / 2)) / gp.tileSize;

        Entity[] objects = gp.entityLoader.objectLoader.objects;

        for (int i = 0; i <= objects.length - 1; i++) {
            if (objects[i] != null) {
                int colObject = (int) objects[i].getPositionOnTheWorld().getX() / gp.tileSize;
                int rowObject = (int) objects[i].getPositionOnTheWorld().getY() / gp.tileSize;

                if (colObject == col && rowObject == row) {
                    for (int j = 0; j <= entity.inventory.length - 1; j++) {
                        if (entity.inventory[i] == null) {
                            entity.inventory[i] = objects[i];
                            objects[i] = null;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void tilesCollisionChecker(Entity entity) {
        int col = (int) (entity.getPositionOnTheWorld().getX() + (entity.getDimensions().width / 2)) / gp.tileSize;
        int row = (int) (entity.getPositionOnTheWorld().getY() + (entity.getDimensions().height / 2)) / gp.tileSize;

        int colTile = col;
        int rowTile = row;

        String direction = entity.direction;

        if (direction.equals(Directions.UP))
            rowTile = (int) (row - 0.5);
        if (direction.equals(Directions.DOWN))
            rowTile = (int) (row + 0.5);
        if (direction.equals(Directions.LEFT))
            colTile = (int) (col - 0.5);
        if (direction.equals(Directions.RIGHT))
            colTile = (int) (col + 0.5);

        try {
            int tileOverPosition = gp.tileLoader.mapTileNum[col][row];
            int tilePointed = gp.tileLoader.mapTileNum[colTile][rowTile];
            System.out.println(gp.tileLoader.tileArray[tilePointed].name);

            if (gp.tileLoader.tileArray[tileOverPosition].collision) {
                entity.collisions = gp.tileLoader.tileArray[tilePointed].collision;
            }
        } catch (Exception e) {

        }

        /*switch (direction) {
            case "UP": {
                System.out.println("up");
            }
            case "DOWN": {
                System.out.println("down");
            }
            case "RIGHT": {
                System.out.println("right");
            }
            case "LEFT": {
                System.out.println("left");
            }
        }*/
    }
}
