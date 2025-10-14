package be.uantwerpen.fti.ei.Space_Invaders.Game.Layout;
/**
 * De abstracte klasse AGameText vertegenwoordigt de weergave van teksten in het spel.
 * Elke methode definieert een specifiek tekstscherm.
 * @author Thomas Van Ostade
 */
public abstract class AGameText {

        /**
         * Toont het startscherm van het spel.
         */
        public abstract void StartScreen();
        /**
         * Toont het spelscherm tijdens het spel.
         * @param i Het huidige level
         * @param numberOfKills Het aantal vernietigde vijanden
         * @param outOfBlasts Geeft aan of er geen blasts meer beschikbaar zijn
         * @param RemainingBlasts Het aantal overgebleven blasts
         */
        public abstract void GamePlay(int i, int numberOfKills, boolean outOfBlasts, int RemainingBlasts);
        /**
         *Toont het Game Over-scherm.
         */
        public abstract void GameOver();
        /**
         * Toont het "You Win!"-scherm.
         */
        public abstract void YouWin();
        /**
         * Toont het volgende level-scherm.
         * @param i Het volgende levelnummer
         */
        public abstract void nextLevel(int i);
}