package entity.player;

import entity.Entity;
import main.GamePanel;
import main.KeyHandler;

public class SuperPlayer extends Entity {
    public long id;
    public int speed;
    public String direction;
    GamePanel gp;
    KeyHandler kh;
}
