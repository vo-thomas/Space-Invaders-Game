package be.uantwerpen.fti.ei.Space_Invaders.Game;

//Enemy
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.RandomGeneratorComponent;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.SoundSystem;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.Enemies;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyBlast;

// Player
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Bonus;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.BonusController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.Meteorite;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Falling_object.MeteoriteController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Input.Input;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Layout.AGameText;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerBlast;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerShip;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Player.PlayerController;
import be.uantwerpen.fti.ei.Space_Invaders.Game.Enemy.EnemyController;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

import java.io.*;

/**
 * De Game-klasse is verantwoordelijk voor het beheren en uitvoeren van het Space Invaders-spel.
 *
 *  @author Thomas Van Ostade
 */

public class Game {

    // region abstractfactory-declaratie
    private final AFact abstractFactory; //  abstractfactory declaratie
    PlayerShip playerShip;
    Enemies enemies;
    Bonus bonus;
    BonusController bonusController;
    MeteoriteController meteoriteController;
    SoundSystem soundSystem;

    PlayerController playercontroller;
    EnemyController enemycontroller;
    Input input;
    AGameText aGameText;
    // endregion

    // region Constructor
    public Game(AFact abstractFactory) throws FileNotFoundException {
        this.abstractFactory = abstractFactory;
    }
    // endregion

    // region Game State
    // Initialiseer de isRunning en isPaused - state
    boolean isRunning = true;
    boolean isPaused = false;
    // endregion

    // region Initialisatie randomGenerator
    RandomGeneratorComponent randomGenerator = new RandomGeneratorComponent();
    double RandomX;
    // endregion

    // region GameScreen
    // lees de schermconfiguratie uit de property - file
    FileInputStream gameScreen = new FileInputStream("src/resource/Config/gameScreen.properties");
    int GameCellsX,GameCellsY;
    // endregion

    // region movement Settings
    // lees de movement - configuratie uit de property - file
    FileInputStream settings = new FileInputStream("src/resource/Config/settings.properties");

    // endregion

    // region Levels
    // lees de levels uit de property-file
    ArrayList<FileInputStream> levels = new ArrayList<>();
    FileInputStream Level1     = new FileInputStream("src/resource/Config/Level1.properties");
    FileInputStream Level2     = new FileInputStream("src/resource/Config/Level2.properties");
    FileInputStream Level3     = new FileInputStream("src/resource/Config/Level2.properties");

    // endregion

    // region Timer initialisatie
    Timer timer = new Timer(); // timer voor de game loop
    String mode = "GameStart";  // Intitiële mode
    // endregion

    // region Counters

    // PlayerShip
    int shootCounter = 0;
    int ShootTime;
    int blastCounter = 0;
    boolean outOfBlasts = false;
    int BlastCounterMax;
    int RemainingBlasts = BlastCounterMax - blastCounter;
    int reloadCounter = 0;
    int MaxReloadTime = 60;

    // Bonus
    int bonusCounter = 0;
    int BonusCounterMax;

    // Meteoriet
    int meteoriteCounter = 0;
    int MeteoriteCounterMax;

    // Tussenscherm
    int i = 0;// Counter voor duratie tussenscherm

    // Level
    int l = 0;// Index level (Level1, Level2, Level3)

    // endregion

   // region initialisatie entity - methods

    int MeteoriteSpeed;
    int EnemyBlastSpeed;


    //Playership
    int Lives;
    int Speed;
    String Movement;

    //Enemies
    int InitialEnemyX = 2;
    int InitialEnemyY = 10;
    int EnemyRangeY = 40;
    int Distance;
    int EnemySpeed;
    int NumberOfEnemies;
    int EnemyLives;
    double probability; // de kans dat een enemy een blast afschiet

    // endregion

    /**
     * Slaat de eigenschappen op in het opgegeven bestand.
     *
     * @param p    De eigenschappen die moeten worden opgeslagen.
     * @param file Het bestand waarin de eigenschappen moeten worden opgeslagen.
     * @throws IOException Indien er een I/O-fout optreedt tijdens het opslaan van de eigenschappen.
     */
    static void saveProperties(Properties p, File file) throws IOException {
        FileOutputStream fr = new FileOutputStream(file);
        p.store(fr, "Properties");
        fr.close();
    }

    /**
     * Initialiseert het Game-scherm op basis van de gegeven configuratie.
     *
     * @param screenConfig De configuratie van het scherm.
     * @param properties   De eigenschappen van het spel.
     * @throws IOException Indien er een I/O-fout optreedt bij het laden van de configuratie.
     */

    public void initialiseGameScreen(FileInputStream screenConfig, Properties properties) throws IOException {
        properties.load(screenConfig);
        GameCellsX = Integer.parseInt(properties.getProperty("gameCellsX"));
        GameCellsY =  Integer.parseInt(properties.getProperty("gameCellsY"));
        abstractFactory.setGameDimensions(GameCellsX, GameCellsY);
    }

    /**
     * Initialiseert de entiteiten van het spel op basis van de gegeven configuratie.
     *
     * @param properties De eigenschappen van het spel.
     * @param level      Het huidige level van het spel.
     * @throws IOException Indien er een I/O-fout optreedt bij het laden van de configuratie.
     */

    public void initialiseEntities(Properties properties,FileInputStream level) throws IOException {
        properties.load(level); // we laden de property met het huidige level

        // region lees uit file
        // Playership
        Lives = Integer.parseInt(properties.getProperty("Lives"));
        Speed = Integer.parseInt(properties.getProperty("Speed"));
        BlastCounterMax = Integer.parseInt(properties.getProperty("BlastCounterMax"));
        ShootTime = Integer.parseInt(properties.getProperty("ShootTime"));


        // Enemies
        EnemySpeed = Integer.parseInt(properties.getProperty("EnemySpeed"));
        EnemyLives = Integer.parseInt(properties.getProperty("EnemyLives"));
        NumberOfEnemies = Integer.parseInt(properties.getProperty("NumberOfEnemies"));
        Distance = Integer.parseInt(properties.getProperty("Distance"));
        probability = Integer.parseInt(properties.getProperty("Probability"));
        EnemyBlastSpeed = Integer.parseInt(properties.getProperty("EnemyBlastSpeed"));

        // Bonus
        BonusCounterMax = Integer.parseInt(properties.getProperty("BonusCounterMax"));

        // Meteoriet
        MeteoriteCounterMax = Integer.parseInt(properties.getProperty("MeteoriteCounterMax"));
        MeteoriteSpeed = Integer.parseInt(properties.getProperty("MeteoriteSpeed"));

        // endregion

        // region Initialise
        RandomX = randomGenerator.randomX(GameCellsX);
        playerShip = abstractFactory.makePlayerShip(RandomX,250,Speed,Lives);
        playercontroller = abstractFactory.makePlayerController(0,0,-3,1);
        enemies = abstractFactory.makeEnemies(InitialEnemyX, InitialEnemyY, EnemySpeed, EnemyLives, EnemyRangeY, NumberOfEnemies, Distance);
        enemycontroller = abstractFactory.makeEnemyController(0,0,EnemyBlastSpeed,1);
        bonusController = abstractFactory.makeBonusController(0,0,1,1);
        meteoriteController = abstractFactory.makeMeteoriteController(0,0,MeteoriteSpeed,1);
        // endregion

    }

    /**
     * Kiest de beweging op basis van de gebruikersinvoer.
     *
     * @param properties De eigenschappen van het spel.
     * @param keyInput   De gebruikersinvoer.
     * @throws IOException Indien er een I/O-fout optreedt bij het laden van de configuratie.
     */

    public void chooseMovement(Properties properties, Input.Inputs keyInput) throws IOException {
        properties.load(settings);
        if (keyInput == Input.Inputs.C) {
            properties.setProperty("Movement", "MoveClassic");
        }
        if (keyInput == Input.Inputs.A) {
            properties.setProperty("Movement", "MoveAuto");

        }
        saveProperties(properties,new File("src/resource/Config/settings.properties"));
    }

    /**
     * Geeft de beweging van de playership terug op basis van de geconfigureerde eigenschappen.
     *
     * @param properties De eigenschappen van het spel.
     * @return De beweging van de playership.
     */

    public String getMovement(Properties properties){
        return properties.getProperty("Movement");
    }

    /**
     * Leest het huidige level in op basis van de gegeven configuratie.
     *
     * @param properties De eigenschappen van het spel.
     * @param level      Het huidige level van het spel.
     * @throws IOException Indien er een I/O-fout optreedt bij het laden van de configuratie.
     */

    public void getLevel(Properties properties,FileInputStream level) throws IOException {

        properties.load(level); // we laden de property met het huidige level

        // region lees uit file
        // Playership
        Lives = Integer.parseInt(properties.getProperty("Lives"));
        Speed = Integer.parseInt(properties.getProperty("Speed"));
        BlastCounterMax = Integer.parseInt(properties.getProperty("BlastCounterMax"));
        ShootTime = Integer.parseInt(properties.getProperty("ShootTime"));


        // Enemies
        EnemySpeed = Integer.parseInt(properties.getProperty("EnemySpeed"));
        EnemyLives = Integer.parseInt(properties.getProperty("EnemyLives"));
        NumberOfEnemies = Integer.parseInt(properties.getProperty("NumberOfEnemies"));
        Distance = Integer.parseInt(properties.getProperty("Distance"));
        probability = Integer.parseInt(properties.getProperty("Probability"));
        EnemyBlastSpeed = Integer.parseInt(properties.getProperty("EnemyBlastSpeed"));

        // Bonus
        BonusCounterMax = Integer.parseInt(properties.getProperty("BonusCounterMax"));

        // Meteoriet
        MeteoriteCounterMax = Integer.parseInt(properties.getProperty("MeteoriteCounterMax"));
        MeteoriteSpeed = Integer.parseInt(properties.getProperty("MeteoriteSpeed"));

        // endregion

        // region initialise
        RandomX = randomGenerator.randomX(GameCellsX);
        playerShip.setCurX(RandomX);
        playerShip.setLives(Lives);
        playerShip.setSpeed(Speed);
        enemies.setLives(EnemyLives);
        enemies.setNumberOfEnemies(NumberOfEnemies);
        enemycontroller.setSpeed(EnemyBlastSpeed);
        meteoriteController.setSpeed(MeteoriteSpeed);

        meteoriteController = abstractFactory.makeMeteoriteController(0,0,MeteoriteSpeed,1);
        enemycontroller = abstractFactory.makeEnemyController(0,0,EnemyBlastSpeed,1);
        enemies = abstractFactory.makeEnemies(InitialEnemyX, InitialEnemyY, EnemySpeed, EnemyLives, EnemyRangeY, NumberOfEnemies, Distance);

        // endregion
    }

    /**
     * Start de uitvoering van het spel.
     *
     * @throws IOException            Indien er een I/O-fout optreedt bij het laden van de configuratie.
     * @throws InterruptedException Indien de thread onderbroken wordt tijdens het wachten.
     */

    public void run() throws IOException, InterruptedException {

        // region aanmaken van properties
        Properties properties = new Properties(); // GameScreen
        initialiseGameScreen(gameScreen,properties);
        Properties properties2 = new Properties(); // Movement
        Properties properties3 = new Properties(); // Level
        Properties properties4 = new Properties(); // Initialisatie
        // endregion

        // region  levels toevoegen aan ArrayList
        levels.add(0,Level1);
        levels.add(1,Level2);
        levels.add(2,Level3);
        // endregion

        // region muziek afspelen
        soundSystem = abstractFactory.makeSoundSystem();
        soundSystem.playMusic(8);
        soundSystem.playMusic(2);
        // endregion

        // region initialisatie entities, input en gametekst
        initialiseEntities(properties4, Level1);
        input = abstractFactory.initialiseInput();
        aGameText = abstractFactory.makeGameText();
        // endregion

        while(isRunning){

            timer.startTimer();
            Input.Inputs keyInput;

            switch (mode) {

                // region GameStart
                case "GameStart" -> {
                    aGameText.StartScreen();

                    if(meteoriteCounter > 100) {
                        soundSystem.playSE(7);
                        Meteorite meteorite = meteoriteController.spawnRandom(abstractFactory, GameCellsX, 0);
                        meteoriteController.addMeteorite(meteorite);
                        meteoriteCounter = 0;
                    }
                    meteoriteController.move();
                    meteoriteController.draw();
                    meteoriteCounter++;

                    if (input.inputAvailable()) {
                        keyInput = input.getInput();
                        chooseMovement(properties2,keyInput);
                        Movement = getMovement(properties2);
                        if (keyInput == Input.Inputs.ENTER) {
                            mode = "NextLevel";
                            meteoriteCounter = 0;
                        }
                    }
                }
                // endregion

                // region GamePlay
                case "GamePlay" -> {

                    aGameText.GamePlay(l+1,enemies.numberofkills(),outOfBlasts,RemainingBlasts);
                    if (input.inputAvailable()) {
                        keyInput = input.getInput();

                        if (keyInput == Input.Inputs.P) {
                            isPaused = !isPaused;
                        }

                        if (!isPaused) { // NIET in pauze

                            if (keyInput == Input.Inputs.SPACE) {
                                if (shootCounter > ShootTime) {
                                    blastCounter++;
                                    RemainingBlasts = BlastCounterMax - blastCounter;
                                    shootCounter = 0;

                                    if (blastCounter < BlastCounterMax) {
                                        PlayerBlast playerBlast = abstractFactory.makePlayerBlast(playerShip.getCurX(), playerShip.getCurY(), -5, Lives);
                                        playercontroller.addBlast(playerBlast);
                                        soundSystem.playSE(3);
                                    }
                                }
                            }
                            else {
                                playerShip.setDirection(keyInput);

                                if (Objects.equals(Movement, "MoveClassic")) {
                                    playerShip.moveClassic(keyInput);
                                }
                            }
                        }
                    }

                    if (!isPaused) {

                        if(blastCounter >= BlastCounterMax){
                            outOfBlasts = true;
                            reloadCounter ++;
                            if (reloadCounter >= MaxReloadTime){
                                blastCounter = 0;
                                outOfBlasts = false;
                                reloadCounter = 0;
                                RemainingBlasts = BlastCounterMax;
                            }
                        }

                        if (Objects.equals(Movement, "MoveAuto"))
                            playerShip.move();

                        if (playerShip.getLives() == 0) {
                            mode = "GameOver";
                            soundSystem.playSE(4);
                        }

                        if (enemies.getNumberOfEnemies() == 0) {
                            mode = "YouWin";
                            soundSystem.playSE(5);
                        }

                        if (enemies.shouldFireBlast(probability * 0.001)) {
                            EnemyBlast enemyblast = enemycontroller.spawnRandomEnemyBlast(enemies, abstractFactory);
                            enemycontroller.addBlast(enemyblast);
                            soundSystem.playSE(0);
                        }

                        // region Bonus counter
                        if(bonusCounter > BonusCounterMax){
                            //Random coördinaten
                            Bonus bonus = bonusController.spawnRandom(abstractFactory,GameCellsX,(double) GameCellsY/2);
                            bonusController.addBonus(bonus);
                            bonusCounter = 0;
                        }
                        // endregion Bonuscounter

                        // region Meteoriet counter
                        if(meteoriteCounter > MeteoriteCounterMax){
                            //Random coördinaten
                            soundSystem.playSE(7);
                            Meteorite meteorite = meteoriteController.spawnRandom(abstractFactory,GameCellsX,(double) GameCellsY/8);
                            meteoriteController.addMeteorite(meteorite);
                            meteoriteCounter = 0;
                        }


                        playercontroller.move();
                        playerShip.CollisionDetection(enemycontroller,enemies,bonusController,meteoriteController, BlastCounterMax, soundSystem);

                        enemycontroller.move();
                        enemies.move();

                        enemies.CollisionDetection(playercontroller, soundSystem);
                        bonusController.move();
                        meteoriteController.move();
                    }

                    playercontroller.draw();
                    enemycontroller.draw();
                    playerShip.draw();
                    enemies.draw();
                    bonusController.draw();
                    meteoriteController.draw();

                    shootCounter++;
                    bonusCounter ++;
                    meteoriteCounter++;
                }

                // endregion

                // region GameOver
                case "GameOver" -> {

                    aGameText.GameOver();

                    if (input.inputAvailable()) {
                        keyInput = input.getInput();
                        if (keyInput == Input.Inputs.ENTER) {


                            playercontroller.removeAll();
                            enemycontroller.removeAll();
                            bonusController.removeAll();
                            meteoriteController.removeAll();

                            blastCounter = 0;
                            shootCounter = 0;
                            meteoriteCounter = 0;

                            playerShip.EnemyHit = false;
                            l = 0;
                            mode = "GameStart";
                            initialiseEntities(properties4,Level1);
                        }
                    }

                }
                // endregion

                // region YouWin
                case "YouWin" -> {
                    aGameText.YouWin();
                    playercontroller.removeAll();
                    enemycontroller.removeAll();
                    bonusController.removeAll();
                    meteoriteController.removeAll();


                    blastCounter = 0;

                    if (input.inputAvailable()) {
                        keyInput = input.getInput();
                        if (keyInput == Input.Inputs.ENTER) {
                            if(l == levels.size() - 1) {
                                l = 0;
                                mode = "GameStart";
                                initialiseEntities(properties4,Level1); // Als we het maximum level gewonnen hebben, beginnen we opnieuw
                            }
                            else {
                                l += 1;
                                getLevel(properties3, levels.get(l));
                                mode = "NextLevel";
                            }
                        }
                    }
                }
                // endregion

                // region NextLevel
                case "NextLevel"->{
                    i ++;
                    aGameText.nextLevel(l+1);
                    if(i==50){
                        mode = "GamePlay";
                        i = 0;
                    }
                }
                // endregion
            }

            // Render de game --> verwijst naar panel.repaint
            abstractFactory.render();

            // WaitTime = 20 ms
            timer.sleepTimer(15);

        }
    }

}














