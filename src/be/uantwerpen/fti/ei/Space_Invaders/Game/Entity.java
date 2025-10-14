package be.uantwerpen.fti.ei.Space_Invaders.Game;

/**
 * De Entity klasse is een abstracte klasse die de basisfunctionaliteit van een entiteit in het spel vertegenwoordigt.
 * Het is de superklasse voor verschillende entity's zoals playership, enemy's en blasts.
 *
 *  @author Thomas Van Ostade
 */
public abstract class Entity {

    private double CurX;
    private double CurY;
    private double Speed;
    private int Lives;

    /**
     Creëert een Entity object met de opgegeven initiële x- en y-coördinaten, snelheid en aantal levens.
     @param curX De initiële x-coördinaat van de Entity.
     @param curY De initiële y-coördinaat van de Entity.
     @param speed De snelheid van de Entity.
     @param lives Het aantal levens van de Entity.
     */
    public Entity(double curX, double curY, double speed, int lives) {
        this.CurX = curX;
        this.CurY = curY;
        this.Speed = speed;
        this.Lives = lives;
    }
    /**
     * Geeft de huidige x-coördinaat van de Entity.
     * @return De huidige x-coördinaat.
     */
    public double getCurX() {
        return this.CurX;
    }
    /**
     * Stelt de huidige x-coördinaat van de Entity in.
     * @param curX De nieuwe x-coördinaat.
     */
    public void setCurX(double curX) {
        this.CurX = curX;
    }
    /**
     * Geeft de huidige y-coördinaat van de Entity.
     * @return De huidige y-coördinaat.
     */
    public double getCurY() {
        return this.CurY;
    }
    /**
     * Stelt de huidige y-coördinaat van de Entity in.
     * @param curY De nieuwe y-coördinaat.
     */
    public void setCurY(double curY) {
        this.CurY = curY;
    }
    /**
     * Geeft het aantal levens van de Entity.
     * @return Het aantal levens.
     */
    public int getLives() {
        return Lives;
    }
    /**
     * Geeft de snelheid van de Entity.
     * @return De snelheid.
     */
    public double getSpeed() {
        return Speed;
    }
    /**
     * Stelt de snelheid van de Entity in.
     * @param speed De nieuwe snelheid.
     */
    public void setSpeed(double speed) {
        Speed = speed;
    }
    /**
     * Stelt het aantal levens van de Entity in.
     * @param lives Het nieuwe aantal levens.
     */
    public void setLives(int lives) {
        this.Lives = lives;
    }
    /**
     * Controleert of de Entity zichtbaar is (d.w.z. het aantal levens groter is dan 0).
     * @return True als de Entity zichtbaar is, anders False.
     */
    public boolean isVisible() {
        return getLives() > 0;
    }
    /**
     * Geeft de breedte van de Entity.
     * @return De breedte van de Entity.
     */
    public abstract double getWidth();
    /**
     * Geeft de hoogte van de Entity.
     * @return De hoogte van de Entity.
     */
    public abstract double getHeight();
    /**
     * Verplaatst de Entity volgens zijn bewegingslogica.
     */
    public abstract void move();
    /**
     * Tekent de Entity op het scherm.
     */
    public abstract void draw();
}
