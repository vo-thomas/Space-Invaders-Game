package be.uantwerpen.fti.ei.Space_Invaders.Game.Components;

/**
 * De abstracte SoundSystem klasse definieert methoden voor het instellen en afspelen van geluiden.
 *
 * @author Thomas Van Ostade
 */
public abstract class SoundSystem {

    /**
     * Stelt het bestand in dat moet worden afgespeeld op basis van de opgegeven index.
     *
     * @param i de index van het geluidsbestand.
     */
    public abstract void setFile(int i);

    /**
     * Speelt het geluid af.
     */
    public abstract void play();

    /**
     * Speelt het geluid in een loop af.
     */
    public abstract void loop();

    /**
     * Stopt het afspelen van het geluid.
     */
    public abstract void stop();

    /**
     * Speelt de muziek af op basis van de opgegeven index.
     *
     * @param i de index van de muziek.
     */
    public abstract void playMusic(int i);

    /**
     * Speelt het geluidseffect af op basis van de opgegeven index.
     *
     * @param i de index van het geluidseffect.
     */
    public abstract void playSE(int i);
}