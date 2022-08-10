package main;

import java.awt.*;

import javax.swing.JPanel;

import entity.enemy.EnemyLoader;
import entity.object.ObjectLoader;
import entity.player.Player;
import map.MapLoader;
import ui.UI;

public class GamePanel extends JPanel implements Runnable {
    public final int rowNumber = 20;
    public final int colNumber = 30;
    private final int scale = 2;
    public final int squareSize = 16 * scale;

    public final int screenWidth = colNumber * squareSize;
    public final int screenHeigth = rowNumber * squareSize;
    public boolean gameOver = false;

    MapLoader mapLoader;

    // World settings

    public final int rowWorldNumber = 100;
    public final int colWorldNumber = 100;
    public final int worldWith = colWorldNumber * squareSize;
    public final int worldHeigth = rowWorldNumber * squareSize;

    public ObjectLoader objectLoader; // object loader class
    public CollisionChecker collisionChecker; // collision checker class
    public EnemyLoader enemyLoader;

    // FPS
    int FPS = 60;

    public Player player; // testing player

    public KeyHandler kh = new KeyHandler();

    public Thread gameThread;

    Dimension panelDimensions = new Dimension(screenWidth, screenHeigth);

    UI ui;

    /**
     * Game panel constructor
     */

    public GamePanel() {
        gameThread = new Thread(this);

        objectLoader = new ObjectLoader(this);
        objectLoader.loadObjectsOnTheMap();

        collisionChecker = new CollisionChecker(this, objectLoader);

        enemyLoader = new EnemyLoader(this);
        enemyLoader.loadEnemies();

        mapLoader = new MapLoader(this);
        mapLoader.loadMap();

        ui = new UI(this, kh);

        player = new Player(this, kh, 1);

        this.setPreferredSize(panelDimensions);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
    }

    // start the game thread

    public void startGame() {
        gameThread.start();
    }

    // draw the components in the game.

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        mapLoader.draw(g2);

        objectLoader.drawObjects(g2);

        enemyLoader.drawAndUpdate(g2);

        player.draw(g2);

        ui.draw(g2);

        g2.dispose();
    }

    // update components

    private void update() {
        player.update();
    }

    // checking collisions

    /**
     * this is the game loop of the panel game, iside this,
     * do updates, draws and check collisions of the components.
     */

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
