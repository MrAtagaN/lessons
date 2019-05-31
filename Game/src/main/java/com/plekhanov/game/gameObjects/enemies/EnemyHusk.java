package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.PlayerShoot;


import java.awt.image.BufferedImage;

public class EnemyHusk extends Enemy {

    private boolean alreadyShooted = false;

    private BufferedImage HuskShootImage;

    public EnemyHusk(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        HuskShootImage = ImageLoader.getEnemyHuskShootImage();
        actionCountMax = Game.UPDATES * 2;
        life = 3;
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
            y = ((int) (Math.random() * 600 + 180));

            // убираем из модели fireBall'ы
            model.getGameObjects().forEach(gameObject -> {
                if (gameObject instanceof FireBall) {
                    model.getGameObjects().remove(gameObject);
                }
            });
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
        if (huskInActionZone() || actionCount > 0) {
            incrementCount();
        }

    }

    /**
     * проверка столкновения c выстрелом игрока
     */
    private void checkPlayerShoot() {
        model.getGameObjects().forEach(gameObject -> {
            if (gameObject instanceof PlayerShoot) {
                if (Math.abs(gameObject.getX() - getX()) < 80 && Math.abs(gameObject.getY() - getY()) < 80) {
                    life--;
                    model.getGameObjects().remove(gameObject);
                    if (life <= 0) {
                        model.getGameObjects().remove(this);
                    }
                }
            }
        });
    }


    private void shoot() {
        if (huskInActionZone() && actionCount > Game.UPDATES * 1 && !alreadyShooted) {

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

        if (actionCount > Game.UPDATES * 1 && actionCount < Game.UPDATES * 1.5 && huskInActionZone()) {
            return HuskShootImage;
        }
        return super.getBufferedImage();
    }

    /**
     * зона активного действия Husk'а
     */
    private boolean huskInActionZone() {
        return x > 0 && x < 1800;
    }
}
