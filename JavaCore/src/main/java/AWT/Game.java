package AWT;


import javax.swing.*;


public class Game {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    public static final double UPDATES = 100;
    public static final String GAME_TITLE = "My Game";


    /**
     * Start game
     */
    public static void main(String args[]) {
        new Game().run();
    }


    /**
     * Главный игровой цикл
     */
    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle(GAME_TITLE);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(0, 0, WIDTH, HEIGHT);

        //старт игровой логики
        Model model = new Model(WIDTH, HEIGHT);
        new Thread(model).start();

        //отрисовка
        Renderer renderer = new Renderer(WIDTH, HEIGHT, model);
        jFrame.add(renderer);


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
                renderer.update();
                updates++;
                delta--;
            }
            renderer.render();
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

}
