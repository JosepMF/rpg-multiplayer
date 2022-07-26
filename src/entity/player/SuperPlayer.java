package entity.player;

import entity.Entity;
import entity.object.SuperObject;
import main.GamePanel;
import main.KeyHandler;

public class SuperPlayer extends Entity {
    public long id;
    public SuperObject[] objInventory;
    GamePanel gp;
    KeyHandler kh;
    public float liveLevels = 3;

}
