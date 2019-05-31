package com.plekhanov.game.gameObjects.background;

import com.plekhanov.game.Game;
import com.plekhanov.game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
    }

    @Override
    public void updateCoordinates() {
        super.updateCoordinates();
        if (x <= -Game.WIDTH/2) {
            x = Game.WIDTH*1.5;
        }
    }
}
