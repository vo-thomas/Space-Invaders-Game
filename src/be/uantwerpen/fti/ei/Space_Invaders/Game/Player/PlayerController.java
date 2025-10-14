package be.uantwerpen.fti.ei.Space_Invaders.Game.Player;
import java.util.ArrayList;

/**
 * De PlayerController klasse beheert de playerblasts en hun gedragingen.
 * Het erft van de PlayerBlast klasse.
 * @author Thomas Van Ostade
 */
public class PlayerController extends PlayerBlast {

    public static ArrayList<PlayerBlast> b = new ArrayList<PlayerBlast>();
    PlayerBlast TempBlast;
    /**
     * Constructor voor de PlayerController.
     * @param curX De huidige x-positie van de controller.
     * @param curY De huidige y-positie van de controller.
     * @param speed De snelheid van de controller.
     * @param lives Het aantal levens van de controller.
     */
    public PlayerController(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }
    /**
     * Beweegt alle spelerschoten in de controller.
     */
    public void move() {
        for(int i = 0; i < b.size(); i++) {
            TempBlast = b.get(i);
            TempBlast.move();
        }
    }
    /**
     * Geeft het aantal playerblasts in de controller.
     * @return Het aantal playerblasts.
     */
    public int getSize() {
        return b.size();
    }
    /**
     * Geeft de x-positie van een playerblast op de gegeven index.
     * @param k De index van het playerblast.
     * @return De x-positie van het playerblast.
     */
    public double getCurX(int k) {
        TempBlast = b.get(k);
        return TempBlast.getCurX();
    }
    /**
     * Geeft de y-positie van een playerblast op de gegeven index.
     * @param k De index van het playerblast.
     * @return De y-positie van het playerblast.
     */
    public double getCurY(int k) {
        TempBlast = b.get(k);
        return TempBlast.getCurY();
    }
    /**
     * Tekent alle playerblasts.
     */
    public void draw() {
        for (PlayerBlast playerBlast : b) {
            TempBlast = playerBlast;
            TempBlast.draw();
        }
    }
    /**
     * Voegt een playerblast toe aan de controller.
     * @param block Het playerblast om toe te voegen.
     */
    public void addBlast(PlayerBlast block) {
        b.add(block);
    }
    /**
     * Geeft de breedte van de playerblast.
     * @return De breedte van de playerblast
     */
    public double getWidth() {
        return TempBlast.getWidth();
    }
    /**
     * Geeft de hoogte van de playerblast
     * @return De hoogte van de playerblast
     */
    public double getHeight() {
        return TempBlast.getHeight();
    }
    /**
     * Verwijdert de playerblast op de gegeven index uit de controller.
     * @param k De index van de te verwijderen playerblast
     */
    public void remove(int k) {
        b.remove(k);
    }
    /**
     * Verwijdert alle playerblasts uit de controller.
     */
    public void removeAll() {
        for (int k = 0; k < this.getSize(); k++) {
            b.remove(k);
        }
    }
}