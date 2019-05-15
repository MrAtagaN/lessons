package com.plekhanov.game;



public class Game {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final boolean FULL_SCREEN = true;
    public static final int WINDOW_POSITION_X = 0;
    public static final int WINDOW_POSITION_Y = 0;
    public static final double UPDATES = 500;
    public static final String GAME_TITLE = "Horsemen";


    /**
     * Start game
     */
    public static void main(String[] args) {

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
