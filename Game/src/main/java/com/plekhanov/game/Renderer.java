package com.plekhanov.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Отрисовка изображения
 */
public class Renderer extends Canvas implements Runnable {

    private int WIDTH;
    private int HEIGHT;
    private boolean fullScreen;
    private int windowPositionX;
    private int windowPositionY;
    private String GAME_TITLE;
    private Controller controller;
    private Model model;

    /**
     * Конструктор
     */
    public Renderer(int width, int height, boolean fullScreen, String gameTitle, int windowPositionX, int windowPositionY, Model model, Controller controller) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.fullScreen = fullScreen;
        this.GAME_TITLE = gameTitle;
        this.windowPositionX = windowPositionX;
        this.windowPositionY = windowPositionY;
        this.model = model;
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
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
            graphics.drawImage(
                    gameObject.getBufferedImage(),
                    (int) gameObject.getRenderX(),
                    (int) gameObject.getRenderY(),
                    gameObject.getImageWidth(),
                    gameObject.getImageHeight(),
                    null);
        });

        graphics.dispose();
        bufferStrategy.show();
    }


    /**
     * Цикл рендеринга изображения
     */
    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setUndecorated(fullScreen); // на весь экран
        jFrame.setVisible(true);
        jFrame.setTitle(GAME_TITLE);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(windowPositionX, windowPositionY, WIDTH, HEIGHT);

        //отрисовка
        jFrame.add(this);
        jFrame.addKeyListener(controller);

        int frames = 0;
        long timer = System.currentTimeMillis();

        while (true) {
            render();
            frames++;

            //вывод информации
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS " + frames);
                jFrame.setTitle(GAME_TITLE + "  |   FPS " + frames);
                frames = 0;
            }
        }
    }

}
