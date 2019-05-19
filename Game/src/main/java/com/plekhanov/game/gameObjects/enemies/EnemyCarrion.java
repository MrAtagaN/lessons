package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;

import java.awt.image.BufferedImage;

public class EnemyCarrion extends Enemy {

   private BufferedImage hungryImage;


    public EnemyCarrion(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        actionCountMax = Game.UPDATES * 1;
        hungryImage = ImageLoader.getHungryCarrion();
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
        }
        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }

        //поведение
        if (actionCount < Game.UPDATES * 0.6) {
            speedX = -1.5;
        } else {
            speedX = -0.5;
        }
        incrementCount();
    }

    @Override
    public BufferedImage getBufferedImage() {

        if ( actionCount < Game.UPDATES / 2) {
            return hungryImage;
        }
        return super.getBufferedImage();
    }
}
