package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.PlayerShoot;

import java.awt.image.BufferedImage;

public class EnemyPestilence extends Enemy {

    private static final BufferedImage bufferedImage = ImageLoader.getEnemyPestilenceImage();
    private static final int imageWidth = 120;
    private static final int imageHeight = 140;
    private static final int renderOrder = 14;


    public EnemyPestilence(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        actionCountMax = Game.UPDATES * 2;
        life = 3;
    }


    @Override
    public void updateCoordinates() {
        super.updateCoordinates();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 700 + 90));
        }

        //поведение
        if (actionCount < Game.UPDATES) {
            speedY = -0.2;
        } else {
            speedY = 0.2;
        }
        incrementCount();

        checkPlayerShoot();

        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }
    }


}
