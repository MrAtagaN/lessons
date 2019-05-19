package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

    protected double actionCountMax; //цикл действий
    protected double actionCount;    //счетчик цикла действий
    protected Model model;


    public Enemy(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
        this.model = model;
    }

    protected void incrementCount() {
        actionCount++;
        if (actionCount > actionCountMax) {
            actionCount = 0;
        }
    }
}
