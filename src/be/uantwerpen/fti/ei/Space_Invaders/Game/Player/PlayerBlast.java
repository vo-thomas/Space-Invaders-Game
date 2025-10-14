package be.uantwerpen.fti.ei.Space_Invaders.Game.Player;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Blast;

/**
 * De PlayerBlast klasse is een abstracte klasse die de eigenschappen en gedragingen van een playerblast definieert.
 * Het erft van de Blast klasse.
 * @author Thomas Van Ostade
 */
public abstract class PlayerBlast extends Blast {

    /**
     * Constructor voor de PlayerBlast.
     * @param curX De huidige x-positie van het schot.
     * @param curY De huidige y-positie van het schot.
     * @param speed De snelheid van het schot.
     * @param lives Het aantal levens van het schot.
     */
    public PlayerBlast(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }
}