package entity.objects;

import entity.Entity;
import entity.objects.objects.food.Apple;
import main.GamePanel;

import java.awt.*;

public class ObjectLoader {
    public Entity[] objects;

    GamePanel gp;

    public ObjectLoader(GamePanel gp) {
        this.gp = gp;

        objects = new Entity[3];

        this.loadObjectsOnArray();
    }

    public void loadObjectsOnArray() {
        System.out.println("sex");
        objects[0] = new Apple(this.gp);
        objects[0].setPositionOnTheWorld(2,2);

        objects[1] = new Apple(this.gp);
        objects[1].setPositionOnTheWorld(3,2);

        objects[2] = new Apple(this.gp);
        objects[2].setPositionOnTheWorld(4,2);
    }

    public void draw(Graphics2D g2) {
        for (Entity obj :
                objects) {
            if (obj != null) {
                obj.draw(g2);
            }
        }
    }
}
