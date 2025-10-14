package be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object;

import be.uantwerpen.fti.ei.Space_Invaders.Game.AFact;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.RandomGeneratorComponent;
import java.util.ArrayList;

/**
 * De MeteoriteController klasse is verantwoordelijk voor het beheren en controleren van meteorieten in het spel.
 * Het houdt een lijst van meteorieten bij en biedt methoden voor het toevoegen, verwijderen en bewegen van meteorieten.
 * Het kan ook willekeurige meteorieten genereren met behulp van de abstract factory

 @author Thomas Van Ostade
 */
public class MeteoriteController extends Meteorite {

    private static ArrayList<Meteorite> m = new ArrayList<>();
    private Meteorite meteorite;
    private RandomGeneratorComponent randomGenerator = new RandomGeneratorComponent();
    private double x, y;

    /**
     * Constructor voor de MeteoriteController.
     * @param curX De huidige x-positie van de controller.
     * @param curY De huidige y-positie van de controller.
     * @param speed De snelheid van de controller.
     * @param lives Het aantal levens van de controller.
     */
    public MeteoriteController(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }
    /**
     * Geeft de x-positie van een meteoriet op de gegeven index.
     * @param k De index van de meteoriet.
     * @return De x-positie van de meteoriet.
     */
    public double getCurX(int k) {
        meteorite = m.get(k);
        return meteorite.getCurX();
    }
    /**
     * Geeft de y-positie van een meteoriet op de gegeven index.
     * @param k De index van de meteoriet.
     * @return De y-positie van de meteoriet.
     */
    public double getCurY(int k) {
        meteorite = m.get(k);
        return meteorite.getCurY();
    }
    /**
     * Geeft de breedte van een meteoriet op de gegeven index.
     * @return De breedte van de meteoriet.
     */
    public double getWidth() {
        return meteorite.getWidth();
    }
    /**
     * Geeft de hoogte van een meteoriet op de gegeven index.
     * @return De hoogte van de meteoriet.
     */
    public double getHeight() {
        return meteorite.getHeight();
    }
    /**
     * Tekent alle meteorieten.
     */
    public void draw() {
        for (int i = 0; i < m.size(); i++) {
            meteorite = m.get(i);
            meteorite.draw();
        }
    }
    /**
     * Geeft het aantal meteorieten in de controller.
     * @return Het aantal meteorieten.
     */
    public int getSize() {
        return m.size();
    }
    /**
     * Maakt een willekeurige meteoriet aan met behulp van de abstracte fabriek en de afmetingen van het spelgebied.
     * @param abstractFactory De abstracte fabriek voor het maken van de meteoriet.
     * @param gameCellsX De breedte van het spelgebied.
     * @param gameCellsY De hoogte van het spelgebied.
     * @return De aangemaakte meteoriet.
     */
    public Meteorite spawnRandom(AFact abstractFactory, double gameCellsX, double gameCellsY) {
        x = randomGenerator.randomX(gameCellsX);
        y = randomGenerator.randomY(gameCellsY);

        return abstractFactory.makeMeteorite(x, y, getSpeed(), 0);
    }

    /**
     * Voegt een meteoriet toe aan de controller.
     * @param block De meteoriet om toe te voegen.
     */
    public void addMeteorite(Meteorite block) {
        m.add(block);
    }
    /**
     * Beweegt alle meteorieten in de controller.
     */
    public void move() {
        for (int i = 0; i < m.size(); i++) {
            meteorite = m.get(i);
            meteorite.move();
        }
    }
    /**
     * Verwijdert de meteoriet op de gegeven index uit de controller.
     * @param k De index van de te verwijderen meteoriet.
     */
    public void remove(int k) {
        m.remove(k);
    }
    /**
     * Verwijdert alle meteorieten uit de controller.
     */
    public void removeAll() {
        m.clear();
    }
}



