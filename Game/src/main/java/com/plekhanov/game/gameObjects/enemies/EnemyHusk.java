package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;


import java.awt.image.BufferedImage;

public class EnemyHusk extends Enemy {

    private boolean alreadyShooted = false;

    private BufferedImage HuskShootImage;

    public EnemyHusk(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        HuskShootImage = ImageLoader.getEnemyHuskShootImage();
        actionCountMax = Game.UPDATES * 2;
    }


    @Override
    public void updateCoordinats() {
        //поведение
        if (actionCount < Game.UPDATES) {
            speedY = -0.05;
        } else {
            speedY = 0.05;
        }

        super.updateCoordinats();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 700 + 80));

            // убираем из модели fireBall'ы
            model.getGameObjects().forEach(gameObject -> {
                if (gameObject instanceof FireBall) {
                    model.getGameObjects().remove(gameObject);
                }
            });
        }

        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }
        // летим и стреляем
        shoot();
        incrementCount();

    }


    private void shoot() {
        if (x < 1800 && x > 0 && actionCount > Game.UPDATES * 1 && !alreadyShooted) {

            alreadyShooted = true;

            double diffX = model.getPlayer().getX() - x;
            double diffY = model.getPlayer().getY() - y;

            double reduceSpeed = 1 / (Math.abs(diffX) + Math.abs(diffY));

            model.getGameObjects().add(new FireBall(getX(), getY(), diffX * reduceSpeed, diffY * reduceSpeed, ImageLoader.getFireBallImage(), 60, 60, 11, model));

            model.needToSortGameObjects();
        }
        if (actionCount < Game.UPDATES * 1) {
            alreadyShooted = false;
        }
    }


    @Override
    public BufferedImage getBufferedImage() {

        if (actionCount > Game.UPDATES * 1 && actionCount < Game.UPDATES * 1.5 && x < 1800 && x > 0 && alreadyShooted) {
            return HuskShootImage;
        }
        return super.getBufferedImage();
    }
}
