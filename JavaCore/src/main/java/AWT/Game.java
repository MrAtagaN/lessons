package AWT;


import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;


public class Game {

   private static final int WIDTH = 800;
   private static final int HEIGHT = 600;
   private static final double AMOUNT_OF_TICKS = 60;


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
        jFrame.setTitle("Game");
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(0, 0, WIDTH, HEIGHT);

        //старт игровой логики
        Model model = new Model();
        new Thread(model).start();

        //отрисовка
        Renderer renderer = new Renderer(WIDTH, HEIGHT, model);
        jFrame.add(renderer);

        long lastTime = System.nanoTime();
        double ns = 1000_000_000 / AMOUNT_OF_TICKS;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                renderer.tick();
                updates++;
                delta--;
            }
            renderer.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, FPS " + frames);
                updates = 0;
                frames = 0;
            }
        }
    }

}
