package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Model;

import java.awt.image.BufferedImage;

public class FireBall extends Enemy {
    public FireBall(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
    }


    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        //проверка столкновения с игроком
        if (Math.abs(model.getPlayer().getX() - getX()) < 50 && Math.abs(model.getPlayer().getY() - getY()) < 50) {
            model.getPlayer().minusLife();
        }
    }
}
