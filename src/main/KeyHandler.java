package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right, shit;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            up = true;
        if (e.getKeyCode() == KeyEvent.VK_S)
            down = true;
        if (e.getKeyCode() == KeyEvent.VK_D)
            right = true;
        if (e.getKeyCode() == KeyEvent.VK_A)
            left = true;
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
            shift = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            up = false;
        if (e.getKeyCode() == KeyEvent.VK_S)
            down = false;
        if (e.getKeyCode() == KeyEvent.VK_D)
            right = false;
        if (e.getKeyCode() == KeyEvent.VK_A)
            left = false;
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
            shift = false;
    }
    
}
