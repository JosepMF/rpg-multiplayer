package main;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GamePanel gp;

    public GameFrame() {
        gp = new GamePanel(); 

        gp.startGame();

        this.setTitle("rpg - multiplayer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(gp);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
