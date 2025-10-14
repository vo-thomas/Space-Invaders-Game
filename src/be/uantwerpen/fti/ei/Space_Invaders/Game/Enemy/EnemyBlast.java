package be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Blast;

/**
 * Abstracte klasse voor de vijandige blasts.
 * Deze klasse erft van de Blast-klasse.
 *
 * @author Thomas Van Ostade
 */
public abstract class EnemyBlast extends Blast {

    /**
     * Constructor voor EnemyBlast.
     *
     * @param curX  de huidige x-positie van de blast.
     * @param curY  de huidige y-positie van de blast.
     * @param speed de snelheid van de blast.
     * @param lives het aantal levens van de blast.
     */
    public EnemyBlast(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

}