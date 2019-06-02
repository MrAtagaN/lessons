package com.plekhanov.game.gameObjects;

import com.plekhanov.game.Game;
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

        if  (blink()) {
            bufferedImage = ImageLoader.getPlayerFireBallImage_1();
        }

        if (!blink()) {
            bufferedImage = ImageLoader.getPlayerFireBallImage_2();
        }
    }


    private boolean blink() {
        return (liveCycle / 50) % 2 == 0;
    }
}
