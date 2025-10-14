package be.uantwerpen.fti.ei.Space_Invaders.Visual.TXT;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyShip;

public abstract class TxTEnemyShip extends EnemyShip {


        public TxTEnemyShip(double curX, double curY, int lives, int speed, int enemyRangeY) {
                super(curX, curY, lives, speed, enemyRangeY);
        }

        @Override
        public abstract String toString();
}

