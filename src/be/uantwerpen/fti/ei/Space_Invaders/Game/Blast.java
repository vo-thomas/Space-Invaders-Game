
package be.uantwerpen.fti.ei.Space_Invaders.Game;

/**
 * De Blast klasse is een abstracte klasse die de basisfunctionaliteit van een kogel in het spel vertegenwoordigt.
 * Het is een subklasse van de Entity klasse.
 *
 * @author Thomas Van Ostade
 */
public abstract class Blast extends Entity {

    /**
     Creëert een Blast object met de opgegeven initiële x- en y-coördinaten, snelheid en aantal levens.
     @param curX De initiële x-coördinaat van de Blast.
     @param curY De initiële y-coördinaat van de Blast.
     @param speed De snelheid van de Blast.
     @param lives Het aantal levens van de Blast.
     */
    public Blast(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }
    /**
     * Verplaatst de Blast door de y-coördinaat te verhogen volgens de opgegeven snelheid.
     */
    public void move() {
        setCurY(getCurY() + getSpeed());
    }
}