package be.uantwerpen.fti.ei.Space_Invaders;

import be.uantwerpen.fti.ei.Space_Invaders.Game.AFact;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Game;
import be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Fact2D;

import java.io.IOException ;

public class

  Main {

    public static void main(String[] args) throws IOException, InterruptedException{

        // Keuze tussen Java2D en TXT fact
        //AFact f = new TxTFact();
        AFact f = new Fact2D();
        Game game = new Game(f); //we geven nu de 2D-factory in ..
                  game. run();
     }
}

