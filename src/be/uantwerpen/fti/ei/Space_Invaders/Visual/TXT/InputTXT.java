package be.uantwerpen.fti.ei.Space_Invaders.Visual.TXT;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class InputTXT extends Input {

    public static LinkedList<Inputs> keyInputs;

    public boolean inputAvailable() {return keyInputs.size() > 0;}

    public Inputs getInput() {
        return keyInputs.poll();
    }
    static class KeyInputAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {

                case KeyEvent.VK_LEFT  : System.out.println("Left");  break;
                case KeyEvent.VK_RIGHT : System.out.println("Right"); break;
                case KeyEvent.VK_SPACE : System.out.println("Space"); break;
                case KeyEvent.VK_UP    : System.out.println("Up");    break;
                case KeyEvent.VK_DOWN  : System.out.println(("Down")); break;
                case KeyEvent.VK_P     : System.out.println("Pause");     break;
            }
        }
    }
}
