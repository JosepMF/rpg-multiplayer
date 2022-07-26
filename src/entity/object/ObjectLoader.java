package entity.object;

import entity.object.obj.Apple;

import main.GamePanel;

import java.awt.*;

public class ObjectLoader {
    GamePanel gp;

    public SuperObject[] objects;

    public SuperObject[][] objectsOnTheWorld;

    public ObjectLoader(GamePanel gp) {
        this.gp = gp;

        // init tests objects array
        objects = new SuperObject[10];
        objectsOnTheWorld = new SuperObject[gp.colWorldNumber][gp.rowWorldNumber];
    }

    public void loadObjectsOnTheMap() {
        // TODO: are a big problem in detection of object entity's
        objectsOnTheWorld[12][14] = new Apple(12, 14, this.gp);
        objectsOnTheWorld[50][50] = new Apple(50, 50, this.gp);
        objectsOnTheWorld[18][30] = new Apple(18, 30, this.gp);
        objectsOnTheWorld[70][10] = new Apple(70, 10, this.gp);
    }

    private void loadObjectsOnArray() {
        objects[0] = objectsOnTheWorld[12][14];
        objects[1] = objectsOnTheWorld[50][50];
        objects[2] = objectsOnTheWorld[18][30];
        objects[3] = objectsOnTheWorld[70][10];
    }

    public void drawObjects(Graphics2D g2) {
        loadObjectsOnArray();
        for (SuperObject obj : objects) {
            if (obj != null) {
                obj.draw(g2);
            }
        }
    }
}
