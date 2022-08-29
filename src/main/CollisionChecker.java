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
        int col = (int) entity.getPositionOnTheWorld().getX() / gp.tileSize;
        int row = (int) entity.getPositionOnTheWorld().getY() / gp.tileSize;

        Entity[] objects = gp.entityLoader.objectLoader.objects;

        for (int i = 0; i <= objects.length - 1; i++) {
            if (objects[i] != null) {
                int colObject = (int) objects[i].getPositionOnTheWorld().getX() / gp.tileSize;
                int rowObject = (int) objects[i].getPositionOnTheWorld().getY() / gp.tileSize;

                if (colObject == col && rowObject == row) {
                    objects[i] = null;
                }
            }
        }
    }
}
