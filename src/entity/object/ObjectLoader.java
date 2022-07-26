package entity.object;

import entity.object.obj.*;

import main.GamePanel;

import java.awt.*;

public class ObjectLoader {
    GamePanel gp;

    public SuperObject[] objects;

    public SuperObject[][] objectsOnTheWorld;

    public ObjectLoader(GamePanel gp) {
        this.gp = gp;

        // init tests objects array
        objects = new SuperObject[20];
        objectsOnTheWorld = new SuperObject[gp.colWorldNumber][gp.rowWorldNumber];
    }

    public void loadObjectsOnTheMap() {
        // TODO: are a big problem in detection of object entity's
        objectsOnTheWorld[70][8] = new Apple(70, 9, this.gp);
        objectsOnTheWorld[70][9] = new Apple(70, 9, this.gp);
        objectsOnTheWorld[70][10] = new Apple(70, 10, this.gp);
        objectsOnTheWorld[70][11] = new Apple(70, 11, this.gp);
        objectsOnTheWorld[70][12] = new Apple(70, 12, this.gp);
        objectsOnTheWorld[70][13] = new Apple(70, 13, this.gp);
        objectsOnTheWorld[70][14] = new Apple(70, 14, this.gp);
        objectsOnTheWorld[70][15] = new Apple(70, 15, this.gp);
        objectsOnTheWorld[70][16] = new Apple(70, 16, this.gp);
        objectsOnTheWorld[70][17] = new Apple(70, 17, this.gp);
        objectsOnTheWorld[70][18] = new Apple(70, 18, this.gp);
        objectsOnTheWorld[71][8] = new BadSword(71, 8, this.gp);
        objectsOnTheWorld[71][9] = new MediumSword(71, 9, this.gp);
        objectsOnTheWorld[71][10] = new GoodSword(71, 10, this.gp);
        objectsOnTheWorld[71][11] = new BasedSword(71, 11, this.gp);
    }

    private void loadObjectsOnArray() {
        objects[0] = objectsOnTheWorld[70][8];
        objects[1] = objectsOnTheWorld[70][9];
        objects[2] = objectsOnTheWorld[70][10];
        objects[3] = objectsOnTheWorld[70][11];
        objects[4] = objectsOnTheWorld[70][12];
        objects[5] = objectsOnTheWorld[70][13];
        objects[6] = objectsOnTheWorld[70][14];
        objects[7] = objectsOnTheWorld[70][15];
        objects[8] = objectsOnTheWorld[70][16];
        objects[9] = objectsOnTheWorld[70][17];
        objects[10] = objectsOnTheWorld[70][18];
        objects[11] = objectsOnTheWorld[71][8];
        objects[12] = objectsOnTheWorld[71][9];
        objects[13] = objectsOnTheWorld[71][10];
        objects[14] = objectsOnTheWorld[71][11];
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
