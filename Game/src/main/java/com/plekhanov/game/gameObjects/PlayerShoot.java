package com.plekhanov.game.gameObjects;

import java.awt.image.BufferedImage;


public class PlayerShoot extends GameObject {

    public PlayerShoot(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
    }
}
