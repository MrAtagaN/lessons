package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.PlayerShoot;

import java.awt.image.BufferedImage;

public class EnemyOgre extends Enemy {


    private static final int imageWidth = 400;
    private static final int imageHeight = 400;
    private static final int renderOrder = 13;

    private static final BufferedImage walk1 = ImageLoader.getEnemyOgreWalkImage_1();
    private static final BufferedImage walk2 = ImageLoader.getEnemyOgreWalkImage_2();
    private static final BufferedImage walk3 = ImageLoader.getEnemyOgreWalkImage_3();
    private static final BufferedImage walk4 = ImageLoader.getEnemyOgreWalkImage_4();
    private static final BufferedImage walk5 = ImageLoader.getEnemyOgreWalkImage_5();
    private static final BufferedImage walk6 = ImageLoader.getEnemyOgreWalkImage_6();
    private static final BufferedImage walk7 = ImageLoader.getEnemyOgreWalkImage_7();

    public EnemyOgre(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, walk1, imageWidth, imageHeight, renderOrder, model);
        actionCountMax = 300;
        life = 3;
    }


    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }

        checkPlayerShoot();
        changeImage();


        incrementCount();
    }


    private void changeImage() {
         if ( 0 <= actionCount && actionCount < 50 && bufferedImage != walk1) {
             this.bufferedImage = walk1;
         }
         if (50 <= actionCount && actionCount < 100 && bufferedImage != walk2) {
             this.bufferedImage = walk2;
         }
        if (100 <= actionCount && actionCount < 150 && bufferedImage != walk3) {
            this.bufferedImage = walk3;
        }
        if (150 <= actionCount && actionCount < 200 && bufferedImage != walk4) {
            this.bufferedImage = walk4;
        }
//        if (600 <= actionCount && actionCount < 750 && bufferedImage != walk5) { //картинка почти не отличается от четвертой
//            this.bufferedImage = walk5;
//        }
        if (200 <= actionCount && actionCount < 250 && bufferedImage != walk6) {
            this.bufferedImage = walk6;
        }
        if (250 <= actionCount && actionCount < 300 && bufferedImage != walk7) {
            this.bufferedImage = walk7;
        }




    }



    @Override
    protected void checkPlayerShoot() {
        model.getGameObjects().forEach(gameObject -> {
            if (gameObject instanceof PlayerShoot) {
                if (Math.abs(gameObject.getX() - getX()) < 40 && Math.abs(gameObject.getY() - getY()) < 100) {
                    life--;
                    model.getGameObjects().remove(gameObject);
                    if (life <= 0) {
                        model.getGameObjects().remove(this);
                    }
                }
            }
        });
    }
}
