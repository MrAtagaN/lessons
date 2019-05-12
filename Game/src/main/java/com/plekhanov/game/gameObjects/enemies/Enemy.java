package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

    protected double countMax; //цикл действий
    protected double count;

    protected Model model;


    public Enemy(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
        this.model = model;
    }

    protected void incrementCount() {
        count++;
        if (count > countMax) {
            count = 0;
        }
    }
}
