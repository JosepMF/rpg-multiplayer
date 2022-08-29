package main;

import javax.swing.*;

public class GameFrame extends JFrame {

    // game panel object
    GamePanel gp;
    public GameFrame() {
        gp = new GamePanel();

        gp.startGameThread();

        this.setTitle("rpg - multiplayer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(gp);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
