package be.uantwerpen.fti.ei.Space_Invaders.Game.Components;

/**
 * De ColliderComponent klasse bevat een methode om te controleren of twee entiteiten met elkaar in botsing komen.
 *
 */
public class ColliderComponent {

    /**
     * Controleert of twee entiteiten met elkaar in botsing komen.
     *
     * @param x1      x-coördinaat van de grote entiteit.
     * @param y1      y-coördinaat van de grote entiteit.
     * @param width1  breedte van de grote entiteit.
     * @param height1 hoogte van de grote entiteit.
     * @param x2      x-coördinaat van de kleine entiteit.
     * @param y2      y-coördinaat van de kleine entiteit.
     * @param width2  breedte van de kleine entiteit.
     * @param height2 hoogte van de kleine entiteit.
     * @return true als de entiteiten met elkaar in botsing komen, anders false.
     */
    public boolean hit(double x1, double y1, double width1, double height1, double x2, double y2, double width2, double height2) {

        // Buiten het bereik
        if (Math.floor(x2 + width2) < Math.floor(x1) || Math.floor(x2) > Math.floor(x1 + width1)) {
            return false;
        } else if (Math.floor(y2 + height2) < Math.floor(y1) || Math.floor(y2) > Math.floor(y1 + height1)) {
            return false;
        }
        return true;
    }
}