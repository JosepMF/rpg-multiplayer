package entity.object;

import entity.object.obj.TestObject;
import main.GamePanel;

import java.awt.*;

public class ObjectLoader {
    GamePanel gp;

    SuperObject[] testObjects;
    public ObjectLoader(GamePanel gp) {
        this.gp = gp;

        // init tests objects array
        testObjects = new SuperObject[10];
    }

    public void loadObjects() {
        // TODO: are a big problem in detection of object entity's
        testObjects[0] = new TestObject(500,500,this.gp);
        testObjects[1] = new TestObject(200,200,this.gp);
        testObjects[2] = new TestObject(250,400,this.gp);
    }

    public void drawObjects(Graphics2D g2) {
        for (SuperObject testObject : testObjects) {
            if (testObject != null) {
                testObject.draw(g2);
            }
        }
    }

    public void checkCollisions() {
        for (SuperObject testObject : testObjects) {
            if (testObject != null) {
                testObject.checkCollisions(gp.player);
            }
        }
    }
}
