package com.plekhanov.game;

import com.plekhanov.game.gameLevels.Level_1;
import com.plekhanov.game.gameObjects.*;
import com.plekhanov.game.gameObjects.background.*;
import com.plekhanov.game.gameObjects.enemies.EnemyCarrion;
import com.plekhanov.game.gameObjects.enemies.EnemyHusk;
import com.plekhanov.game.gameObjects.enemies.EnemyPestilence;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Игровая логика
 */
public class Model implements Runnable {

    private volatile boolean clash = false;
    private volatile boolean needToSortGameObjects;
    private double UPDATES;

    private int width;
    private int height;

    private volatile Player player;
    //список со всеми игровыми объектами
    private volatile List<GameObject> gameObjects = new CopyOnWriteArrayList<>();

    /**
     * Конструктор, создание игровых объектов, задание начальных координат, скорости, высоты и ширины картинки
     */
    public Model(double updates, int width, int height) throws IOException {
        this.UPDATES = updates;
        this.width = width;
        this.height = height;

        // Игрок
        Player player = new Player(500, 900, 0, 0, ImageLoader.getPlayerImage(), 150, 130, 100, this);
        gameObjects.add(player);
        this.player = player;

        loadLevel(1);
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
     * Цикл изменений координат игровых объектов
     */
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000_000_000 / UPDATES;
        double delta = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                updates++;
                delta--;

                if (isClash()) { //TODO переделать
                    break;
                }
                //обновляем координаты у всех объектов
                updateModel();
            }

            //вывод информации
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Updates " + updates);
                updates = 0;
            }
        }
    }


    /**
     * Изменение игровой модели
     */
    private void updateModel() {
        gameObjects.forEach(GameObject::updateCoordinats);

        if (needToSortGameObjects) {
            Collections.sort(gameObjects);
            needToSortGameObjects = false;
        }
    }


    /**
     * Загрузка уровня
     */
    public void loadLevel(int levelNumber) throws IOException {
        switch (levelNumber) {
            case 1:
                gameObjects = new Level_1(width, height, this).getGameObjects();
                break;
            case 2:

                break;
            default:
                throw new RuntimeException("No level");
        }
    }

}
