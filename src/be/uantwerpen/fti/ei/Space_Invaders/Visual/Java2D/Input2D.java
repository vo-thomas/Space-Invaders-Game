package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * De Input2D klasse is verantwoordelijk voor het afhandelen van invoer in de Java2D-visualisatie van Space Invaders.
 * Het luistert naar toetsaanslagen en zet deze om in Input-objecten die kunnen worden verwerkt door het spel.
 *
 * @author Thomas Van Ostade
 */
public class Input2D extends Input {

    public static LinkedList<Inputs> keyInputs;

    /**
     * Creëert een Input2D object met de opgegeven GraphicsContext.
     * @param gr De GraphicsContext van de Java2D-visualisatie.
     */
    public Input2D(GraphicsContext gr) {
        gr.getFrame().addKeyListener(new KeyInputAdapter());
        keyInputs = new LinkedList<Inputs>(); // gedefinieerd in de abstracte klasse!
    }

    /**
     * Controleert of er invoer beschikbaar is.
     * @return true als er invoer beschikbaar is, anders false.
     */
    public boolean inputAvailable() {
        return keyInputs.size() > 0;
    }

    /**
     * Haalt de volgende invoer op.
     * @return Het volgende Input-object in de wachtrij.
     */
    public Inputs getInput() {
        return keyInputs.poll();
    }

    static class KeyInputAdapter extends KeyAdapter {

        /**
         * Wordt opgeroepen wanneer een toets wordt ingedrukt.
         * Voegt het bijbehorende Input-object toe aan de wachtrij.
         * @param e Het KeyEvent-object dat de toetsaanslag vertegenwoordigt.
         */
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT  : keyInputs.add(Inputs.LEFT);  break;
                case KeyEvent.VK_RIGHT : keyInputs.add(Inputs.RIGHT); break;
                case KeyEvent.VK_SPACE : keyInputs.add(Inputs.SPACE); break;
                case KeyEvent.VK_UP    : keyInputs.add(Inputs.UP)   ; break;
                case KeyEvent.VK_DOWN  : keyInputs.add(Inputs.DOWN);  break;
                case KeyEvent.VK_P     : keyInputs.add(Inputs.P);     break;
                case KeyEvent.VK_ENTER : keyInputs.add(Inputs.ENTER); break;
                case KeyEvent.VK_C: keyInputs.add(Inputs.C)         ; break;
                case KeyEvent.VK_A: keyInputs.add(Inputs.A)         ; break;
            }
        }
    }
}