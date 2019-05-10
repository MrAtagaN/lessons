package game;

import game.gameObjects.EnemyCarrion;
import game.gameObjects.EnemyHusk;
import game.gameObjects.EnemyPestilence;
import game.gameObjects.background.*;
import game.gameObjects.Player;

import java.io.IOException;

/**
 * Игровая логика
 */
public class Model implements Runnable {

    private int height;
    private int width;

    private Player player;
    private EnemyCarrion enemyCarrion;
    private EnemyHusk enemyHusk;
    private EnemyPestilence enemyPestilence;

    private Background9 background9;
    private Background8 background8;
    private Background7 background7;
    private Background6 background6;
    private Background5 background5;

    /**
     * Конструктор, создание игровых объектов, задание начальных координат
     */
    public Model(int width, int height) throws IOException {
        this.height = height;
        this.width = width;

        //создание игровых объектов, задание начальных координат
        this.player = new Player(500, 810, -1, 0);
        this.enemyCarrion = new EnemyCarrion(2000, 880, -0.5, 0);
        this.enemyHusk = new EnemyHusk(2200, 500, -0.3, 0);
        this.enemyPestilence = new EnemyPestilence(2200, 300, -0.7, 0);

        //int y = -500; //выравнивание фона по высоте
        this.background9 = new Background9(0, 0, -0.5, 0);
        this.background8 = new Background8(0, 0, -0.3, 0);
        this.background7 = new Background7(0, 0, -0.3, 0);
        this.background6 = new Background6(0, 0, -0.2, 0);
        this.background5 = new Background5(0, 0, -0.1, 0);
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

    public EnemyCarrion getEnemyCarrion() {
        return enemyCarrion;
    }

    public EnemyHusk getEnemyHusk() {
        return enemyHusk;
    }

    public EnemyPestilence getEnemyPestilence() {
        return enemyPestilence;
    }

    /**
     * Изменение координат игровых объектов
     */
    @Override
    public void run() {

        drawBackground();
        player.updateCoordinats();
        enemyCarrion.updateCoordinats();
        enemyHusk.updateCoordinats();
        enemyPestilence.updateCoordinats();

        if (enemyPestilence.getX() <= -300) {
            enemyPestilence.setX((int) (Math.random() * 500 + 2000));
            enemyPestilence.setY((int) (Math.random() * 700 + 20));
        }

        if (enemyCarrion.getX() <= -300) {
            enemyCarrion.setX((int) (Math.random() * 500 + 2000));
        }

        if (enemyHusk.getX() <= -300) {
            enemyHusk.setX((int) (Math.random() * 500 + 2000));
            enemyHusk.setY((int) (Math.random() * 700 + 20));
        }

//        if (player.getX() >= 1500) {
//            player.setSpeedX(-1);
//        }
//        if (player.getX() <= 300) {
//            player.setSpeedX(1);
//        }


    }


    /**
     * Изменение координат фона
     */
    private void drawBackground() {
        background9.updateCoordinats();
        if (Math.abs(background9.getX()) >= width) {
            background9.setX(0);
        }

        background8.updateCoordinats();
        if (Math.abs(background8.getX()) >= width) {
            background8.setX(0);
        }

        background7.updateCoordinats();
        if (Math.abs(background7.getX()) >= width) {
            background7.setX(0);
        }

        background6.updateCoordinats();
        if (Math.abs(background6.getX()) >= width) {
            background6.setX(0);
        }

        background5.updateCoordinats();
        if (Math.abs(background5.getX()) >= width) {
            background5.setX(0);
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
