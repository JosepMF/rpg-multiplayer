package main;

import entity.object.ObjectLoader;

public class CollisionChecker {
    GamePanel gp;

    ObjectLoader ol;

    public CollisionChecker(GamePanel gp, ObjectLoader ol) {
        this.gp = gp;
        this.ol = ol;
    }

    protected void checkAllCollisions() {
        ol.checkCollisions();
    }
}
