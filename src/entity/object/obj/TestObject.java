package entity.object.obj;

import entity.object.SuperObject;
import main.GamePanel;

import java.awt.*;

public class TestObject extends SuperObject {
    public TestObject(int wx, int wy, GamePanel gp) {
        this.worldX = wx;
        this.worldY = wy;
        this.gp = gp;
        this.color = Color.RED;
    }
}
