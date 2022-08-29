package main;

import entity.EntityLoader;
import map.tiles.TileLoader;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // FPS
    private int FPS = 60;

    // values of columns and rows of the screen
    private final int colScreenNumber = 30;
    private final int rowScreenNumbers = 15;

    // value of columns and rows of the world
    public final int colWorldNumber = 50;
    public final int rowWorldNumber = 50;

    // scaled and tiles values
    private final int scaled = 4;
    public final int tileSize = 16 * scaled;

    // with and height of screen
    public final int WIDTH = colScreenNumber * tileSize;
    public final int HEIGHT = rowScreenNumbers * tileSize;

    // game thread
    Thread gameThread;

    // key manager
    public KeyHandler kh;

    // collision checker
    private CollisionChecker collisionChecker;

    // entity managers
    public EntityLoader entityLoader;

    // tiles manager
    TileLoader tileLoader;

    // class builder
    public GamePanel() {
        // init thread game
        gameThread = new Thread(this);

        // init key manager
        kh = new KeyHandler();

        // init collision checker
        collisionChecker = new CollisionChecker(this);

        // init tile loader
        tileLoader = new TileLoader(this);

        // entityLoader
        entityLoader = new EntityLoader(this);

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
    }

    public void startGameThread() {
        gameThread.start();
    }

    private void update() {
        entityLoader.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileLoader.draw(g2);

        entityLoader.draw(g2);

        g2.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                collisionChecker.startCheckCollisions();
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
}
