package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.player.Player;

public class GamePanel extends JPanel implements Runnable {
    int rowNumber = 30;
    int colNumber = 20;
    int scale = 2;
    public int squareSize = 16 * scale;

    public int screenWidth = rowNumber * squareSize;
    public int screenHeigth = colNumber * squareSize;

    int FPS = 60;

    Player player; // testing player

    public KeyHandler kh = new KeyHandler();

    Thread gameThread;

    Dimension panelDimensions = new Dimension(screenWidth, screenHeigth);

    /**
     * 
     *  Game panel constructor
     * 
     * */ 

    public GamePanel() {
        gameThread = new Thread(this);

        player = new Player(this, kh, 1);

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

        player.draw(g2);

        g2.dispose();
    }

    // update components

    private void update() {
        player.update();
    }

    // checking collitions

    private void checkCollitions() {
        // TODO: set the collitions of the objects and tiles
    }

    /**
     * 
     * this is the game loop of the panel game, iside this,
     * do updates, draws and check collitions of the components.
     * 
     */

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
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

            if(delta >= 1) {
                update();
                checkCollitions();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

}
