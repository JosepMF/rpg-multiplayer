package main;

import entity.Entity;

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
                    for(int j = 0; j <= entity.inventory.length - 1; j++) {
                        if(entity.inventory[i] == null) {
                            entity.inventory[i] = objects[i];
                            objects[i] = null;
                            break;
                        }
                    }
                }
            }
        }
    }
}
