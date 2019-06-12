package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;



public class EnemyMummyZombie extends Enemy {

    private static final int imageWidth = 220;
    private static final int imageHeight = 220;
    private static final int renderOrder = 14;


    public EnemyMummyZombie(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, ImageLoader.getEnemyMummyZombieLeftImage(), imageWidth, imageHeight, renderOrder, model);
        life = 3;
        actionCountMax = Game.UPDATES * 5;
    }

    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        checkPlayerShoot();
        moveToPlayer();
        incrementCount();


        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }
    }


    private void moveToPlayer() {
        double diffX = model.getPlayer().getX() - x;
        double diffY = model.getPlayer().getY() - y;

        double coefficient ;

        if (zombieEnrage()) {
            coefficient = 1;  // ускоряем мумию
        } else {
            coefficient = 0.8;
        }

        double reduceSpeed = coefficient / (Math.abs(diffX) + Math.abs(diffY));

        speedX = diffX * reduceSpeed;
        speedY = diffY * reduceSpeed;

        if(diffX < 0 && zombieEnrage()) {
            if((int)actionCount / 100 % 2 == 0) {
                bufferedImage = ImageLoader.getEnemyMummyZombieRageLeftImage_1();
            } else {
                bufferedImage = ImageLoader.getEnemyMummyZombieRageLeftImage_2();
            }

        } else if(diffX < 0) {
            bufferedImage = ImageLoader.getEnemyMummyZombieLeftImage();
        } else if (diffX > 0 && zombieEnrage()) {

            if ((int)actionCount / 100 % 2 == 0) {
                bufferedImage = ImageLoader.getEnemyMummyZombieRageRightImage_1();
            } else {
                bufferedImage = ImageLoader.getEnemyMummyZombieRageRightImage_2();
            }

        } else {
            bufferedImage = ImageLoader.getEnemyMummyZombieRightImage();
        }
    }

    private boolean zombieEnrage() {
        if (actionCount > Game.UPDATES * 2){
            return true;
        } else {
            return false;
        }
    }

}
