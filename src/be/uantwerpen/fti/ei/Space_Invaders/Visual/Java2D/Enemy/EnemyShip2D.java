package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Enemy;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyShip;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;
import java.awt.*;

/**
 * De klasse EnemyShip2D is verantwoordelijk voor het visualiseren van een vijandig ruimteschip in een 2D-omgeving.
 * Het breidt de basisklasse EnemyShip uit en maakt gebruik van de GraphicsContext voor het tekenen van het ruimteschip.
 *
 * @author Thomas Van Ostade
 */
public class EnemyShip2D extends EnemyShip {

    // GraphicsContext
    private static GraphicsContext grCtx;

    /**
     * Creëert een nieuw 2D-vijandig ruimteschip met de opgegeven positie, snelheid, levens, bereik en GraphicsContext.
     *
     * @param curX          De x-positie van het ruimteschip.
     * @param curY          De y-positie van het ruimteschip.
     * @param speed         De snelheid van het ruimteschip.
     * @param lives         Het aantal levens van het ruimteschip.
     * @param enemyRangeY   Het verticale bereik van het ruimteschip.
     * @param grCtx         De GraphicsContext voor het tekenen van het ruimteschip.
     */
    public EnemyShip2D(double curX, double curY, double speed, int lives, int enemyRangeY, GraphicsContext grCtx) {
        super(curX, curY, speed, lives, enemyRangeY);
        EnemyShip2D.grCtx = grCtx;
    }

    /**
     * Controleert of het ruimteschip zichtbaar is.
     *
     * @return True als het ruimteschip zichtbaar is, anders False.
     */
    public boolean isVisible() {
        return false;
    }

    /**
     * Geeft de breedte van het speelscherm terug, aangepast aan de grootte van het GraphicsContext.
     *
     * @return De breedte van het speelscherm.
     */
    public int getGameScreenWidth() {
        return (int) grCtx.ScreenWidth / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van het speelscherm terug, aangepast aan de grootte van het GraphicsContext.
     *
     * @return De hoogte van het speelscherm.
     */
    public int getGameScreenHeight() {
        return (int) grCtx.ScreenHeight / grCtx.getSizeY();
    }

    /**
     * Geeft de breedte van het ruimteschip terug, aangepast aan de grootte van het GraphicsContext.
     *
     * @return De breedte van het ruimteschip.
     */
    public double getWidth() {
        return (double) grCtx.EnemySprite.getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van het ruimteschip terug, aangepast aan de grootte van het GraphicsContext.
     *
     * @return De hoogte van het ruimteschip.
     */
    public double getHeight() {
        return (double) grCtx.EnemySprite.getHeight() / grCtx.getSizeY();
    }

    /**
     * Tekent het ruimteschip op het scherm met behulp van de GraphicsContext.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        g2d.drawImage(grCtx.EnemySprite, (int) getCurX() * grCtx.getSizeX(), (int) getCurY() * grCtx.getSizeY(), null);
    }
}