package com.plekhanov.game.gameLevels;

import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.GameObject;
import com.plekhanov.game.gameObjects.Player;
import com.plekhanov.game.gameObjects.background.BackGround;
import com.plekhanov.game.gameObjects.enemies.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Level_2 {

    public static void load(int width, int height, Model model) {
        List<GameObject> gameObjects = new CopyOnWriteArrayList<>();
        model.setGameObjects(gameObjects);

        int y = -0; // смещение фона вверх
        int imageHeight = 0;  // растягивание фона
        //статический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel2Image1(), width + imageHeight, height + imageHeight, 1));  //background1
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel2Image2(), width, height + imageHeight, 2));  //background2


        //динамический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image3(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image3(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel2Image5(), width, height + imageHeight, 5));  //background5
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.5, 0, ImageLoader.getBackgroundLevel2Image5(), width, height + imageHeight, 5));  //background5


        // Враги
        //gameObjects.add(new EnemyCarrion(2000, 965, -0.5, 0, model)); //enemyCarrion
      //  gameObjects.add(new EnemyHusk(2200, 580, -0.3, 0, model)); //enemyHusk
       // gameObjects.add(new EnemyPestilence(2200, 370, -0.7, 0, model)); //enemyPestilence
        gameObjects.add(new EnemyMummyZombie(2200, 500, -0.7, 0, model)); //enemyMummyZombie
        gameObjects.add(new EnemyOgre(2200, 900, -0.75, 0, model)); //enemyOgre
        gameObjects.add(new EnemyFoxMummy(2500, 900, -0.6, 0, model)); // enemyFoxMummy

        // Игрок
        Player player = new Player(500, 900, 0, 0, 900, model);
        gameObjects.add(player);
        model.setPlayer(player);

        // Предметы


        Collections.sort(gameObjects);
    }
}
