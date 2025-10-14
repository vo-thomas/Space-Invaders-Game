package be.uantwerpen.fti.ei.Space_Invaders.Visual.TXT;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerShip;


public class TxTPlayerShip extends PlayerShip {


    public TxTPlayerShip(int playerX, int playerY, int speed, int lives) {
        super(playerX, playerY, lives,speed);
    }


    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void draw() {

    }


    @Override
    public boolean CollisionLeftDetected() {
        return false;
    }

    @Override
    public boolean CollisionRightDetected() {
        return false;
    }

    @Override
    public boolean CollisionUpDetected() {
        return false;
    }

    @Override
    public boolean CollisionDownDetected() {
        return false;
    }

    @Override
    public int getGameScreenWidth() {
        return 0;
    }

    @Override
    public int getGameScreenHeight() {
        return 0;
    }


    public boolean isShoot1() {return false;}
    public boolean isShoot2() {return false;}
    public boolean isShoot3() {return false;}

    public void setDirection(Input.Inputs direction) {

    }


}
