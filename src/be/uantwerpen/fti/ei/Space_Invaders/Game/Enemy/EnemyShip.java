package be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Entity;

/**
 * De EnemyShip klasse is een abstracte klasse die entiteiten vertegenwoordigt die vijanden zijn in het spel.
 * Deze klasse erft van de Entity klasse.
 *
 * @author Thomas Van Ostade
 */
public abstract class EnemyShip extends Entity {

        /**
         * Het bereik van de vijanden in de Y-richting.
         */
        private int EnemyRangeY;

        /**
         * De vorige Y-positie van het level.
         */
        double pastLevelY;

        /**
         * De teller voor het horizontaal bewegen van de vijanden.
         */
        int cntr = 0; // de enemies gaan eerst naar rechts

        /**
         * Boolean waarde die aangeeft of de vijanden naar beneden bewegen.
         */
        private boolean MoveDown = false;

        /**
         * Boolean waarde die aangeeft of de vijanden horizontaal bewegen.
         */
        private boolean MoveHorizontal = true;

        /**
         * Constructor voor EnemyShip.
         *
         * @param curX         de huidige x-positie van het EnemyShip.
         * @param curY         de huidige y-positie van het EnemyShip.
         * @param speed        de snelheid van het EnemyShip.
         * @param lives        het aantal levens van het EnemyShip.
         * @param enemyRangeY  het bereik van de vijanden in de Y-richting.
         */
        public EnemyShip(double curX, double curY, double speed, int lives, int enemyRangeY) {
                super(curX, curY, speed, lives);
                this.EnemyRangeY = enemyRangeY;
        }

        /**
         * Beweegt het EnemyShip volgens de vijandige bewegingspatronen.
         */
        public void move() {
                if (MoveHorizontal) {
                        this.setCurX(this.getCurX() + (Math.pow(-1, cntr) * this.getSpeed()));

                        if (CollisionLeftDetected() | CollisionRightDetected()) {
                                MoveHorizontal = false;
                                MoveDown = true;
                                pastLevelY = getCurY();
                        }
                }
                if (MoveDown) {
                        this.setCurY(this.getCurY() + this.getSpeed());
                        if (getCurY() == Math.round(pastLevelY + this.getEnemyRangeY())) {
                                MoveHorizontal = true;
                                MoveDown = false;
                                cntr++;
                        }
                }
        }

        /**
         * Controleert of er een botsing is opgetreden aan de linkerkant van het speelscherm.
         *
         * @return true als er een botsing is opgetreden aan de linkerkant, anders false.
         */
        public boolean CollisionLeftDetected() {
                return getCurX() == 0;
        }

        /**
         * Controleert of er een botsing is opgetreden aan de rechterkant van het speelscherm.
         *
         * @return true als er een botsing is opgetreden aan de rechterkant, anders false.
         */
        public boolean CollisionRightDetected() {
                return (int) Math.floor(getCurX() + 1.3 * this.getWidth()) == getGameScreenWidth();
        }

        /**
         * Controleert of er een botsing is opgetreden aan de bovenkant van het speelscherm.
         *
         * @return true als er een botsing is opgetreden aan de bovenkant, anders false.
         */
        public boolean CollisionUpDetected() {
                return this.getCurY() - getHeight() == 0;
        }

        /**
         * Controleert of er een botsing is opgetreden aan de onderkant van het speelscherm.
         *
         * @return true als er een botsing is opgetreden aan de onderkant, anders false.
         */
        public boolean CollisionDownDetected() {
                return (int) Math.floor(getCurY() + this.getHeight()) == getGameScreenHeight();
        }

        /**
         * Geeft de breedte van het speelscherm terug.
         *
         * @return de breedte van het speelscherm.
         */
        public abstract int getGameScreenWidth();

        /**
         * Geeft de hoogte van het speelscherm terug.
         *
         * @return de hoogte van het speelscherm.
         */
        public abstract int getGameScreenHeight();

        /**
         * Geeft het bereik van de vijanden in de Y-richting terug.
         *
         * @return het bereik van de vijanden in de Y-richting.
         */
        public int getEnemyRangeY() {
                return this.EnemyRangeY;
        }

        /**
         * Stelt het bereik van de vijanden in de Y-richting in.
         *
         * @param enemyRangeY het bereik van de vijanden in de Y-richting.
         */
        public void setEnemyRangeY(int enemyRangeY) {
                this.EnemyRangeY = enemyRangeY;
        }

        /**
         * Tekent het EnemyShip.
         */
        public abstract void draw();
}




