package entity.player;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Rectangle;

import entity.object.SuperObject;
import main.GamePanel;
import main.KeyHandler;
import utils.Direction;

public class Player extends SuperPlayer implements ActionPlayer {
    public int screenX;
    public int screenY;
    private int objectSensibility = 0;
    public int objectIndexSelected = 0;

    public Player(GamePanel gp, KeyHandler kh, long id) {

        this.speed = 3;

        this.gp = gp;
        this.kh = kh;
        this.id = id;

        this.width = gp.squareSize;
        this.height = gp.squareSize;

        this.worldX = gp.worldWith / 2 - (this.width / 2);
        this.worldY = gp.worldHeigth / 2 - (this.height / 2);

        this.screenX = gp.screenWidth / 2 - this.width / 2;
        this.screenY = gp.screenHeigth / 2 - this.height / 2;

        this.r = new Rectangle(screenX + width - width / 3, screenY + height / 3, width - width / 3, height - height / 3);

        this.objInventory = new SuperObject[20];

        this.money = 0;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(screenX, screenY, width, height);
    }

    @Override
    public void update() {
        controllers();
        collisions();
        inventoryManage();
        gameOver();
    }

    private void gameOver() {
        if (liveLevels <= 0) {
            liveLevels = 3;
            worldX = gp.worldWith / 2 - (this.width / 2);
            worldY = gp.worldHeigth / 2 - (this.height / 2);
        }
    }

    private void controllers() {
        if (kh.up) {
            direction = Direction.UP;
        }
        if (kh.down) {
            direction = Direction.DOWN;
        }
        if (kh.left) {
            direction = Direction.LEFT;
        }
        if (kh.right) {
            direction = Direction.RIGHT;
        }

        if (kh.shift) {
            speed = 4;
        } else {
            speed = 3;
        }

        if (kh.up || kh.down || kh.left || kh.right) {
            if (!collisionOn) {
                if (direction.equals(Direction.UP)) {
                    worldY -= speed;
                }
                if (direction.equals(Direction.DOWN)) {
                    worldY += speed;
                }
                if (direction.equals(Direction.LEFT)) {
                    worldX -= speed;
                }
                if (direction.equals(Direction.RIGHT)) {
                    worldX += speed;
                }
            }

        }
    }

    // wtf

    private void collisions() {
        gp.collisionChecker.tilesCollisionController(this);
        gp.collisionChecker.checkObjectsCollisions(this);
    }

    private void inventoryManage() {
        objectSensibility++;
        if (objectSensibility == 10) {
            if (objectIndexSelected > 0 && kh.arrowLeft) {
                objectIndexSelected--;
            }
            if (objectIndexSelected < objInventory.length - 1 && kh.arrowRight) {
                objectIndexSelected++;
            }
            if (objInventory[objectIndexSelected] != null) {
                if (kh.actionEnter) {
                    objInventory[objectIndexSelected].action();
                    if (!(objInventory[objectIndexSelected].name.equals("bad_sword")      ||
                            objInventory[objectIndexSelected].name.equals("medium_sword") ||
                            objInventory[objectIndexSelected].name.equals("good_sword")   ||
                            objInventory[objectIndexSelected].name.equals("based_sword"))) {
                        objInventory[objectIndexSelected] = null;
                    }
                }
            }
        }
        if (objectSensibility == 10) {
            objectSensibility = 0;
        }
    }
}
