package game;

import game.gameObjects.*;
import game.gameObjects.background.*;
import game.gameObjects.enemies.Enemy;
import game.gameObjects.enemies.EnemyCarrion;
import game.gameObjects.enemies.EnemyHusk;
import game.gameObjects.enemies.EnemyPestilence;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Игровая логика
 */
public class Model {

    private boolean clash = false;
    private boolean needToSortGameObjects;

    private Player player;

    //список со всеми игровыми объектами
    private List<GameObject> gameObjects = new CopyOnWriteArrayList<>();

    /**
     * Конструктор, создание игровых объектов, задание начальных координат, скорости, высоты и ширины картинки
     */
    public Model(int width, int height) throws IOException {

        int y = -500; //выравнивание фона по высоте
        //статический фон
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, 0, 0, ImageLoader.getBackgroundImage1(), width, height - y, 1));  //background1
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, 0, 0, ImageLoader.getBackgroundImage2(), width, height - y, 2));  //background2
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, 0, 0, ImageLoader.getBackgroundImage3(), width, height - y, 3));  //background3
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, 0, 0, ImageLoader.getBackgroundImage4(), width, height - y, 4));  //background4

        //динамический фон
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, -0.1, 0, ImageLoader.getBackgroundImage5(), width, height - y, 5));  //background5
        gameObjects.add(new BackGround(width / 2 + width, (height + y) / 2, -0.1, 0, ImageLoader.getBackgroundImage5(), width, height - y, 5));  //background5
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, -0.2, 0, ImageLoader.getBackgroundImage6(), width, height - y, 6));  //background6
        gameObjects.add(new BackGround(width / 2 + width, (height + y) / 2, -0.2, 0, ImageLoader.getBackgroundImage6(), width, height - y, 6));  //background6
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, -0.3, 0, ImageLoader.getBackgroundImage7(), width, height - y, 7));  //background7
        gameObjects.add(new BackGround(width / 2 + width, (height + y) / 2, -0.3, 0, ImageLoader.getBackgroundImage7(), width, height - y, 7));  //background7
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, -0.3, 0, ImageLoader.getBackgroundImage8(), width, height - y, 8));  //background8
        gameObjects.add(new BackGround(width / 2 + width, (height + y) / 2, -0.3, 0, ImageLoader.getBackgroundImage8(), width, height - y, 8));  //background8
        gameObjects.add(new BackGround(width / 2, (height + y) / 2, -0.5, 0, ImageLoader.getBackgroundImage9(), width, height - y, 9));  //background9
        gameObjects.add(new BackGround(width / 2 + width, (height + y) / 2, -0.5, 0, ImageLoader.getBackgroundImage9(), width, height - y, 9));  //background9

        // Враги
        gameObjects.add(new EnemyCarrion(2000, 940, -0.5, 0, ImageLoader.getEnemyCarrionImage(), 180, 120, 13, this)); //enemyCarrion
        gameObjects.add(new EnemyHusk(2200, 580, -0.3, 0, ImageLoader.getEnemyHuskImage(), 180, 160, 12, this)); //enemyHusk
        gameObjects.add(new EnemyPestilence(2200, 370, -0.7, 0, ImageLoader.getEnemyPestilenceImage(), 120, 140, 14, this)); //enemyPestilence

        // Игрок
        Player player = new Player(500, 875, 0, 0, ImageLoader.getPlayerImage(), 150, 130, 100);
        gameObjects.add(player);
        this.player = player;

        Collections.sort(gameObjects);
    }


    public void needToSortGameObjects() {
        this.needToSortGameObjects = true;
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

    public void setClash(boolean clash) {
        this.clash = clash;
    }


    /**
     * Изменение координат игровых объектов
     */
    public void update() {
        //обновляем координаты у всех объектов
        gameObjects.forEach(GameObject::updateCoordinats);

        if (needToSortGameObjects) {
            Collections.sort(gameObjects);
            needToSortGameObjects = false;
        }

    }

}
