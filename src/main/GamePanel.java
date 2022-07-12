package main;

import java.awt.*;

import javax.swing.JPanel;

import entity.object.ObjectLoader;
import entity.player.Player;
import map.MapLoader;

public class GamePanel extends JPanel implements Runnable {
    public final int rowNumber = 20;
    public final int colNumber = 30;
    private final int scale = 2;
    public final int squareSize = 16 * scale;

    public final int screenWidth = colNumber * squareSize;
    public final int screenHeigth = rowNumber * squareSize;

    MapLoader mapLoader;

    // World settings

    public final int rowWorldNumber = 50;
    public final int colWorldNumber = 50;
    public final int worldWith = colWorldNumber * squareSize;
    public final int worldHeigth = rowWorldNumber * squareSize;

    ObjectLoader objectLoader; // object loader class
    public CollisionChecker collisionChecker; // collision checker class

    // FPS
    int FPS = 60;

    public Player player; // testing player

    public KeyHandler kh = new KeyHandler();

    public Thread gameThread;

    Dimension panelDimensions = new Dimension(screenWidth, screenHeigth);

    /**
     * Game panel constructor
     */

    public GamePanel() {
        gameThread = new Thread(this);

        player = new Player(this, kh, 1);

        objectLoader = new ObjectLoader(this);
        objectLoader.loadObjects();

        collisionChecker = new CollisionChecker(this, objectLoader);

        mapLoader = new MapLoader(this);
        mapLoader.loadMap();

        this.setPreferredSize(panelDimensions);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
    }

    // start the game therad

    public void startGame() {
        gameThread.start();
    }

    // draw the components in the game.

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        mapLoader.draw(g2);

        objectLoader.drawObjects(g2);

        player.draw(g2);

        gameOverM(g2);

        g2.dispose();
    }

    // update components

    private void update() {
        player.update();
    }

    // checking collisions

    private void checkCollisions() {
        collisionChecker.checkAllCollisions();
    }

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
                checkCollisions();
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

    // test game fake
    public boolean gameOver = false;

    private void gameOverM(Graphics2D g2) {
        if(gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,40));
            g2.drawString("You won", screenWidth/2-40, 40);
        }
    }
}
