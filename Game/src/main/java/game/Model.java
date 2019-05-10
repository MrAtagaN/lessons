package game;

import game.gameObjects.*;
import game.gameObjects.background.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Игровая логика
 */
public class Model {

    private int width;
    private int height;

    private Player player;
    private EnemyCarrion enemyCarrion;
    private EnemyHusk enemyHusk;
    private EnemyPestilence enemyPestilence;

    private Background9 background9;
    private Background8 background8;
    private Background7 background7;
    private Background6 background6;
    private Background5 background5;

    private List<GameObject> gameObjects = new ArrayList<>();

    /**
     * Конструктор, создание игровых объектов, задание начальных координат
     */
    public Model(int width, int height) throws IOException {
        this.height = height;
        this.width = width;

        //создание игровых объектов, задание начальных координат
        //this.player = new Player(500, 810, -1, 0);
        this.enemyCarrion = new EnemyCarrion(2000, 880, -0.5, 0);
        this.enemyHusk = new EnemyHusk(2200, 500, -0.3, 0);
        this.enemyPestilence = new EnemyPestilence(2200, 300, -0.7, 0);

        //int y = -500; //выравнивание фона по высоте
        this.background9 = new Background9(0, 0, -0.5, 0);
        this.background8 = new Background8(0, 0, -0.3, 0);
        this.background7 = new Background7(0, 0, -0.3, 0);
        this.background6 = new Background6(0, 0, -0.2, 0);
        this.background5 = new Background5(0, 0, -0.1, 0);

        int y = -500; //выравнивание фона по высоте

        File backgroundImageFile1 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0010_1.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile1), width, height - y));  //background1
        File backgroundImageFile2 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0009_2.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile2), width, height - y));  //background2
        File backgroundImageFile3 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0008_3.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile3), width, height - y));  //background3
        File backgroundImageFile4 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0006_4.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile4), width, height - y));  //background4

        File backgroundImageFile5 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0005_5.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile5), width, height - y));  //background5
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile5), width, height - y));  //background5

        File backgroundImageFile6 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0003_6.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile6), width, height - y));  //background6
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile6), width, height - y));  //background6

        File backgroundImageFile7 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0002_7.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile7), width, height - y));  //background7
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile7), width, height - y));  //background7

        File backgroundImageFile8 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0001_8.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile8), width, height - y));  //background8
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile8), width, height - y));  //background8

        File backgroundImageFile9 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0000_9.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile9), width, height - y));  //background9
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile9), width, height - y));  //background9



        File playerImageFile = new File("Game\\src\\main\\resources\\images\\Player2.png");
        Player player = new Player(500,810,-1,0, ImageIO.read(playerImageFile), 150, 130);
        gameObjects.add(player);  //player
        this.player = player;

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

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Изменение координат игровых объектов
     */
    public void update() {

        drawBackground();
       // player.updateCoordinats();
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

        //обновляем координаты у всех объектов
        gameObjects.forEach(gameObject -> {
            gameObject.updateCoordinats();

            if (gameObject instanceof BackGround) {
                if (Math.abs(gameObject.getX()) >= width) {
                    gameObject.setX(width);
                }
            }
        });

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
