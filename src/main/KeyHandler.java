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

    // inventory
    public boolean e;

    // action
    public boolean enter;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // control
        if (KeyEvent.VK_W == e.getKeyCode())
            w = true;
        if (KeyEvent.VK_A == e.getKeyCode())
            a = true;
        if (KeyEvent.VK_D == e.getKeyCode())
            d = true;
        if (KeyEvent.VK_S == e.getKeyCode())
            s = true;
        // inventory
        if(KeyEvent.VK_E == e.getKeyCode())
            this.e = !this.e;
        // action
        if(KeyEvent.VK_ENTER == e.getKeyCode())
            enter = true;
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
        // action
        if(KeyEvent.VK_ENTER == e.getKeyCode())
            enter = false;
    }
}
