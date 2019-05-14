package com.plekhanov.game;


import java.io.IOException;

public class Game {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final boolean FULL_SCREEN = true;
    public static final int WINDOW_POSITION_X = 0;
    public static final int WINDOW_POSITION_Y = 0;
    public static final double UPDATES = 500;
    public static final String GAME_TITLE = "My Game";


    /**
     * Start game
     */
    public static void main(String[] args) throws IOException {

        Model model = new Model(UPDATES, WIDTH, HEIGHT);
        new Thread(model).start();

        new Renderer(
                WIDTH,
                HEIGHT,
                FULL_SCREEN,
                GAME_TITLE,
                WINDOW_POSITION_X,
                WINDOW_POSITION_Y,
                model).run();
    }


    //TODO
    // Сделать начало и конец игры
    // Добавить анимацию
    // Сделать поведение врагам
    // Добавить разных врагов
    // Добавить предменты


}
