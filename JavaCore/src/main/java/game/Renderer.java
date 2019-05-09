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

    //private BufferedImage image;
    private BufferedImage playerImage;

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
    public Renderer(int width, int height, double updates, String gameTitle, int windowPositionWidth, int windowPositionHeight, Model model) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.UPDATES = updates;
        this.GAME_TITLE = gameTitle;
        this.windowPositionWidth = windowPositionWidth;
        this.windowPositionHeight = windowPositionHeight;
        this.model = model;
        //this.image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);


        try {
            File playerImageFile = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\Player2.png");
            playerImage = ImageIO.read(playerImageFile);


            File backgroundImageFile9 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0000_9.png");
            backgroundImage9 = ImageIO.read(backgroundImageFile9);
            File backgroundImageFile8 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0001_8.png");
            backgroundImage8 = ImageIO.read(backgroundImageFile8);
            File backgroundImageFile7 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0002_7.png");
            backgroundImage7 = ImageIO.read(backgroundImageFile7);
            File backgroundImageFile6 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0003_6.png");
            backgroundImage6 = ImageIO.read(backgroundImageFile6);
            File backgroundImageFile5 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0005_5.png");
            backgroundImage5 = ImageIO.read(backgroundImageFile5);
            File backgroundImageFile4 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0006_4.png");
            backgroundImage4 = ImageIO.read(backgroundImageFile4);
            File backgroundImageFile3 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0008_3.png");
            backgroundImage3 = ImageIO.read(backgroundImageFile3);
            File backgroundImageFile2 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0009_2.png");
            backgroundImage2 = ImageIO.read(backgroundImageFile2);
            File backgroundImageFile1 = new File("JavaCore\\src\\main\\java\\game\\resources\\images\\background\\Layer_0010_1.png");
            backgroundImage1 = ImageIO.read(backgroundImageFile1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Вывод изображения
     */
    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        //graphics.drawImage(image, 0, 0, WIDTH, HEIGHT, this);

        int y = -500; //выравнивание фона по высоте
        graphics.drawImage(backgroundImage1, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage2, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage3, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage4, 0, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage5, model.getBackground5().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage5, model.getBackground5().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage6, model.getBackground6().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage6, model.getBackground6().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage7, model.getBackground7().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage7, model.getBackground7().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage8, model.getBackground8().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage8, model.getBackground8().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage9, model.getBackground9().getX(), y, WIDTH, HEIGHT - y, this);
        graphics.drawImage(backgroundImage9, model.getBackground9().getX() + WIDTH, y, WIDTH, HEIGHT - y, this);

        graphics.drawImage(playerImage, model.getPlayer().getX(), model.getPlayer().getY(), 120, 100, this);

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
     * Изменение модели игры
     */
    public void update() {
        model.run();
    }


}
