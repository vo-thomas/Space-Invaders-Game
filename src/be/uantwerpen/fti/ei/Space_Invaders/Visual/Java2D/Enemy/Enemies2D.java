package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.*;

/**
 * Het Enemies2D-klasse vertegenwoordigt de visuele weergave van de vijanden in het Space Invaders-spel.
 * Het erft van de Enemies-klasse.
 *
 * @author Thomas Van Ostade
 */
public class Enemies2D extends Enemies {

    private final GraphicsContext grCtx; // Grafische context

    /**
     * Constructor voor de Enemies2D-klasse.
     *
     * @param curX          De huidige x-positie van de vijanden.
     * @param curY          De huidige y-positie van de vijanden.
     * @param speed         De snelheid van de vijanden.
     * @param lives         Het aantal levens van de vijanden.
     * @param enemyRangeY   Het bereik van de vijanden op de y-as.
     * @param numberOfEnemies Het aantal vijanden.
     * @param distance      De afstand tussen de vijanden.
     * @param grCtx         De grafische context voor het tekenen van de vijanden.
     */
    public Enemies2D(double curX, double curY, double speed, int lives, int enemyRangeY, int numberOfEnemies, int distance, GraphicsContext grCtx) {
        super(curX, curY, speed, lives, enemyRangeY, numberOfEnemies, distance);
        this.grCtx = grCtx;

        for (int i = 0; i < numberOfEnemies; i++) {
            enemyShipArrayList.add(new EnemyShip2D(curX, curY, speed, lives, enemyRangeY, grCtx));
            curX += distance;
        }
    }

    /**
     * Geeft de breedte van de vijand op de gegeven index, aangepast aan de grootte van de grafische context.
     *
     * @param k De index van de vijand.
     * @return De breedte van de vijand, aangepast aan de grootte van de grafische context.
     */
    public double getWidth(int k) {
        return enemyShipArrayList.get(k).getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van de vijand op de gegeven index, aangepast aan de grootte van de grafische context.
     *
     * @param k De index van de vijand.
     * @return De hoogte van de vijand, aangepast aan de grootte van de grafische context.
     */
    public double getHeight(int k) {
        return enemyShipArrayList.get(k).getHeight() / grCtx.getSizeY();
    }

    /**
     * Geeft de breedte van het spelvenster.
     *
     * @return De breedte van het spelvenster.
     */
    public int getGameScreenWidth() {
        return 0;
    }

    /**
     * Geeft de hoogte van het spelvenster.
     *
     * @return De hoogte van het spelvenster.
     */
    public int getGameScreenHeight() {
        return 0;
    }

    /**
     * Geeft de breedte van de vijanden.
     *
     * @return De breedte van de vijanden.
     */
    public double getWidth() {
        return 0;
    }

    /**
     * Geeft de hoogte van de vijanden.
     *
     * @return De hoogte van de vijanden.
     */
    public double getHeight() {
        return 0;
    }

    /**
     * Tekent de explosie op de opgegeven positie.
     *
     * @param x De x-positie van de explosie.
     * @param y De y-positie van de explosie.
     */
    public void drawExplosion(double x, double y) {
        Graphics2D g2d = grCtx.getG2d();
        g2d.drawImage(grCtx.ExplosionSprite, (int) x, (int) y, null);
    }

    /**
     * Tekent de vijanden.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        if (isVisible) {
            for (int k = 0; k < getNumberOfEnemies(); k++) {
                enemyShipArrayList.get(k).draw();
            }
        }
    }
}
