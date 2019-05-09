package game;




public class Game {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final double UPDATES = 100;
    public static final String GAME_TITLE = "My Game";


    /**
     * Start game
     */
    public static void main(String args[]) {
        new Renderer(WIDTH, HEIGHT, UPDATES, GAME_TITLE).run();
    }

}
