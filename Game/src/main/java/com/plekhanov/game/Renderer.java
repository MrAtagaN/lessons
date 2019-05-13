package com.plekhanov.game;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 * Отрисовка изображения
 */
public class Renderer extends Canvas {

    private int WIDTH;
    private int HEIGHT;
    private int windowPositionWidth;
    private int windowPositionHeight;
    private String GAME_TITLE;
    private Controller controller;
    private Model model;

    /**
     * Конструктор
     */
    public Renderer(int width, int height, String gameTitle, int windowPositionWidth, int windowPositionHeight, Model model) throws IOException {
        this.WIDTH = width;
        this.HEIGHT = height;
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
            graphics.drawImage(gameObject.getBufferedImage(), (int)gameObject.getRenderX(), (int)gameObject.getRenderY(), gameObject.getImageWidth(), gameObject.getImageHeight(), null);
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


        int frames = 0;
        long timer = System.currentTimeMillis();

        while (true) {

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS " + frames);
                jFrame.setTitle(GAME_TITLE + " | FPS " + frames);
                frames = 0;
            }
        }
    }


//    /**
//     * Изменение игровой модели
//     */
//    private void updateModel() {
//        model.update();
//    }


}
