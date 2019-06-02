package com.plekhanov.game.gameLevels;

import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.GameObject;
import com.plekhanov.game.gameObjects.Player;
import com.plekhanov.game.gameObjects.background.BackGround;
import com.plekhanov.game.gameObjects.enemies.EnemyHusk;
import com.plekhanov.game.gameObjects.enemies.EnemyPestilence;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Level_3 {


    public static void load(int width, int height, Model model) {
        List<GameObject> gameObjects = new CopyOnWriteArrayList<>();
        model.setGameObjects(gameObjects);

        int y = -0; // смещение фона вверх
        int imageHeight = 0;  // растягивание фона
        //статический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel3Image1(), width + imageHeight, height + imageHeight, 1));  //background1
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel3Image2(), width, height + imageHeight, 2));  //background2


        //динамический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.1, 0, ImageLoader.getBackgroundLevel3Image3(), width, height + imageHeight, 4));  //background3
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.1, 0, ImageLoader.getBackgroundLevel3Image3(), width, height + imageHeight, 4));  //background3
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel3Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel3Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel3Image5(), width, height + imageHeight, 5));  //background5
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel3Image5(), width, height + imageHeight, 5));  //background5


        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel3Image6(), width, height + imageHeight, 6));  //background6
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel3Image6(), width, height + imageHeight, 6));  //background6
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image7(), width, height + imageHeight, 7));  //background7
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image7(), width, height + imageHeight, 7));  //background7
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image8(), width, height + imageHeight, 8));  //background8
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image8(), width, height + imageHeight, 8));  //background8
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image9(), width, height + imageHeight, 9));  //background9
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel3Image9(), width, height + imageHeight, 9));  //background9



        // Враги
        //gameObjects.add(new EnemyCarrion(2000, 965, -0.5, 0, ImageLoader.getEnemyCarrionImage(), 180, 120, 13, model)); //enemyCarrion
        gameObjects.add(new EnemyHusk(2200, 580, -0.3, 0, model)); //enemyHusk
        gameObjects.add(new EnemyPestilence(2200, 370, -0.7, 0, model)); //enemyPestilence


        // Игрок
        Player player = new Player(500, 960, 0, 0, 960, model);
        gameObjects.add(player);
        model.setPlayer(player);

        // Предметы


        Collections.sort(gameObjects);
    }
}
