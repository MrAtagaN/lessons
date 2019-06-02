package com.plekhanov.game.gameObjects;

import com.plekhanov.game.ImageLoader;

import java.awt.image.BufferedImage;


public class PlayerShoot extends GameObject {

    private int liveCycle = 0;

    public PlayerShoot(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
    }

    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        liveCycle++;
        setImage();
    }

    private void setImage() {
        if ((liveCycle / 50 % 2) == 0) {
            bufferedImage = ImageLoader.getPlayerFireBallImage_1();
        } else {
            bufferedImage = ImageLoader.getPlayerFireBallImage_2();
        }
    }


}
