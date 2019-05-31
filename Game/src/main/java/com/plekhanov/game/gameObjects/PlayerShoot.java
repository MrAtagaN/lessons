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
    public void updateCoordinats() {
        super.updateCoordinats();

        liveCycle++;

        setImage();
    }

    private void setImage() {

//        if (liveCycle > Game.UPDATES * 0.05 && liveCycle <= Game.UPDATES * 0.15 ) {
//            bufferedImage = ImageLoader.getPlayerFireBallImage_2();
//        }
//
//        if (liveCycle > Game.UPDATES * 0.15 && liveCycle <= Game.UPDATES * 0.3 ) {
//            bufferedImage = ImageLoader.getPlayerFireBallImage_3();
//        }

        if (liveCycle > Game.UPDATES * 0 && blink() ) {
            bufferedImage = ImageLoader.getPlayerFireBallImage_4();
        }

        if (liveCycle > Game.UPDATES * 0 && !blink() ) {
            bufferedImage = ImageLoader.getPlayerFireBallImage_5();
        }
    }


    private boolean blink() {
        return (liveCycle / 50) % 2 == 0;
    }
}
