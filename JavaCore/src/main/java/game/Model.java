package game;

import game.GameObjects.background.*;
import game.GameObjects.Player;

/**
 * Игровая логика
 */
public class Model implements Runnable {

    private int height;
    private int width;
    private int count = 1;

    private Player player;
    private Background9 background9;
    private Background8 background8;
    private Background7 background7;
    private Background6 background6;
    private Background5 background5;

    /**
     * Конструктор, инициализация игровых объектов
     */
    public Model(int width, int height) {
        this.height = height;
        this.width = width;

        this.player = new Player(2, 0,500, 810);
        this.background9 = new Background9(0);
        this.background8 = new Background8(0);
        this.background7 = new Background7(0);
        this.background6 = new Background6(0);
        this.background5 = new Background5(0);
    }

    public Background9 getBackground9() {
        return background9;
    }

    public Background8 getBackground8() {
        return background8;
    }

    public Background7 getBackground7() {
        return background7;
    }

    public Background6 getBackground6() {
        return background6;
    }

    public Background5 getBackground5() {
        return background5;
    }

    public Player getPlayer() {
        return player;
    }


    /**
     * Изменение игровой модели
     */
    @Override
    public void run() {

        drawBackground();
        player.updateCoordinats();

        if (player.getX() >= 1500) {
            player.setSpeedX(-1);
        }
        if (player.getX() <= 300) {
            player.setSpeedX(1);
        }


    }


    private void drawBackground() {
        if (count % 1 == 0) {
            background9.changeX((-1));
            if (Math.abs(background9.getX()) >= width) {
                background9.setX(0);
            }
        }

        if (count % 2 == 0) {
            background8.changeX(-1);
            if (Math.abs(background8.getX()) >= width) {
                background8.setX(0);
            }
        }

        if (count % 2 == 0) {
            background7.changeX(-1);
            if (Math.abs(background7.getX()) >= width) {
                background7.setX(0);
            }
        }

        if (count % 3 == 0) {
            background6.changeX(-1);
            if (Math.abs(background6.getX()) >= width) {
                background6.setX(0);
            }
        }

        if (count % 4 == 0) {
            background5.changeX(-1);
            if (Math.abs(background5.getX()) >= width) {
                background5.setX(0);
            }
        }


        count++;
        if (count > 100) {
            count = 1;
        }
    }


    //     for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                //фон
//                pixels[(x + y * width)*3]  = 0; //красный цвет пикселя
//                pixels[(x + y * width)*3 + 1] = 0; //зеленый цвет пикселя
//                pixels[(x + y * width)*3 + 2] = 0; //синий цвет пикселя
//            }
//        }


}
