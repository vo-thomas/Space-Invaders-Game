package be.uantwerpen.fti.ei.Space_Invaders.Game.Player;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.BonusController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.ColliderComponent;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Entity;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.MeteoriteController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;

/**
 * De abstracte klasse PlayerShip definieert het gedrag van het spelerschip.
 * Het erft van de Entity klasse.
 * @author Thomas Van Ostade
 */
public abstract class PlayerShip extends Entity {

    public boolean EnemyblastHit = false;
    public boolean BonusHit = false;
    public boolean EnemyHit = false;
    ColliderComponent colliderComponent = new ColliderComponent();
    private Input.Inputs direction = Input.Inputs.RIGHT;

    /**
     * Constructor voor het PlayerShip.
     * @param curX De huidige X-positie van het spelerschip.
     * @param curY De huidige Y-positie van het spelerschip.
     * @param speed De snelheid van het spelerschip.
     * @param lives Het aantal levens van het spelerschip.
     */
    public PlayerShip(double curX, double curY, double speed, int lives) {
        super(curX, curY, speed, lives);
    }

    /**
     * Controleert of er een botsing is opgetreden met de linkerzijde van het scherm.
     * @return true als er een botsing is opgetreden met de linkerzijde, anders false.
     */

    /**
     * Stelt de richting van het spelerschip in.
     * @param direction De richting van het spelerschip.
     */
    public void setDirection(Input.Inputs direction) {
        this.direction = direction;
    }

    public boolean CollisionLeftDetected() {
        return getCurX() <= 0;
    }
    /**
     * Controleert of er een botsing is opgetreden met de rechterzijde van het scherm.
     * @return true als er een botsing is opgetreden met de rechterzijde, anders false.
     */
    public boolean CollisionRightDetected() {
        return Math.floor(getCurX() + this.getWidth()) >= getGameScreenWidth();
    }
    /**
     * Controleert of er een botsing is opgetreden met de bovenzijde van het scherm.
     * @return true als er een botsing is opgetreden met de bovenzijde, anders false.
     */
    public boolean CollisionUpDetected() {
        return getCurY() <= 0;
    }
    /**
     * Controleert of er een botsing is opgetreden met de onderzijde van het scherm.
     * @return true als er een botsing is opgetreden met de onderzijde, anders false.
     */
    public boolean CollisionDownDetected() {
        return (int) Math.floor(getCurY() + this.getHeight()) >= getGameScreenHeight();
    }


    /**
     * Verplaatst het spelerschip volgens de gegeven invoer.
     * @param keyInput De invoer van de speler.
     */
    public void moveClassic(Input.Inputs keyInput) {
        switch (keyInput) {
            case LEFT:
                if (!CollisionLeftDetected()) {
                    this.setCurX(this.getCurX() - getSpeed() * 3);
                }
                break;
            case RIGHT:
                if (!CollisionRightDetected()) {
                    this.setCurX(this.getCurX() + getSpeed() * 3);
                }
                break;
            case UP:
                if (!CollisionUpDetected()) {
                    this.setCurY(this.getCurY() - getSpeed() * 3);
                }
                break;
            case DOWN:
                if (!CollisionDownDetected()) {
                    this.setCurY(this.getCurY() + getSpeed() * 3);
                }
                break;
            case P:
                break;
        }
    }
    /**
     * Verplaatst het spelerschip volgens de ingestelde richting.
     */
    public void move() {
        switch (direction) {
            case LEFT:
                if (!CollisionLeftDetected()) {
                    this.setCurX(this.getCurX() - getSpeed());
                }
                break;
            case RIGHT:
                if (!CollisionRightDetected()) {
                    this.setCurX(this.getCurX() + getSpeed());
                }
                break;
            case UP:
                if (!CollisionUpDetected()) {
                    this.setCurY(this.getCurY() - getSpeed());
                }
                break;
            case DOWN:
                if (!CollisionDownDetected()) {
                    this.setCurY(this.getCurY() + getSpeed());
                }
                break;
            case P:
                break;
        }
    }

    /**
     * Abstracte methode voor het verkrijgen van de breedte van het speelscherm.
     * @return De breedte van het speelscherm.
     */
    public abstract int getGameScreenWidth();
    /**
     * Abstracte methode voor het verkrijgen van de hoogte van het speelscherm.
     * @return De hoogte van het speelscherm.
     */
    public abstract int getGameScreenHeight();



    /**
     * Controleert op botsingen tussen het spelerschip en andere entiteiten zoals vijanden, bonusitems en meteorieten.
     * @param enemyController De controller van de vijanden.
     * @param enemies De vijanden.
     * @param bonusController De controller van de bonusitems.
     * @param meteoriteController De controller van de meteorieten.
     * @param MaxBlastCounter De maximale waarde van de blastcounter.
     * @param soundSystem Het geluidssysteem.
     */
    public void CollisionDetection(EnemyController enemyController, Enemies enemies, BonusController bonusController, MeteoriteController meteoriteController,
                                   int MaxBlastCounter, SoundSystem soundSystem) {

// region met enemyblast
        for (int i = 0; i < enemyController.getSize(); i++) {
            if (colliderComponent.hit(getCurX(), getCurY(), getWidth(), getHeight(), enemyController.getCurX(i),
                    enemyController.getCurY(i), enemyController.getWidth(), enemyController.getHeight())) {

                soundSystem.playSE(1);
                enemyController.remove(i);
                setLives(getLives() - 1);
                EnemyblastHit = true;

            }
        }
// endregion

// region met enemies
        for (int j = 0; j < enemies.getNumberOfEnemies(); j++) {
            if (colliderComponent.hit(getCurX(), getCurY(), getWidth(), getHeight(), enemies.getCurX(j),
                    enemies.getCurY(j), enemies.getWidth(), enemies.getHeight())) {

                soundSystem.playSE(1);
                setLives(0);
                EnemyHit = true;
            }
        }
// endregion

// region met bonus
        for(int k = 0; k < bonusController.getSize(); k++) {
            if (colliderComponent.hit(getCurX(), getCurY(), getWidth(), getHeight(), bonusController.getCurX(k),
                    bonusController.getCurY(k),bonusController.getWidth(), bonusController.getHeight())) {

                // deze zal ofwel een 0 of 1 geven (want afgeronde integer ...)
                setLives(getLives() + 1);
                MaxBlastCounter += 5;
                soundSystem.playSE(6);
                bonusController.remove(k);
                BonusHit = true;
            }
        }
// endregion

// region met meteoriet
        for(int l = 0; l < meteoriteController.getSize(); l++) {
            if (colliderComponent.hit(getCurX(), getCurY(), getWidth(), getHeight(), meteoriteController.getCurX(l),
                    meteoriteController.getCurY(l),meteoriteController.getWidth(), meteoriteController.getHeight())) {

                soundSystem.playSE(1);
                meteoriteController.remove(l);
                setLives(0);
            }
        }
// endregion
    }

}

