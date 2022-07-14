package main;

import java.awt.*;

public class UI {
    GamePanel gp;

    public UI(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        showLive(g2);
        gameOverM(g2);
    }

    private void showLive(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,40));
        g2.drawString("LV: "+gp.player.liveLevels, 50, 60);
    }

    private void gameOverM(Graphics2D g2) {
        if(gp.gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,40));
            g2.drawString("You won", gp.screenWidth/2-40, 40);
        }
    }
}
