package game;


import java.io.IOException;

public class Game {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int WINDOW_POSITION_WIDTH = 0;
    public static final int WINDOW_POSITION_HEIGHT = 0;

    public static final double UPDATES = 500;
    public static final String GAME_TITLE = "My Game";


    /**
     * Start game
     */
    public static void main(String args[]) throws IOException {
        Model model = new Model(WIDTH, HEIGHT);
        new Renderer(
                WIDTH,
                HEIGHT,
                UPDATES,
                GAME_TITLE,
                WINDOW_POSITION_WIDTH,
                WINDOW_POSITION_HEIGHT,
                model).run();
    }

}
