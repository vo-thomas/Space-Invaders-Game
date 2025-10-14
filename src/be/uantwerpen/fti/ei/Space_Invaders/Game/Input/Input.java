package be.uantwerpen.fti.ei.Space_Invaders.Game.Input;

/**
 * Het abstracte Input-klasse vertegenwoordigt de invoer van het spel.
 *
 *@author Thomas Van Ostade
 */
public abstract class Input {

    /**
     * Enumeratie voor de verschillende invoermogelijkheden.
     */
    public enum Inputs {LEFT, RIGHT, SPACE,UP,DOWN,P,ENTER,C,A};  // Een enum is een speciale "klasse" die een groep constanten vertegenwoordigt

    /**
     * Controleert of er invoer beschikbaar is.
     *
     * @return true als er invoer beschikbaar is, anders false.
     */
    public abstract boolean inputAvailable();

    /**
     * Haalt de invoer op.
     *
     * @return de invoer als een van de mogelijke waarden uit de Inputs enum.
     */
    public abstract Inputs getInput();
}