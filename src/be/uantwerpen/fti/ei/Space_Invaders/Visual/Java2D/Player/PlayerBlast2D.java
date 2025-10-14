package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Player;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.*;

public class PlayerBlast2D extends PlayerBlast {

    // GraphicsContext
    private GraphicsContext grCtx;

    /**
     * Constructor voor de PlayerBlast2D-klasse.
     *
     * @param curX   De x-coördinaat van de speler-blast.
     * @param curY   De y-coördinaat van de speler-blast.
     * @param speed  De snelheid van de speler-blast.
     * @param lives  Het aantal levens van de speler-blast.
     * @param grCtx  Het GraphicsContext-object.
     */
    public PlayerBlast2D(double curX, double curY, double speed, int lives, GraphicsContext grCtx) {
        super(curX, curY, speed, lives);
        this.grCtx = grCtx;
    }

    /**
     * Tekent de speler-blast op het scherm.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        g2d.drawImage(grCtx.BlastSprite, (int) getCurX() * grCtx.getSizeX(), (int) getCurY() * grCtx.getSizeY(), null);
    }

    /**
     * Geeft de breedte van de speler-blast in het spel.
     *
     * @return De breedte van de speler-blast.
     */
    public double getWidth() {
        return grCtx.BlastSprite.getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van de speler-blast in het spel.
     *
     * @return De hoogte van de speler-blast.
     */
    public double getHeight() {
        return grCtx.BlastSprite.getHeight() / grCtx.getSizeY();
    }
}

