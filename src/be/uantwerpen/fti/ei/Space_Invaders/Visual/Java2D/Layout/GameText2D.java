package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Layout.AGameText;

import java.awt.*;


/**
 * De klasse GameText2D is verantwoordelijk voor het maken van alle teksten die in het spel nodig zijn.
 * Het breidt de basisklasse AGameText uit en maakt gebruik van de GraphicsContext voor het tekenen van de teksten.
 *
 * @author Thomas Van Ostade
 */

public class GameText2D extends AGameText {

        private static GraphicsContext grCtx;
        int counter = 1;
        int colorCounter = 0;
        int reloadingCounter = 0;
        int dx = -1;

        /**
         * Creëert een nieuw GameText2D-object met de opgegeven GraphicsContext.
         *
         * @param grCtx De GraphicsContext voor het tekenen van de teksten.
         */
        public GameText2D(GraphicsContext grCtx) {
            GameText2D.grCtx = grCtx;
        }

        // region accent Text

        /**
         * Bepaalt de grootte van de accenttekst op basis van de normale grootte en de tellerwaarde.
         *
         * @param normalsize De normale grootte van de tekst.
         * @param counter    De tellerwaarde.
         * @return De grootte van de accenttekst.
         */
        public double AccentText(int normalsize, int counter) {
            if (counter < 20) {
                return normalsize;
            }
            if (counter > 20 && counter < 40) {
                return normalsize * 1.1;
            }
            return 0;
        }
        // endregion accent Text

        /**
         * Tekent het startscherm van het spel.
         */
        public void StartScreen() {
            Graphics2D g2d = grCtx.getG2d();

            // region Title
            g2d.setColor(new Color(250, 100, colorCounter));
            g2d.setFont(new Font("Algerian", Font.PLAIN, 50));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("SPACE INVADERS", 450, 100);
            g2d.drawLine(450, 110, 850, 110);
            // endregion

            // region Enter
            g2d.setColor(new Color(204, 204, 255));
            g2d.setFont(new Font("Calibri", Font.PLAIN, (int) AccentText(30, counter)));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("PRESS ENTER TO START", 500, 600);
            // endregion

            // region Automatic/Classic
            g2d.setColor(new Color(204, 255, 255));
            g2d.setFont(new Font("Calibri", Font.PLAIN, 20));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("PRESS A FOR AUTOMATIC", 10, 640);
            g2d.drawString("PRESS C FOR CLASSIC", 10, 600);
            // endregion

            if (counter == 40)
                counter = 0;
            counter++;

            if (colorCounter == 255) {
                dx = -1;
            }
            if (colorCounter == 0) {
                dx = 1;
            }
            colorCounter += dx;
        }

        /**
         * Tekent het speelscherm van het spel.
         *
         * @param i               Het huidige levelnummer.
         * @param numberOfKills   Het aantal gedode vijanden.
         * @param outOfBlasts     Geeft aan of de speler geen beschikbare schoten meer heeft.
         * @param remainingBlasts Het aantal overgebleven schoten van de speler.
         */
        public void GamePlay(int i, int numberOfKills, boolean outOfBlasts, int remainingBlasts) {
            Graphics2D g2d = grCtx.getG2d();

            g2d.setColor(new Color(204, 229, 255));
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 30));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("LEVEL: " + i, 1120, 630);

            g2d.setFont(new Font("SansSerif", Font.PLAIN, 30));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("KILLS: " + numberOfKills, 1120, 670);

            if (outOfBlasts) {
                reloadingCounter++;

                g2d.setColor(new Color(181, 107, 87));
                g2d.setFont(new Font("ARIAL", Font.PLAIN, 25));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawString("RELOADING ", 10, 30);

                if (reloadingCounter > 5) {
                    g2d.drawString(".", 160, 30);
                    if (reloadingCounter > 10) {
                        g2d.drawString(".", 165, 30);
                        if (reloadingCounter > 15) {
                            g2d.drawString(".", 170, 30);
                            reloadingCounter = 0;
                        }
                    }
                }
            } else {
                g2d.setColor(new Color(195, 23, 242));
                g2d.setFont(new Font("ARIAL", Font.PLAIN, 25));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawString("BLASTS: " + remainingBlasts, 10, 30);
            }

            g2d.setColor(new Color(204, 229, 255));
            g2d.drawRect(1100, 600, 230, 200);
        }

        /**
         * Tekent het Game Over-scherm.
         */
        public void GameOver() {
            Graphics2D g2d = grCtx.getG2d();

            g2d.setColor(new Color(204, 229, 255));
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 50));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("GAME OVER", 480, 300);
            g2d.drawLine(480, 310, 780, 310);
        }

        /**
         * Tekent het scherm waarop wordt aangegeven dat de speler gewonnen heeft.
         */
        public void YouWin() {
            Graphics2D g2d = grCtx.getG2d();
            g2d.setColor(new Color(204, 229, 255));
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 50));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("YOU WIN", 550, 300);

            // region Enter
            g2d.setColor(new Color(204, 204, 255));
            g2d.setFont(new Font("Calibri", Font.PLAIN, (int) AccentText(30, counter)));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("PRESS ENTER TO CONTINUE", 470, 600);
            // endregion

            if (counter == 40)
                counter = 0;
            counter++;


        }

        /**
         * Tekent het scherm voor het volgende level met het opgegeven levelnummer.
         *
         * @param i Het volgende levelnummer.
         */
        public void nextLevel(int i) {
            Graphics2D g2d = grCtx.getG2d();

            g2d.setColor(new Color(204, 229, 255));
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 50));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawString("LEVEL" + i, 550, 300);
        }
    }

