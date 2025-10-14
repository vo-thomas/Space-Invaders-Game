package be.uantwerpen.fti.ei.Space_Invaders.Visual.Java2D.Layout;

import be.uantwerpen.fti.ei.Space_Invaders.Game.Components.RandomGeneratorComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Grafische contextklasse voor het Space Invaders-spel.
 *
 * @author Thomas Van Ostade
 */
public class GraphicsContext {
    public int ScreenWidth;
    public int ScreenHeight;
    private JFrame frame;
    public JPanel panel;
    private BufferedImage g2dimage;
    private Graphics2D g2d;

    public BufferedImage backgroundImg;
    public BufferedImage PlayerSprite;
    public BufferedImage BlastSprite;
    public BufferedImage EnemySprite;
    public BufferedImage EnemyBlastSprite;
    public BufferedImage HeartSprite;
    public BufferedImage ExplosionSprite;
    public BufferedImage BonusSprite;
    public BufferedImage MeteoriteSprite;

    private int sizeX;
    private int sizeY;
    RandomGeneratorComponent randomGeneratorComponent = new RandomGeneratorComponent();
    private double x, y;

    /**
     * Geeft het Graphics2D-object terug.
     *
     * @return Het Graphics2D-object.
     */
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
     * Geeft het JFrame-object terug.
     *
     * @return Het JFrame-object.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Geeft de grootte van X-dimensie terug.
     *
     * @return De grootte van X-dimensie.
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Geeft de grootte van Y-dimensie terug.
     *
     * @return De grootte van Y-dimensie.
     */
    public int getSizeY() {
        return sizeY;
    }

    int counter = 0;
    int speedCounter = 0;
    int speed = 1;

    /**
     * Schaalt de opgegeven afbeelding naar de gewenste breedte en hoogte.
     *
     * @param originalImage De originele afbeelding.
     * @param targetWidth   De gewenste breedte.
     * @param targetHeight  De gewenste hoogte.
     * @return De geschaalde afbeelding.
     */
    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    private void loadImages() {
        backgroundImg = null;
        try {
            System.out.println("loadImages");
            backgroundImg = ImageIO.read(new File("src/resource/Images/space4.png"));
            PlayerSprite = ImageIO.read(new File("src/resource/Images/playership3.png"));
            BlastSprite = ImageIO.read(new File("src/resource/Images/beams.png"));
            EnemySprite = ImageIO.read(new File("src/resource/Images/enemyship2.png"));
            HeartSprite = ImageIO.read(new File("src/resource/Images/heart.png"));
            ExplosionSprite = ImageIO.read(new File("src/resource/Images/explosion.png"));
            EnemyBlastSprite = ImageIO.read(new File("src/resource/Images/enemyblast2.png"));
            BonusSprite = ImageIO.read(new File("src/resource/Images/bonus.png"));
            MeteoriteSprite = ImageIO.read(new File("src/resource/Images/meteorite.png"));

        } catch (IOException e) {
            System.out.println("Unable to load space.png or playership2.0.png or blast.png");
        }
    }

    /**
     * Constructor voor GraphicsContext-klasse.
     * Initialiseert het frame en panel.
     */
    public GraphicsContext() {
        ScreenWidth = 1280;
        ScreenHeight = 720;
        frame = new JFrame();
        panel = new JPanel(true) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                doDrawing(g);
            }
        };
        frame.add(panel);
        frame.setTitle("SpaceInvaders");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Herlaadt het paneel.
     */
    public void render() {
        panel.repaint();
    }

    /**
     * Voert het tekenen uit op het paneel.
     *
     * @param g Het Graphics-object.
     */
    public void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;

        graph2d.drawImage(g2dimage, 0, 0, null);
        graph2d.dispose();
        if (g2d != null && counter < 720)
            g2d.drawImage(backgroundImg, 0, -backgroundImg.getHeight() / 2 + counter, null);
        else
            counter = 0;

        speedCounter = speedCounter + 1;
        counter = counter + speed;
        if (speedCounter >= 1000) {
            speed++;
            speedCounter = 0;
        }
    }

    /**
     * Stelt de dimensies van het spel in.
     *
     * @param GameCellsX Het aantal spelcellen in de breedte.
     * @param GameCellsY Het aantal spelcellen in de hoogte.
     */
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        sizeX = ScreenWidth / GameCellsX;
        sizeY = ScreenHeight / GameCellsY;

        x = randomGeneratorComponent.randomX(0.7);
        y = randomGeneratorComponent.randomY(0.7);

        System.out.println("sizeX: " + x);
        System.out.println("sizeY:" + y);

        frame.setLocation(30, 50);
        frame.setSize(ScreenWidth, ScreenHeight);
        loadImages();

        try {
            backgroundImg = resizeImage(backgroundImg, frame.getWidth(), 2 * frame.getHeight());
            PlayerSprite = resizeImage(PlayerSprite, sizeX * 25, sizeY * 35);
            BlastSprite = resizeImage(BlastSprite, sizeX * 20, sizeY * 32);
            EnemySprite = resizeImage(EnemySprite, sizeX * 15, sizeY * 25);
            EnemyBlastSprite = resizeImage(EnemyBlastSprite, sizeX * 20, sizeY * 25);
            ExplosionSprite = resizeImage(ExplosionSprite, sizeX * 25, sizeY * 25);
            HeartSprite = resizeImage(PlayerSprite, sizeX * 6, sizeY * 12);
            BonusSprite = resizeImage(BonusSprite, sizeX * 30, sizeY * 20);
            MeteoriteSprite = resizeImage(MeteoriteSprite, sizeX * 35, sizeY * 48);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();

        g2d.drawImage(backgroundImg, 0, 0, null);
    }
}

