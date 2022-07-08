package entity.object;

import entity.object.obj.TestObject;
import main.GamePanel;

import java.awt.*;

public class ObjectLoader {
    GamePanel gp;

    TestObject[] testObjects;
    public ObjectLoader(GamePanel gp) {
        this.gp = gp;

        // init tests objects array
        testObjects = new TestObject[10];
    }

    public void loadObjects() {
        testObjects[0] = new TestObject(500,500,this.gp);
        testObjects[1] = new TestObject(200,200,this.gp);
    }

    public void drawObjects(Graphics2D g2) {
        for (TestObject testObject : testObjects) {
            if (testObject != null) {
                testObject.draw(g2);
            }
        }
    }
}
