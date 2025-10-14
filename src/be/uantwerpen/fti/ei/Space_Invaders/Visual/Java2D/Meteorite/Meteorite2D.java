package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Meteorite;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.ColliderComponent;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Meteorite;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;

import java.awt.*;

public class Meteorite2D extends Meteorite {

    private static GraphicsContext grCtx;

    private boolean isVisible = true;


    /**
     * Constructor voor de Meteorite2D-klasse.
     *
     * @param curX   De x-coördinaat van de meteoriet.
     * @param curY   De y-coördinaat van de meteoriet.
     * @param speed  De snelheid van de meteoriet.
     * @param lives  Het aantal levens van de meteoriet.
     * @param grCtx  Het GraphicsContext-object.
     */
    public Meteorite2D(double curX, double curY, double speed, int lives, GraphicsContext grCtx) {
        super(curX, curY, speed, lives);
        Meteorite2D.grCtx = grCtx;
    }

    /**
     * Geeft de breedte van de meteoriet in het spel.
     *
     * @return De breedte van de meteoriet.
     */
    public double getWidth() {
        return (double) grCtx.MeteoriteSprite.getWidth() / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van de meteoriet in het spel.
     *
     * @return De hoogte van de meteoriet.
     */
    public double getHeight() {
        return (double) grCtx.MeteoriteSprite.getHeight() / grCtx.getSizeY();
    }


    /**
     * Tekent de meteoriet op het scherm.
     */
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        if (isVisible) {
            g2d.drawImage(grCtx.MeteoriteSprite, (int) Math.floor(getCurX() * grCtx.getSizeX()), (int) Math.floor(getCurY() * grCtx.getSizeY()), null);
        }
    }


    /**
     * Controleert of er een linkercollision is gedetecteerd.
     *
     * @return True als er een linkercollision is gedetecteerd, anders False.
     */
    public boolean CollisionLeftDetected() {
        return false;
    }

    /**
     * Controleert of er een rechtercollision is gedetecteerd.
     *
     * @return True als er een rechtercollision is gedetecteerd, anders False.
     */
    public boolean CollisionRightDetected() {
        return false;
    }

    /**
     * Controleert of er een bovencollision is gedetecteerd.
     *
     * @return True als er een bovencollision is gedetecteerd, anders False.
     */
    public boolean CollisionUpDetected() {
        return false;
    }

    /**
     * Controleert of er een ondercollision is gedetecteerd.
     *
     * @return True als er een ondercollision is gedetecteerd, anders False.
     */
    public boolean CollisionDownDetected() {
        return false;
    }

    /**
     * Geeft de breedte van het speelscherm in het spel.
     *
     * @return De breedte van het speelscherm.
     */
    public int getGameScreenWidth() {
        return (int) grCtx.ScreenWidth / grCtx.getSizeX();
    }

    /**
     * Geeft de hoogte van het speelscherm in het spel.
     *
     * @return De hoogte van het speelscherm.
     */
    public int getGameScreenHeight() {
        return (int) grCtx.ScreenHeight / grCtx.getSizeY();
    }

}

