package be.uantwerpen.fti.ei.Space_Invaders.Visual.TXT;

import be.uantwerpen.fti.ei.Space_Invaders.Game.*;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Bonus;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.BonusController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Meteorite;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.MeteoriteController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Layout.AGameText;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerShip;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Bonus.Bonus2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Enemy.Enemies2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Enemy.EnemyBlast2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GameText2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout.GraphicsContext;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Meteorite.Meteorite2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Player.PlayerBlast2D;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Player.PlayerShip2D;

/**
 * Fact2D is een concrete implementatie van het AFact-interface in het Java2D-visualisatiegedeelte van Space Invaders.
 * Het bevat methoden om specifieke Java2D-implementaties van game-entiteiten en componenten te maken.
 *
 * @author Thomas Van Ostade
 */
public class TxTFact extends AFact {

    /**
     * De GraphicsContext voor de Java2D-implementatie.
     */

    /**
     * Initialiseert de input voor de game.
     * @return Een Input2D-object dat de input afhandelt.
     */
    public Input initialiseInput() {
        System.out.println("Input initialised");
        return null;}

    /**
     * Maakt een Java2D-implementatie van PlayerShip.
     * @param PlayerX De x-coördinaat van het PlayerShip.
     * @param PlayerY De y-coördinaat van het PlayerShip.
     * @param speed De snelheid van het PlayerShip.
     * @param lives Het aantal levens van het PlayerShip.
     * @return Een PlayerShip2D-object dat de Java2D-implementatie van PlayerShip vertegenwoordigt.
     */
    public PlayerShip makePlayerShip(double PlayerX, double PlayerY, double speed, int lives) {
        System.out.println("Playership initialised");
        return null;}

    /**
     * Maakt een Java2D-implementatie van Enemies.
     * @param curX De x-coördinaat van de Enemies.
     * @param curY De y-coördinaat van de Enemies.
     * @param speed De snelheid van de Enemies.
     * @param lives Het aantal levens van de Enemies.
     * @param enemyRangeY Het bereik van de Enemies in de y-richting.
     * @param numberOfEnemies Het aantal Enemies.
     * @param distance De afstand tussen de Enemies.
     * @return Een Enemies2D-object dat de Java2D-implementatie van Enemies vertegenwoordigt.
     */
    public Enemies makeEnemies(double curX, double curY, double speed, int lives, int enemyRangeY, int numberOfEnemies, int distance) {
        System.out.println("Enemies initialised");
        return null;}

    /**
     * Maakt een BonusController.
     * @param curX De x-coördinaat van de BonusController.
     * @param curY De y-coördinaat van de BonusController.
     * @param speed De snelheid van de BonusController.
     * @param lives Het aantal levens van de BonusController.
     * @return Een BonusController-object dat de BonusController vertegenwoordigt.
     */
    public BonusController makeBonusController(double curX, double curY, double speed, int lives) {
        System.out.println("BonusController initialised");
        return null;}

    /**
     * Maakt een MeteoriteController.
     * @param curX De x-coördinaat van de MeteoriteController.
     * @param curY De y-coördinaat van de MeteoriteController.
     * @param speed De snelheid van de MeteoriteController.
     * @param lives Het aantal levens van de MeteoriteController.
     * @return Een MeteoriteController-object dat de MeteoriteController vertegenwoordigt.
     */
    public MeteoriteController makeMeteoriteController(double curX, double curY, double speed, int lives) {
        System.out.println("MeteoriteController intialised");
        return null;}

    /**
     * Maakt een Java2D-implementatie van Bonus.
     * @param curX De x-coördinaat van de Bonus.
     * @param curY De y-coördinaat van de Bonus.
     * @param speed De snelheid van de Bonus.
     * @param lives Het aantal levens van de Bonus.
     * @return Een Bonus2D-object dat de Java2D-implementatie van Bonus vertegenwoordigt.
     */
    public Bonus makeBonus(double curX, double curY, double speed, int lives) {
        System.out.println("Bonus initialised");
        return null;}

    /**
     * Maakt een Java2D-implementatie van Meteorite.
     * @param curX De x-coördinaat van de Meteorite.
     * @param curY De y-coördinaat van de Meteorite.
     * @param speed De snelheid van de Meteorite.
     * @param lives Het aantal levens van de Meteorite.
     * @return Een Meteorite2D-object dat de Java2D-implementatie van Meteorite vertegenwoordigt.
     */
    public Meteorite makeMeteorite(double curX, double curY, double speed, int lives) {
        System.out.println("Meteorite initialised");
        return null;}

    /**
     * Maakt een Java2D-implementatie van PlayerBlast.
     * @param curX De x-coördinaat van de PlayerBlast.
     * @param curY De y-coördinaat van de PlayerBlast.
     * @param speed De snelheid van de PlayerBlast.
     * @param lives Het aantal levens van de PlayerBlast.
     * @return Een PlayerBlast2D-object dat de Java2D-implementatie van PlayerBlast vertegenwoordigt.
     */
    public PlayerBlast makePlayerBlast(double curX, double curY, double speed, int lives) {
        System.out.println("Playerblast");
        return null;}

    /**
     * Maakt een Java2D-implementatie van EnemyBlast.
     * @param curX De x-coördinaat van de EnemyBlast.
     * @param curY De y-coördinaat van de EnemyBlast.
     * @param speed De snelheid van de EnemyBlast.
     * @param lives Het aantal levens van de EnemyBlast.
     * @return Een EnemyBlast2D-object dat de Java2D-implementatie van EnemyBlast vertegenwoordigt.
     */
    public EnemyBlast makeEnemyBlast(double curX, double curY, double speed, int lives) {
        System.out.println("makeEnemyBlast");
        return null;}

    /**
     * Maakt een PlayerController.
     * @param curX De x-coördinaat van de PlayerController.
     * @param curY De y-coördinaat van de PlayerController.
     * @param speed De snelheid van de PlayerController.
     * @param lives Het aantal levens van de PlayerController.
     * @return Een PlayerController-object dat de PlayerController vertegenwoordigt.
     */
    public PlayerController makePlayerController(double curX, double curY, double speed, int lives) {
        System.out.println("makePlayerController");
        return null;}

    /**
     * Maakt een EnemyController.
     * @param curX De x-coördinaat van de EnemyController.
     * @param curY De y-coördinaat van de EnemyController.
     * @param speed De snelheid van de EnemyController.
     * @param lives Het aantal levens van de EnemyController.
     * @return Een EnemyController-object dat de EnemyController vertegenwoordigt.
     */
    public EnemyController makeEnemyController(double curX, double curY, double speed, int lives) {
        System.out.println("EnemyController");
        return null;}


    public void setGameDimensions(int gamecellsx, int gamecellsy) {
        System.out.println("Size: " + gamecellsx + " X " + gamecellsy);
    }

    public void render() {
        System.out.println("render");
    }
    public SoundSystem makeSoundSystem() {
        System.out.println("makeSound");
        return null;}

    public AGameText makeGameText() {
        System.out.println("make Game text");
        return null;}
}
