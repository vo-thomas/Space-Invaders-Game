package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Bonus;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Bonus;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.ColliderComponent;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;
import java.awt.*;

/**
 * Een klasse die de visuele representatie van een bonusobject in het Space Invaders-spel implementeert.
 *
 * @author Thomas Van Ostade
 */
public class Bonus2D extends Bonus {

    private static GraphicsContext grCtx;
    private ColliderComponent colliderComponent = new ColliderComponent();
    private boolean isVisible = true;

    /**
     * Maakt een nieuw Bonus2D-object met de opgegeven parameters.
     * @param curX De x-positie van de bonus.
     * @param curY De y-positie van de bonus.
     * @param speed De snelheid van de bonus.
     * @param lives Het aantal levens van de bonus.
     * @param grCtx De grafische context voor het tekenen van de bonus.
     */
    public Bonus2D(double curX, double curY, double speed, int lives, GraphicsContext grCtx) {
        super(curX, curY, speed, lives);
        Bonus2D.grCtx = grCtx;
    }
    /**
     * Geeft de breedte van de bonus in verhouding tot de grafische context.
     * @return De breedte van de bonus.
     */
    public double getWidth() {
        return (double) grCtx.BonusSprite.getWidth() / grCtx.getSizeX();
    }
    /**
     * Geeft de hoogte van de bonus in verhouding tot de grafische context.
     * @return De hoogte van de bonus.
     */
    public double getHeight() {
        return (double) grCtx.BonusSprite.getHeight() / grCtx.getSizeY();
    }
    /**
     * Tekent de bonus op het scherm als deze zichtbaar is.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        if (isVisible) {
            g2d.drawImage(grCtx.BonusSprite, (int) Math.floor(getCurX() * grCtx.getSizeX()), (int) Math.floor(getCurY() * grCtx.getSizeY()), null);
        }
    }
    /**
     * Controleert of er een botsing is gedetecteerd aan de linkerkant van het scherm.
     * @return true als er een botsing aan de linkerkant is gedetecteerd, anders false.
     */
    public boolean CollisionLeftDetected() {
        return false;
    }
    /**
     * Controleert of er een botsing is gedetecteerd aan de rechterkant van het scherm.
     * @return true als er een botsing aan de rechterkant is gedetecteerd, anders false.
     */
    public boolean CollisionRightDetected() {
        return false;
    }
    /**
     * Controleert of er een botsing is gedetecteerd aan de bovenkant van het scherm.
     * @return true als er een botsing aan de bovenkant is gedetecteerd, anders false.
     */
    public boolean CollisionUpDetected() {
        return false;
    }
    /**
     * Controleert of er een botsing is gedetecteerd aan de onderkant van het scherm.
     * @return true als er een botsing aan de onderkant is gedetecteerd, anders false.
     */
    public boolean CollisionDownDetected() {
        return false;
    }
}