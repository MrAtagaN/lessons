package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;


import java.awt.image.BufferedImage;

public class EnemyHusk extends Enemy {

    private static final BufferedImage bufferedImage = ImageLoader.getEnemyHuskImage();
    private static final BufferedImage huskShootImage = ImageLoader.getEnemyHuskShootImage();
    private static final int imageWidth = 180;
    private static final int imageHeight = 160;
    private static final int renderOrder = 12;

    private boolean alreadyShooted = false;


    public EnemyHusk(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        actionCountMax = Game.UPDATES * 2;
        life = 3;
    }


    @Override
    public void updateCoordinates() {
        //поведение
        if (actionCount < Game.UPDATES) {
            speedY = -0.05;
        } else {
            speedY = 0.05;
        }

        super.updateCoordinates();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 600 + 180));

            // убираем из модели fireBall'ы
//            model.getGameObjects().forEach(gameObject -> {
//                if (gameObject instanceof FireBall) {
//                    model.getGameObjects().remove(gameObject);
//                }
//            });
        }

        checkPlayerShoot();

        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }
        // летим и стреляем
        shoot();

        // увеличиваем счетчик действие если Husk в активной зоне или довожим счетчик до 0 если Husk пролетел активную
        // зону чтобы когда он окажется снова в активной зоне счетчик считал от 0
        if (huskInShootingZone() || actionCount > 0) {
            incrementCount();
        }

    }


    private void shoot() {
        if (huskInShootingZone() && actionCount > Game.UPDATES * 1 && !alreadyShooted) {

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

        if (actionCount > Game.UPDATES * 1 && actionCount < Game.UPDATES * 1.5 && huskInShootingZone()) {
            return huskShootImage;
        }
        return super.getBufferedImage();
    }

    /**
     * зона стрельбы для  Husk'а
     */
    private boolean huskInShootingZone() {
        return x > 0 && x < 1800;
    }
}
