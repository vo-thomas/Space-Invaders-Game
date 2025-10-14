package be.uantwerpen.fti.ei.Space_Invaders.Game;

/**
 * Dit is een factory - klasse met als enige taak het maken van entity's.
 * Door het creëren van de entity's te encapsuleren, hebben we slechts één
 * plaats nodig om wijzigingen aan te brengen.
 *
 * @author Thomas Van Ostade
 */
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyController;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Bonus;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.BonusController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Meteorite;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.MeteoriteController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Layout.AGameText;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerShip;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerBlast;

public abstract class AFact {


    /**
     * Initialiseert de input voor het spel.
     *
     * @return Het geïnitialiseerde Input-object.
     */
    public abstract Input initialiseInput();

    /**
     * Maakt een nieuw PlayerShip-object aan.
     *
     * @param curX   De x-coördinaat van het schip.
     * @param curY   De y-coördinaat van het schip.
     * @param speed  De snelheid van het schip.
     * @param lives  Het aantal levens van het schip.
     * @return Het gecreëerde PlayerShip-object.
     */
    public abstract PlayerShip makePlayerShip(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw Enemies-object aan.
     *
     * @param curX          De x-coördinaat van de vijanden.
     * @param curY          De y-coördinaat van de vijanden.
     * @param speed         De snelheid van de vijanden.
     * @param lives         Het aantal levens van de vijanden.
     * @param enemyRangeY   Het bereik van de vijanden op de y-as.
     * @param numberOfEnemies Het aantal vijanden.
     * @param distance      De afstand tussen de vijanden.
     * @return Het gecreëerde Enemies-object.
     */
    public abstract Enemies makeEnemies(double curX, double curY, double speed, int lives, int enemyRangeY, int numberOfEnemies, int distance);

    /**
     * Maakt een nieuw BonusController-object aan.
     *
     * @param curX   De x-coördinaat van de bonuscontroller.
     * @param curY   De y-coördinaat van de bonuscontroller.
     * @param speed  De snelheid van de bonuscontroller.
     * @param lives  Het aantal levens van de bonuscontroller.
     * @return Het gecreëerde BonusController-object.
     */
    public abstract BonusController makeBonusController(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw MeteoriteController-object aan.
     *
     * @param curX   De x-coördinaat van de meteoritecontroller.
     * @param curY   De y-coördinaat van de meteoritecontroller.
     * @param speed  De snelheid van de meteoritecontroller.
     * @param lives  Het aantal levens van de meteoritecontroller.
     * @return Het gecreëerde MeteoriteController-object.
     */
    public abstract MeteoriteController makeMeteoriteController(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw Bonus-object aan.
     *
     * @param curX   De x-coördinaat van de bonus.
     * @param curY   De y-coördinaat van de bonus.
     * @param speed  De snelheid van de bonus.
     * @param lives  Het aantal levens van de bonus.
     * @return Het gecreëerde Bonus-object.
     */
    public abstract Bonus makeBonus(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw Meteorite-object aan.
     *
     * @param curX   De x-coördinaat van de meteoriet.
     * @param curY   De y-coördinaat van de meteoriet.
     * @param speed  De snelheid van de meteoriet.
     * @param lives  Het aantal levens van de meteoriet.
     * @return Het gecreëerde Meteorite-object.
     */
    public abstract Meteorite makeMeteorite(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw PlayerController-object aan.
     *
     * @param curX   De x-coördinaat van de playercontroller.
     * @param curY   De y-coördinaat van de playercontroller.
     * @param speed  De snelheid van de playercontroller.
     * @param lives  Het aantal levens van de playercontroller.
     * @return Het gecreëerde PlayerController-object.
     */
    public abstract PlayerController makePlayerController(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw EnemyController-object aan.
     *
     * @param curX   De x-coördinaat van de enemycontroller.
     * @param curY   De y-coördinaat van de enemycontroller.
     * @param speed  De snelheid van de enemycontroller.
     * @param lives  Het aantal levens van de enemycontroller.
     * @return Het gecreëerde EnemyController-object.
     */
    public abstract EnemyController makeEnemyController(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw PlayerBlast-object aan.
     *
     * @param curX   De x-coördinaat van de playerblasts.
     * @param curY   De y-coördinaat van de playerblasts.
     * @param speed  De snelheid van de playerblasts.
     * @param lives  Het aantal levens van de playerblasts.
     * @return Het gecreëerde PlayerBlast-object.
     */
    public abstract PlayerBlast makePlayerBlast(double curX, double curY, double speed, int lives);

    /**
     * Maakt een nieuw EnemyBlast-object aan.
     *
     * @param curX   De x-coördinaat van de vijandschoten.
     * @param curY   De y-coördinaat van de vijandschoten.
     * @param speed  De snelheid van de vijandschoten.
     * @param lives  Het aantal levens van de vijandschoten.
     * @return Het gecreëerde EnemyBlast-object.
     */
    public abstract EnemyBlast makeEnemyBlast(double curX, double curY, double speed, int lives);

    /**
     * Stelt de dimensies van het spel in.
     *
     * @param gamecellsX  Het aantal spelcellen in de x-richting.
     * @param gamecellsY  Het aantal spelcellen in de y-richting.
     */
    public abstract void setGameDimensions(int gamecellsX, int gamecellsY);

    /**
     * Maakt een nieuw SoundSystem-object aan.
     *
     * @return Het gecreëerde SoundSystem-object.
     */
    public abstract SoundSystem makeSoundSystem();

    /**
     * Maakt een nieuw AGameText-object aan.
     *
     * @return Het gecreëerde AGameText-object.
     */
    public abstract AGameText makeGameText();

    /**
     * Render het spel.
     */
    public abstract void render();
}