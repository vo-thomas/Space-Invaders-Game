package be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Entity;

/**
 * De abstracte klasse Meteorite is verantwoordelijk voor het definiëren van de eigenschappen en gedragingen van meteorieten in het Space Invaders-spel.
 * Het erft van de Entity-klasse.
 */
public abstract class Meteorite extends Entity {

    /**
     * Constructor voor de Meteorite klasse.
     *
     * @param curX   De huidige x-positie van de meteoriet.
     * @param curY   De huidige y-positie van de meteoriet.
     * @param speed  De snelheid van de meteoriet.
     * @param lives  Het aantal levens van de meteoriet.
     */
    public Meteorite(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

    /**
     * Beweegt de meteoriet naar beneden.
     */
    public void move() {
        setCurY(getCurY() + this.getSpeed());
    }

    /**
     * Geeft de breedte van de meteoriet terug.
     *
     * @return De breedte van de meteoriet.
     */
    public abstract double getWidth();

    /**
     * Geeft de hoogte van de meteoriet terug.
     *
     * @return De hoogte van de meteoriet.
     */
    public abstract double getHeight();

    /**
     * Tekent de meteoriet.
     */
    public abstract void draw();
}