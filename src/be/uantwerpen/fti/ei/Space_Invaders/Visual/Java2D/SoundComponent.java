package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * De SoundComponent klasse is verantwoordelijk voor het afspelen van geluiden in de Java2D-visualisatie van Space Invaders.
 * Het laadt geluidsbestanden en biedt methoden om geluiden af te spelen te herhalen en te stoppen.
 * (deze methods worden gebruikt door het abstracte SoundSystem)
 *
 * @author Thomas Van Ostade
 */
public class SoundComponent extends be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem {

    private Clip clip;
    private URL[] soundURL = new URL[30];

    // region SoundComponent

    /**
     * Maakt een nieuw SoundComponent object aan.
     * Het laadt de geluidsbestanden en initialiseert de URL-array.
     */
    public SoundComponent(){
        soundURL[0] = getClass().getResource("/resource/Sound/Shot.wav");
        soundURL[1] = getClass().getResource("/resource/Sound/Explosion.wav");
        soundURL[2] = getClass().getResource("/resource/Sound/Backgroundmusic.wav");
        soundURL[3] = getClass().getResource("/resource/Sound/blaster.wav");
        soundURL[4] = getClass().getResource("/resource/Sound/GameOver.wav");
        soundURL[5] = getClass().getResource("/resource/Sound/YouWin.wav");
        soundURL[6] = getClass().getResource("/resource/Sound/Bonus.wav");
        soundURL[7] = getClass().getResource("/resource/Sound/whoosh.wav");
        soundURL[8] = getClass().getResource("/resource/Sound/ambience.wav");
    }
    // endregion

    // region SoundController

    /**
     * Stelt het audiobestand in dat moet worden afgespeeld.
     * @param i De index van het audiobestand in de URL-array.
     */
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e){
        }
    }

    /**
     * Speelt het geluid af.
     */
    public void play(){
        clip.start();
    }

    /**
     * Herhaalt het geluid continu.
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stopt het afspelen van het geluid.
     */
    public void stop(){
        clip.stop();
    }

    /**
     * Speelt de achtergrondmuziek af.
     * @param i De index van het achtergrondmuziekbestand in de URL-array.
     */
    public void playMusic(int i){
        setFile(i);
        play();
        loop();
    }

    /**
     * Speelt een specifiek geluidseffect af.
     * @param i De index van het geluidseffectbestand in de URL-array.
     */
    public void playSE (int i){
        setFile(i);
        play();
    }

    // endregion SoundController
}