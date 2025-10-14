package be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Entity;

/**
 * De Bonus klasse is een abstracte klasse die entiteiten vertegenwoordigt die bonussen zijn in het spel.
 * Deze klasse erft van de Entity klasse.
 *
 * @author Thomas Van Ostade
 */
public abstract class Bonus extends Entity {

    /**
     * Constructor voor Bonus.
     *
     * @param curX   de huidige x-positie van de Bonus.
     * @param curY   de huidige y-positie van de Bonus.
     * @param speed  de snelheid van de Bonus.
     * @param lives  het aantal levens van de Bonus.
     */
    public Bonus(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

    /**
     * Beweegt de Bonus naar beneden volgens de snelheid.
     */
    public void move() {
        setCurY(getCurY() + this.getSpeed());
    }

    /**
     * Geeft de breedte van de Bonus terug.
     *
     * @return de breedte van de Bonus.
     */
    public abstract double getWidth();

    /**
     * Geeft de hoogte van de Bonus terug.
     *
     * @return de hoogte van de Bonus.
     */
    public abstract double getHeight();

    /**
     * Tekent de Bonus.
     */
    public abstract void draw();
}
