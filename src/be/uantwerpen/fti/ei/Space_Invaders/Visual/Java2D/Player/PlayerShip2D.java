package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Player;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerShip;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.*;

public class PlayerShip2D extends PlayerShip {

    // GraphicsContext
    private static GraphicsContext grCtx;

    /**
     * Constructor voor de PlayerShip2D-klasse.
     *
     * @param curX   De x-coördinaat van het spelerschip.
     * @param curY   De y-coördinaat van het spelerschip.
     * @param speed  De snelheid van het spelerschip.
     * @param lives  Het aantal levens van het spelerschip.
     * @param grCtx  Het GraphicsContext-object.
     */
    public PlayerShip2D(double curX, double curY, double speed, int lives, GraphicsContext grCtx) {
        super(curX, curY, speed, lives);
        this.grCtx = grCtx;
    }

    /**
     * Geeft de breedte van het spelerschip in het spel.
     *
     * @return De breedte van het spelerschip.
     */
    public double getWidth() {
        return (double) grCtx.PlayerSprite.getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van het spelerschip in het spel.
     *
     * @return De hoogte van het spelerschip.
     */
    public double getHeight() {
        return (double) grCtx.PlayerSprite.getHeight() / grCtx.getSizeY();
    }

    /**
     * Geeft de breedte van het speelveld in het spel.
     *
     * @return De breedte van het speelveld.
     */
    public int getGameScreenWidth() {
        return (int) grCtx.ScreenWidth / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van het speelveld in het spel.
     *
     * @return De hoogte van het speelveld.
     */
    public int getGameScreenHeight() {
        return (int) grCtx.ScreenHeight / grCtx.getSizeY();
    }

    /**
     * Tekent het spelerschip op het scherm.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        if (isVisible()) {
            g2d.drawImage(grCtx.PlayerSprite, (int) Math.floor(getCurX() * grCtx.getSizeX()), (int) Math.floor(getCurY() * grCtx.getSizeY()), null);
        }

        if (EnemyHit) {
            g2d.drawImage(grCtx.ExplosionSprite, (int) getCurX() * grCtx.getSizeX(), (int) getCurY() * grCtx.getSizeY(), null);
        }

        // Configuratie van de harten
        int heartX = 2;
        int heartY = 320;
        int distance = 5;

        for (int i = 0; i < getLives(); i++) {
            g2d.drawImage(grCtx.HeartSprite, heartX * grCtx.getSizeX(), heartY * grCtx.getSizeY(), null);
            heartX = heartX + distance * grCtx.getSizeX();
        }
    }
}



