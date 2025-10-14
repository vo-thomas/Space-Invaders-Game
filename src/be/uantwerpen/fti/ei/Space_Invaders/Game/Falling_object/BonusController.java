package be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object;

import be.uantwerpen.fti.ei.Space_Invaders.Game.AFact;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.RandomGeneratorComponent;
import java.util.ArrayList;

/**
 * De BonusController klasse beheert de bonussen in het spel.
 * Deze klasse erft van de Bonus klasse.
 *
 * @author Thomas Van Ostade
 */
public class BonusController extends Bonus {

    // ArrayList van bonussen
    public static ArrayList<Bonus> b = new ArrayList<>();
    public Bonus Bonus;
    RandomGeneratorComponent randomGenerator = new RandomGeneratorComponent();
    double x,y;

    /**
     * Constructor voor BonusController.
     *
     * @param curX   de huidige x-positie van de BonusController.
     * @param curY   de huidige y-positie van de BonusController.
     * @param speed  de snelheid van de BonusController.
     * @param lives  het aantal levens van de BonusController.
     */
    public BonusController(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

    /**
     * Geeft de huidige x-positie van een Bonus in de lijst terug.
     *
     * @param k  de index van de Bonus in de lijst.
     * @return de huidige x-positie van de Bonus.
     */
    public double getCurX(int k){
        Bonus = b.get(k);
        return Bonus.getCurX();
    }

    /**
     * Geeft de huidige y-positie van een Bonus in de lijst terug.
     *
     * @param k  de index van de Bonus in de lijst.
     * @return de huidige y-positie van de Bonus.
     */
    public double getCurY(int k) {
        Bonus = b.get(k);
        return Bonus.getCurY();
    }

    /**
     * Geeft de breedte van de Bonus in de lijst terug.
     *
     * @return de breedte van de Bonus.
     */
    public double getWidth() {
        return Bonus.getWidth();
    }

    /**
     * Geeft de hoogte van de Bonus in de lijst terug.
     *
     * @return de hoogte van de Bonus.
     */
    public double getHeight() {
        return Bonus.getHeight();
    }

    /**
     * Tekent alle bonussen in de lijst.
     */
    public void draw() {
        for(int i = 0; i < b.size(); i++){
            Bonus = b.get(i);
            Bonus.draw();
        }
    }

    /**
     * Geeft het aantal bonussen in de lijst terug.
     *
     * @return het aantal bonussen in de lijst.
     */
    public int getSize(){
        return b.size();
    }

    /**
     * Maakt een willekeurige Bonus aan met behulp van een Abstract Factory en voegt deze toe aan de lijst.
     *
     * @param abstractfactory  de Abstract Factory voor het maken van de Bonus.
     * @param GameCellsX  het aantal celbreedtes van het speelveld in de x-richting.
     * @param GameCellsY  het aantal celhoogtes van het speelveld in de y-richting.
     * @return de aangemaakte Bonus.
     */
    public Bonus spawnRandom(AFact abstractfactory, double GameCellsX, double GameCellsY){
        x = randomGenerator.randomX(GameCellsX);
        y = randomGenerator.randomY(GameCellsY);

        return abstractfactory.makeBonus(x,y,1,0);
    }

    /**
     * Voegt een Bonus toe aan de lijst.
     *
     * @param block  de Bonus die toegevoegd moet worden.
     */
    public void addBonus(Bonus block) {
        b.add(block);
    }

    /**
     * Beweegt alle bonussen in de lijst.
     */
    public void move(){
        for(int i = 0; i < b.size(); i++){
            Bonus = b.get(i);
            Bonus.move();
        }
    }

    /**
     * Verwijdert een Bonus uit de lijst op basis van de index.
     *
     * @param k  de index van de Bonus die verwijderd moet worden.
     */
    public void remove(int k){
        b.remove(k);
    }

    /**
     * Verwijdert alle bonussen uit de lijst.
     */
    public void removeAll(){
        for (int k = 0;k<this.getSize();k++)
            b.remove(k);
    }
}