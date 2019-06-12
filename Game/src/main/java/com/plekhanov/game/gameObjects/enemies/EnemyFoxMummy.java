package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;

public class EnemyFoxMummy extends Enemy {


    private static final int imageWidth = 400;
    private static final int imageHeight = 400;
    private static final int renderOrder = 12;
    private int walkCount = 0;
    private final int maxWalkCount = 300;
    private int shootingCount = 0;
    private int shootChardge = 0;
    private boolean mummyShootingPhase = false;  // мумия в фазе стрельбы


    public EnemyFoxMummy(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, ImageLoader.getEnemyFoxMummyWalkImage_1(), imageWidth, imageHeight, renderOrder, model);
        life = 3;
    }

    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        if (x <= -300) {   // обновляем муммию
            x = 2100;
            mummyShootingPhase = false;
            shootChardge = 0;
            shootingCount = 0;
        }

        incrementWalkCount();

        if(MummyInShootingZone() && mummyShootingPhase) {
            shoot();
        }

        if (!mummyShootingPhase) {
            speedX = -0.6;
        }

        setImage();
        checkPlayerShoot();

        //проверка столкновения c игроком
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.getPlayer().minusLife();
        }
    }

    private void setImage() {

        if (mummyShootingPhase) {
            bufferedImage = ImageLoader.getEnemyFoxMummyShoot_Image();
        } else {
            if (walkCount < 50) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_1();
            } else if (walkCount < 100) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_2();
            } else if (walkCount < 150) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_3();
            } else if (walkCount < 200) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_4();
            } else if (walkCount < 250) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_3(); //сетим картики в обратном направлении
            } else if (walkCount < 300) {
                bufferedImage = ImageLoader.getEnemyFoxMummyWalkImage_2();
            }
        }
    }

    private void incrementWalkCount() {


        if(walkCount >= maxWalkCount) {
            walkCount = 0;
            shootChardge++; // накапливаем заряд для стрельбы
            if (shootChardge == 3) {
                mummyShootingPhase = true;
            }
        }

        if(!mummyShootingPhase) {
            walkCount++;
        }


    }

    private void shoot() {

        speedX = -0.5;

        if (shootChardge == 3) {

            double shiftX = 60;  // смещение для того чтобы fire ball вылетал из посоха
            double shiftY = 20;

            double diffX = model.getPlayer().getX() - (x - shiftX);
            double diffY = model.getPlayer().getY() - (y - shiftY);

            double reduceSpeed = 1.5 / (Math.abs(diffX) + Math.abs(diffY));

            model.getGameObjects().add(new MummyFireBall(getX() - shiftX, getY() - shiftY, diffX * reduceSpeed, diffY * reduceSpeed, ImageLoader.getMummyFireBallImage_1(), 60, 60, 15, model));

            model.needToSortGameObjects();
        }

        shootChardge = 0;  // обнуляем зарядяды и муммия стоит на месте некоторое время

        shootingCount++;
        if (shootingCount > 300) {
            mummyShootingPhase = false;
            shootingCount = 0;
        }


    }

    /**
     * зона стрельбы для мумии
     */
    private boolean MummyInShootingZone() {
       return (x < 1900 && x > 100);
    }
}
