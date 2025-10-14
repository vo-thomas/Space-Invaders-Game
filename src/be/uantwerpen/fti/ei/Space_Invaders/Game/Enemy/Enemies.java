package be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.ColliderComponent;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerController;

import java.util.ArrayList;

/**
 * De abstracte klasse Enemies is in feite een ArrayList-klasse van enemies.
 *
 * @author Thomas Van Ostade
 */
public abstract class Enemies extends EnemyShip {

    /**
     * ArrayList van EnemyShip-objecten.
     */
    public ArrayList<EnemyShip> enemyShipArrayList = new ArrayList<EnemyShip>();

    /**
     * ColliderComponent voor het detecteren van botsingen.
     */
    ColliderComponent colliderComponent = new ColliderComponent();

    /**
     * Afstand tussen vijanden.
     */
    private int Distance;

    /**
     * Aantal vijanden.
     */
    private int NumberOfEnemies;

    /**
     * Bepaalt of de vijanden zichtbaar zijn.
     */
    public boolean isVisible = true;

    /**
     * Aantal gedode vijanden.
     */
    int kills = 0;

    /**
     * Constructor voor Enemies.
     *
     * @param curX          de huidige x-positie van de vijanden.
     * @param curY          de huidige y-positie van de vijanden.
     * @param speed         de snelheid van de vijanden.
     * @param lives         het aantal levens van de vijanden.
     * @param enemyRangeY   het bereik van de y-positie van de vijanden.
     * @param numberOfEnemies het aantal vijanden.
     * @param distance      de afstand tussen vijanden.
     */
    public Enemies(double curX, double curY, double speed, int lives, int enemyRangeY, int numberOfEnemies, int distance) {
        super(curX, curY, speed, lives, enemyRangeY); // Wordt overgeërfd van EnemyShip!
        this.NumberOfEnemies = numberOfEnemies;
        this.Distance = distance;
    }

    /**
     * Geeft de huidige x-positie van de k-de vijand.
     *
     * @param k de index van de vijand.
     * @return de huidige x-positie van de vijand.
     */
    public double getCurX(int k) {return enemyShipArrayList.get(k).getCurX();}

    /**
     * Geeft de huidige y-positie van de k-de vijand.
     *
     * @param k de index van de vijand.
     * @return de huidige y-positie van de vijand.
     */

    public double getCurY(int k) {
        return enemyShipArrayList.get(k).getCurY();
    }

    /**
     * Geeft het aantal overgebleven vijanden.
     *
     * @return het aantal overgebleven vijanden.
     */
    public int getNumberOfEnemies() {
        return this.NumberOfEnemies;
    }

    /**
     * Stelt het aantal vijanden in.
     *
     * @param numberOfEnemies het aantal vijanden.
     */
    public void setNumberOfEnemies(int numberOfEnemies) {
        this.NumberOfEnemies = numberOfEnemies;
    }

    /**
     * Stelt het aantal levens in van de k-de vijand.
     *
     * @param lives het aantal levens.
     * @param k     de index van de vijand.
     */
    public void setLives(int lives, int k) {
        enemyShipArrayList.get(k).setLives(lives);
    }

    /**
     * Geeft het aantal levens van de k-de vijand.
     *
     * @param k de index van de vijand.
     * @return het aantal levens van de vijand.
     */
    public int getLives(int k) {
        return enemyShipArrayList.get(k).getLives();
    }

    /**
     * Verplaatst alle vijanden.
     */
    public void move() {
        for (EnemyShip enemyShip : enemyShipArrayList) {
            enemyShip.move();
        }
    }

    /**
     * Bepaalt of er een blast moet worden afgevuurd.
     *
     * @return true als er een blast moet worden afgevuurd, anders false.
     */
    public boolean shouldFireBlast(double probability) {
        double randomValue = Math.random(); // Genereer een random waarde tussen 0 en 1

        if (randomValue < probability) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Abstracte methode voor het tekenen van de vijanden.
     */
    public abstract void draw();

    /**
     * Abstracte methode voor het tekenen van een explosie op positie (x, y).
     *
     * @param x de x-positie van de explosie.
     * @param y de y-positie van de explosie.
     */
    public abstract void drawExplosion(double x, double y);

    /**
     * Geeft de breedte van de k-de vijand.
     *
     * @param k de index van de vijand.
     * @return de breedte van de vijand.
     */
    public abstract double getWidth(int k);

    /**
     * Geeft de hoogte van de k-de vijand.
     *
     * @param k de index van de vijand.
     * @return de hoogte van de vijand.
     */
    public abstract double getHeight(int k);

    /**
     * Verwijdert de k-de vijand.
     *
     * @param k de index van de vijand die moet worden verwijderd.
     */
    public void remove(int k) {
        enemyShipArrayList.remove(k);
    }

    /**
     * Geeft het aantal vijanden in de ArrayList.
     *
     * @return het aantal vijanden in de ArrayList.
     */
    public int getSize() {
        return enemyShipArrayList.size();
    }

    /**
     * Verwijdert alle vijanden uit de ArrayList.
     */
    public void removeAll() {
        for (int k = 0; k < this.getSize(); k++)
            enemyShipArrayList.remove(k);
    }

    /**
     * Berekent het aantal gedode vijanden.
     *
     * @return het aantal gedode vijanden.
     */
    public int numberofkills() {
        return kills;
    }

    /**
     * Voert de botsingsdetectie uit tussen de vijanden en de spelerblasts.
     *
     * @param playerController de PlayerController die de spelerblasts vertegenwoordigt.
     * @param soundSystem      het SoundSystem voor het afspelen van geluiden.
     */
    public void CollisionDetection(PlayerController playerController, SoundSystem soundSystem) {
        for (int k = 0; k < getNumberOfEnemies(); k++) {
            for (int i = 0; i < playerController.getSize(); i++)
                if (colliderComponent.hit(this.getCurX(k) + 10, this.getCurY(k), this.getWidth(k)/1.2, this.getHeight(k),
                        playerController.getCurX(i), playerController.getCurY(i), playerController.getWidth(), playerController.getHeight())) {

                    if (getLives(k) == 1) {
                        // Als het aantal vijanden > 0, mogen we elementen uit de ArrayList verwijderen
                        if (getNumberOfEnemies() > 0) {
                            this.remove(k);
                        }
                        // De laatste vijand wordt niet verwijderd, maar "verdwijnt" (anders fouten)
                        else {
                            isVisible = false;
                        }
                        this.setNumberOfEnemies(getNumberOfEnemies() - 1);
                        kills++;
                    } else {
                        setLives(getLives(k) - 1, k);
                    }

                    // Geluid afspelen
                    soundSystem.playSE(1);

                    // Verwijder de blast uit de ArrayList
                    playerController.remove(i);
                }
        }
    }
}