package game;

import game.gameObjects.*;
import game.gameObjects.background.*;
import game.gameObjects.enemies.Enemy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Игровая логика
 */
public class Model {


    private boolean clash = false;

    private Player player;


    private List<GameObject> gameObjects = new ArrayList<>();

    /**
     * Конструктор, создание игровых объектов, задание начальных координат
     */
    public Model(int width, int height) throws IOException {

        int y = -500; //выравнивание фона по высоте
        //статический фон
        File backgroundImageFile1 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0010_1.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile1), width, height - y));  //background1
        File backgroundImageFile2 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0009_2.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile2), width, height - y));  //background2
        File backgroundImageFile3 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0008_3.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile3), width, height - y));  //background3
        File backgroundImageFile4 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0006_4.png");
        gameObjects.add(new BackGround(0,y,0,0, ImageIO.read(backgroundImageFile4), width, height - y));  //background4

        //динамический фон
        File backgroundImageFile5 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0005_5.png");
        gameObjects.add(new BackGround(0,y,-0.1,0, ImageIO.read(backgroundImageFile5), width, height - y));  //background5
        gameObjects.add(new BackGround(width,y,-0.1,0, ImageIO.read(backgroundImageFile5), width, height - y));  //background5

        File backgroundImageFile6 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0003_6.png");
        gameObjects.add(new BackGround(0,y,-0.2,0, ImageIO.read(backgroundImageFile6), width, height - y));  //background6
        gameObjects.add(new BackGround(width,y,-0.2,0, ImageIO.read(backgroundImageFile6), width, height - y));  //background6

        File backgroundImageFile7 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0002_7.png");
        gameObjects.add(new BackGround(0,y,-0.3,0, ImageIO.read(backgroundImageFile7), width, height - y));  //background7
        gameObjects.add(new BackGround(width,y,-0.3,0, ImageIO.read(backgroundImageFile7), width, height - y));  //background7

        File backgroundImageFile8 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0001_8.png");
        gameObjects.add(new BackGround(0,y,-0.3,0, ImageIO.read(backgroundImageFile8), width, height - y));  //background8
        gameObjects.add(new BackGround(width,y,-0.3,0, ImageIO.read(backgroundImageFile8), width, height - y));  //background8

        File backgroundImageFile9 = new File("Game\\src\\main\\resources\\images\\background\\Layer_0000_9.png");
        gameObjects.add(new BackGround(0,y,-0.5,0, ImageIO.read(backgroundImageFile9), width, height - y));  //background9
        gameObjects.add(new BackGround(width,y,-0.5,0, ImageIO.read(backgroundImageFile9), width, height - y));  //background9
        // враги
        File enemyCarrionImageFile = new File("Game\\src\\main\\resources\\images\\enemies\\EnemyCarrion.png");
        gameObjects.add( new EnemyCarrion(2000,880,-0.5,0, ImageIO.read(enemyCarrionImageFile), 180, 120)); //enemyCarrion
        File enemyHuskImageFile = new File("Game\\src\\main\\resources\\images\\enemies\\EnemyHusk.png");
        gameObjects.add( new EnemyHusk(2200,500,-0.3,0, ImageIO.read(enemyHuskImageFile), 180, 160)); //enemyHusk
        File enemyPestilenceImageFile = new File("Game\\src\\main\\resources\\images\\enemies\\EnemyPestilence.png");
        gameObjects.add(new EnemyPestilence(2200, 300,-0.7, 0, ImageIO.read(enemyPestilenceImageFile), 120, 140));


        File playerImageFile = new File("Game\\src\\main\\resources\\images\\Player2.png");
        Player player = new Player(500,810,-1,0, ImageIO.read(playerImageFile), 150, 130); //player
        gameObjects.add(player);
        this.player = player;

    }


    /**
     * Изменение координат игровых объектов
     */
    public void update() {
        //обновляем координаты у всех объектов
        gameObjects.forEach(GameObject::updateCoordinats);
        checkClash();
    }

    /**
     * Проверка столкновений
     */
    public void checkClash() {
         gameObjects.forEach(gameObject -> {if (gameObject instanceof Enemy) {
             if (Math.abs(player.getX() - gameObject.getX()) < 80 && Math.abs(player.getY() - gameObject.getY()) < 80 ) {
                 clash = true;
             }
         } });
    }



    public Player getPlayer() {
        return player;
    }


    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public boolean isClash() {
        return clash;
    }

}
