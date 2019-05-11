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
    private Controller controller;
    private Model model;

    /**
     * Конструктор
     */
    public Renderer(int width, int height, double updates, String gameTitle, int windowPositionWidth, int windowPositionHeight, Model model) throws IOException {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.UPDATES = updates;
        this.GAME_TITLE = gameTitle;
        this.windowPositionWidth = windowPositionWidth;
        this.windowPositionHeight = windowPositionHeight;
        this.model = model;
        this.controller = new Controller(model);
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

        //Отрисовка всех игровых объектов
        model.getGameObjects().forEach(gameObject -> {
            graphics.drawImage(gameObject.getBufferedImage(), (int)gameObject.getX(), (int)gameObject.getY(), gameObject.getImageWidth(), gameObject.getImageHeight(), null);
        });

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
        jFrame.addKeyListener(controller);

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
                updateModel();
                if(model.isClash()) {
                    break;
                }
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
    private void updateModel() {
        model.update();
    }


}
