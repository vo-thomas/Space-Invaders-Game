package be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.AFact;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.RandomGeneratorComponent;

import java.util.ArrayList;

/**
 * De EnemyController klasse beheert de vijandelijke blasts en hun beweging.
 * Deze klasse erft van de EnemyBlast klasse.
 *
 * @author Thomas Van Ostade
 */
public class EnemyController extends EnemyBlast {

    /**
     * ArrayList van EnemyBlast objecten.
     */
    public static ArrayList<EnemyBlast> b = new ArrayList<>();

    /**
     * Tijdelijke variabele om een EnemyBlast object bij te houden.
     */
    public EnemyBlast TempBlast;

    /**
     * RandomGeneratorComponent object voor het genereren van willekeurige waarden.
     */
    RandomGeneratorComponent randomGenerator = new RandomGeneratorComponent();

    /**
     * Constructor voor EnemyController.
     *
     * @param curX  de huidige x-positie van de EnemyController.
     * @param curY  de huidige y-positie van de EnemyController.
     * @param speed de snelheid van de EnemyController.
     * @param lives het aantal levens van de EnemyController.
     */
    public EnemyController(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

    /**
     * Beweegt de vijandelijke blasts en gaat naar de volgende blast in de rij.
     */
    public void move() {
        for (int i = 0; i < b.size(); i++) {
            TempBlast = b.get(i);
            TempBlast.move();
        }
    }

    /**
     * Tekent de vijandelijke blasts.
     */
    public void draw() {
        for (int i = 0; i < b.size(); i++) {
            TempBlast = b.get(i);
            TempBlast.draw();
        }
    }

    /**
     * Voegt een EnemyBlast toe aan de lijst.
     *
     * @param block de EnemyBlast om toe te voegen.
     */
    public void addBlast(EnemyBlast block) {
        b.add(block);
    }

    /**
     * Geeft de breedte van de huidige EnemyBlast.
     *
     * @return de breedte van de EnemyBlast.
     */
    public double getWidth() {
        return TempBlast.getWidth();
    }

    /**
     * Geeft de hoogte van de huidige EnemyBlast.
     *
     * @return de hoogte van de EnemyBlast.
     */
    public double getHeight() {
        return TempBlast.getHeight();
    }

    /**
     * Geeft het aantal EnemyBlast objecten in de lijst.
     *
     * @return het aantal EnemyBlast objecten.
     */
    public int getSize() {
        return b.size();
    }

    /**
     * Geeft de huidige x-positie van de k-de EnemyBlast.
     *
     * @param k de index van de EnemyBlast.
     * @return de huidige x-positie van de EnemyBlast.
     */
    public double getCurX(int k) {
        TempBlast = b.get(k);
        return TempBlast.getCurX();
    }

    /**
     * Geeft de huidige y-positie van de k-de EnemyBlast.
     *
     * @param k de index van de EnemyBlast.
     * @return de huidige y-positie van de EnemyBlast.
     */
    public double getCurY(int k) {
        TempBlast = b.get(k);
        return TempBlast.getCurY();
    }
    /**
     * Spawnt een willekeurige EnemyBlast op basis van de opgegeven Enemies en AFact.
     *
     * @param enemies          de Enemies object voor het bepalen van de spawnpositie.
     * @param abstractfactory de AFact object voor het maken van de EnemyBlast.
     * @return de gespawnde EnemyBlast.
     */
    public EnemyBlast spawnRandomEnemyBlast(Enemies enemies, AFact abstractfactory) {
        int k = randomGenerator.randomEnemy(enemies, enemies.getNumberOfEnemies());

        double X = enemies.getCurX(k) + enemies.getWidth(k) / 2;
        double Y = enemies.getCurY(k) + enemies.getHeight(k);

        return abstractfactory.makeEnemyBlast(X, Y, getSpeed(), getLives());
    }

    /**
     * Verwijdert de EnemyBlast op de k-de positie uit de lijst.
     *
     * @param k de index van de EnemyBlast om te verwijderen.
     */
    public void remove(int k) {
        b.remove(k);
    }

    /**
     * Verwijdert alle EnemyBlast objecten uit de lijst.
     */
    public void removeAll() {
        for (int k = 0; k < this.getSize(); k++)
            b.remove(k);
    }
}

