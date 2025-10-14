package be.uantwerpen.fti.ei.Space_Invaders.Game;

import java.util.Arrays;

/**
 * Een klasse die een timer implementeert voor het Space Invaders-spel.
 * @author Thomas Van Ostade
 */
public class Timer {

    private long startTime = 0;

    /**
     * Start de timer door de huidige tijd op te slaan.
     */
    public void startTimer() {
        this.startTime = System.currentTimeMillis();
    }
    /**
     Wacht voor een bepaalde wachttijd min de verstreken tijd sinds het starttijdstip.

     @param waitTime De wachttijd in milliseconden.
     */
    public void sleepTimer(long waitTime) {
        long elapsed = System.currentTimeMillis() - startTime;

        if (elapsed > waitTime) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        } else {
            try {
                Thread.sleep(waitTime - elapsed);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }

}