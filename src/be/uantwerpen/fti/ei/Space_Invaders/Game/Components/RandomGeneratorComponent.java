package be.uantwerpen.fti.ei.Space_Invaders.Game.Components;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;

/**
 * De RandomGeneratorComponent klasse genereert willekeurige waarden voor het creëren van blasts en bonuspunten.
 *
 * @author Thomas Van Ostade
 */
public class RandomGeneratorComponent {

    /**
     * Genereert een willekeurige index voor het selecteren van een enemy uit de lijst van enemies.
     *
     * @param enemies         de lijst van enemies.
     * @param numberOfEnemies het aantal enemies in de lijst.
     * @return een willekeurige index voor het selecteren van een enemy.
     */
    public int randomEnemy(Enemies enemies, int numberOfEnemies) {
        int min = 0;
        int range = numberOfEnemies;
        return (int) (Math.random() * range) + min;
    }

    /**
     * Genereert een willekeurige X-coördinaat binnen de opgegeven grenzen.
     *
     * @param X de maximale waarde voor de X-coördinaat.
     * @return een willekeurige X-coördinaat.
     */
    public double randomX(double X) {
        return Math.floor(Math.random() * X);
    }

    /**
     * Genereert een willekeurige Y-coördinaat binnen de opgegeven grenzen.
     *
     * @param Y de maximale waarde voor de Y-coördinaat.
     * @return een willekeurige Y-coördinaat.
     */
    public double randomY(double Y) {
        return Math.floor(Math.random() * Y);
    }
}