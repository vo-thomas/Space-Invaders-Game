package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * De EnemyBlast2D-klasse vertegenwoordigt de visuele weergave van de vijandelijke blast in het Space Invaders-spel.
 * Het erft van de EnemyBlast-klasse.
 *
 * @author Thomas Van Ostade
 */
public class EnemyBlast2D extends EnemyBlast {

    // GraphicsContext
    private GraphicsContext grCtx; // Grafische context
    BufferedImage image;

    /**
     * Constructor voor de EnemyBlast2D-klasse.
     *
     * @param curX   De huidige x-positie van de blast.
     * @param curY   De huidige y-positie van de blast.
     * @param speed  De snelheid van de blast.
     * @param lives  Het aantal levens van de blast.
     * @param grCtx  De grafische context voor het tekenen van de blast.
     */
    public EnemyBlast2D(double curX, double curY, double speed, int lives, GraphicsContext grCtx) {
        super(curX, curY, speed, lives);
        this.grCtx = grCtx;
    }

    /**
     * Tekent de blast.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        g2d.drawImage(grCtx.EnemyBlastSprite, (int) getCurX() * grCtx.getSizeX(), (int) getCurY() * grCtx.getSizeY(), null);
    }

    /**
     * Geeft de breedte van de blast, aangepast aan de grootte van de grafische context.
     *
     * @return De breedte van de blast, aangepast aan de grootte van de grafische context.
     */
    public double getWidth() {
        return grCtx.BlastSprite.getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van de blast, aangepast aan de grootte van de grafische context.
     *
     * @return De hoogte van de blast, aangepast aan de grootte van de grafische context.
     */
    public double getHeight() {
        return grCtx.BlastSprite.getHeight() / grCtx.getSizeY();
    }

}