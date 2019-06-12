package com.plekhanov.game.gameObjects.enemies;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.PlayerShoot;

import java.awt.image.BufferedImage;

public class EnemyOgre extends Enemy {


    private static final int imageWidth = 500;
    private static final int imageHeight = 500;
    private static final int renderOrder = 13;

    private static final BufferedImage walk1 = ImageLoader.getEnemyOgreWalkImage_1();
    private static final BufferedImage walk2 = ImageLoader.getEnemyOgreWalkImage_2();
    private static final BufferedImage walk3 = ImageLoader.getEnemyOgreWalkImage_3();
    private static final BufferedImage walk4 = ImageLoader.getEnemyOgreWalkImage_4();
    private static final BufferedImage walk5 = ImageLoader.getEnemyOgreWalkImage_5();
    private static final BufferedImage walk6 = ImageLoader.getEnemyOgreWalkImage_6();
    private static final BufferedImage walk7 = ImageLoader.getEnemyOgreWalkImage_7();

    private static final BufferedImage jump1 = ImageLoader.getEnemyOgreJumpImage_1();
    private static final BufferedImage jump2 = ImageLoader.getEnemyOgreJumpImage_2();
    private static final BufferedImage jump3 = ImageLoader.getEnemyOgreJumpImage_3();
    private static final BufferedImage jump4 = ImageLoader.getEnemyOgreJumpImage_4();
    private static final BufferedImage jump5 = ImageLoader.getEnemyOgreJumpImage_5();
    private static final BufferedImage jump6 = ImageLoader.getEnemyOgreJumpImage_6();
    private static final BufferedImage jump7 = ImageLoader.getEnemyOgreJumpImage_7();

    private boolean walk = true;
    private boolean jump = false;

    private int walkCount;
    private int jumpCount;
    private int maxJumpCount = 500;
    private int maxWalkCount = 300;
    private static final double JUMP_UP = -1.6;
    private static final double GRAVITY = 3;
    private double MIN_Y;


    public EnemyOgre(double x, double y, double speedX, double speedY, Model model) {
        super(x, y, speedX, speedY, walk1, imageWidth, imageHeight, renderOrder, model);
        MIN_Y = y;
        actionCountMax = 300;
        life = 3;
    }


    @Override
    public void updateCoordinates() {
        super.updateCoordinates();

        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 160 && Math.abs(model.getPlayer().getY() - getY()) < 160) {
            model.getPlayer().minusLife();
        }

        if (x - model.getPlayer().getX() <= 400 && x - model.getPlayer().getX() >= 0 && y - model.getPlayer().getY() >= 100) {
            if (!jump) {
                jumpUp();
            }
        }

        speedY += GRAVITY / 500;
        if (y > MIN_Y) {
            speedY = 0;
            y = MIN_Y;
            jump = false;
            walk = true;
        }

        checkPlayerShoot();
        changeImage();


        incrementCount();
    }


    private void changeImage() {
        if (walkCount < 50  && walk) {
            this.bufferedImage = walk1;
        }
        else if (walkCount < 100 && walk) {
            this.bufferedImage = walk2;
        }
        else if (walkCount < 150 && walk) {
            this.bufferedImage = walk3;
        }
        else if (walkCount < 200 && walk) {
            this.bufferedImage = walk4;
        }
        else if (walkCount < 250 && walk) {
            this.bufferedImage = walk6; //пятая картинка почти не отличается от четвертой
        }
        else if (walkCount < 300  && walk) {
            this.bufferedImage = walk7;
        }


        if (jumpCount < 50 && jump) {
            this.bufferedImage = jump1;
        }
        else if (jumpCount < 100 && jump) {
            this.bufferedImage = jump2;
        }
        else if (jumpCount < 150 && jump) {
            this.bufferedImage = jump3;
        }
        else if (jumpCount < 200 && jump) {
            this.bufferedImage = jump4;
        }
//        if (jumpCount % 250 == 0 && jump) {
//            this.bufferedImage = jump5;
//        }
//        if (jumpCount % 250 == 0 && jump) {
//            this.bufferedImage = jump6;
//        }
//        if (jumpCount % 300 == 0 && jump) {
//            this.bufferedImage = jump7;
//        }

    }

    private void jumpUp() {
        jump = true;
        walk = false;
        setSpeedY(JUMP_UP);
    }

    private void setSpeedY(double speedY) {
        this.speedY = speedY;
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

    @Override
    protected void incrementCount() {
        if (walk) {
            walkCount++;
            if (walkCount > maxWalkCount) {
                walkCount = 0;
            }
        } else {
            walkCount = 0;
        }

        if (jump) {
            jumpCount++;
//            if (jumpCount > maxJumpCount) {
//                jumpCount = 0;
//            }
        } else {
            jumpCount = 0;
        }

    }
}
