package game;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Отрисовка изображения
 */
public class Renderer extends Canvas {

    private int WIDTH;
    private int HEIGHT;
    private int windowPositionWidth;
    private int windowPositionHeight;
    private double UPDATES;
    private String GAME_TITLE;


    private BufferedImage playerImage;
    private BufferedImage enemyCarrionImage;
    private BufferedImage enemyHuskImage;

    private BufferedImage backgroundImage1;
    private BufferedImage backgroundImage2;
    private BufferedImage backgroundImage3;
    private BufferedImage backgroundImage4;
    private BufferedImage backgroundImage5;
    private BufferedImage backgroundImage6;
    private BufferedImage backgroundImage7;
    private BufferedImage backgroundImage8;
    private BufferedImage backgroundImage9;


    private Model model;


    /**
     * Конструктор, инициализация картинок
     */
    public Renderer(int width, int height, double updates, String gameTitle, int windowPositionWidth, int windowPositionHeight, Model model) throws IOException {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.UPDATES = updates;
        this.GAME_TITLE = gameTitle;
        this.windowPositionWidth = windowPositionWidth;
        this.windowPositionHeight = windowPositionHeight;
        this.model = model;

        //картинки игровых объектов
        File playerImageFile = new File("Game\\src\\main\\resources\\images\\Player2.png");
        playerImage = ImageIO.read(playerImageFile);
        File enemyCarrionImageFile = new File("Game\\src\\main\\resources\\images\\EnemyCarrion.png");
        enemyCarrionImage = ImageIO.read(enemyCarrionImageFile);
        File enemyHuskImageFile = new File("Game\\src\\main\\resources\\images\\EnemyHusk.png");
        enemyHuskImage = ImageIO.read(enemyHuskImageFile);

        //картинки фона
        File backgroundImageFile9 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0000_9.png");
        backgroundImage9 = ImageIO.read(backgroundImageFile9);
        File backgroundImageFile8 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0001_8.png");
        backgroundImage8 = ImageIO.read(backgroundImageFile8);
        File backgroundImageFile7 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0002_7.png");
        backgroundImage7 = ImageIO.read(backgroundImageFile7);
        File backgroundImageFile6 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0003_6.png");
        backgroundImage6 = ImageIO.read(backgroundImageFile6);
        File backgroundImageFile5 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0005_5.png");
        backgroundImage5 = ImageIO.read(backgroundImageFile5);
        File backgroundImageFile4 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0006_4.png");
        backgroundImage4 = ImageIO.read(backgroundImageFile4);
        File backgroundImageFile3 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0008_3.png");
        backgroundImage3 = ImageIO.read(backgroundImageFile3);
        File backgroundImageFile2 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0009_2.png");
        backgroundImage2 = ImageIO.read(backgroundImageFile2);
        File backgroundImageFile1 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0010_1.png");
        backgroundImage1 = ImageIO.read(backgroundImageFile1);

    }


    /**
     * Вывод изображения
     */
    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(4);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        //отрисовка фона
        int y = -500; //выравнивание фона по высоте
        graphics.drawImage(backgroundImage1, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage2, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage3, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage4, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage5, (int)model.getBackground5().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage5, (int)model.getBackground5().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage6, (int)model.getBackground6().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage6, (int)model.getBackground6().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage7, (int)model.getBackground7().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage7, (int)model.getBackground7().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage8, (int)model.getBackground8().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage8, (int)model.getBackground8().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage9, (int)model.getBackground9().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage9, (int)model.getBackground9().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);

        //отрисовка игровых объектов
        graphics.drawImage(playerImage, model.getPlayer().getX(), model.getPlayer().getY(), 150, 130, this);
        graphics.drawImage(enemyCarrionImage, (int)model.getEnemyCarrion().getX(),  (int)model.getEnemyCarrion().getY(), 180, 120, this);
        graphics.drawImage(enemyHuskImage, (int)model.getEnemyHusk().getX(),  (int)model.getEnemyHusk().getY(), 180, 160, this);

        graphics.dispose();
        bufferStrategy.show();
    }


    /**
     * Главный игровой цикл
     */
    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setUndecorated(true); // на весь экран
        jFrame.setVisible(true);
        jFrame.setTitle(GAME_TITLE);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(windowPositionWidth, windowPositionHeight, WIDTH, HEIGHT);

        //отрисовка
        jFrame.add(this);

        long lastTime = System.nanoTime();
        double ns = 1000_000_000 / UPDATES;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Updates, FPS " + frames);
                jFrame.setTitle(GAME_TITLE + " | Updates " + updates + ", FPS " + frames);
                updates = 0;
                frames = 0;
            }
        }
    }


    /**
     * Изменение игровой модели
     */
    public void update() {
        model.run();
    }


}
