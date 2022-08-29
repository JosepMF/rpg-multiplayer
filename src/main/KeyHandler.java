package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    // keys
    /**
     * w => up
     * a => left
     * s => down
     * d => right
     */
    public boolean w, a, s, d; // control keys

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_W == e.getKeyCode())
            w = true;
        if (KeyEvent.VK_A == e.getKeyCode())
            a = true;
        if (KeyEvent.VK_D == e.getKeyCode())
            d = true;
        if (KeyEvent.VK_S == e.getKeyCode())
            s = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (KeyEvent.VK_W == e.getKeyCode())
            w = false;
        if (KeyEvent.VK_A == e.getKeyCode())
            a = false;
        if (KeyEvent.VK_D == e.getKeyCode())
            d = false;
        if (KeyEvent.VK_S == e.getKeyCode())
            s = false;
    }
}
