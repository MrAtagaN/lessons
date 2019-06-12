package com.plekhanov.game.gameObjects;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;

import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private int life = 3;
    private int timeInvulnerability = 2 * (int) Game.UPDATES; // время неуязвимости после столкновения
    private int invulnerabilityCount;                        // обратный счетчик после столкновения
    private static BufferedImage playerImage = ImageLoader.getPlayerImage();
    private BufferedImage playerWoundedImage;
    private BufferedImage playerMoveRightImage;
    private BufferedImage playerMoveRightWoundedImage;
    private BufferedImage playerMoveLeftImage;
    private BufferedImage playerMoveLeftWoundedImage;
    private BufferedImage playerJumpImage;
    private BufferedImage playerJumpWoundedImage;
    private static final int imageWidth = 180;
    private static final int imageHeight = 156;
    private static final int renderOrder = 100;
    private final int imageShiftRight = 10; //смещение картинки игрока вправо
    private double shootTimer;    // счетчик интервала стрельбы

    private boolean moveRight = false;
    private boolean moveLeft = false;
    private boolean shoot = false;

    private double MIN_X = 57;
    private double MIN_Y = 900;
    private double MAX_X = 1830;
    private double MAX_Y = 65;

    private GameObject heart1;
    private GameObject heart2;
    private GameObject heart3;

    private static final double MIN_SPEED_X = 0;
    private static final double MAX_SPEED_Y = 1.7;
    private static final double GRAVITY = 3;
    private static final double GRAVITY_X = 8;
    private static final double JUMP_UP = -1.6;
    private static final double JUMP_RIGHT = 1.5;
    private static final double JUMP_LEFT = -1.5;
    private static final double SHOOT_INTERVAL = 0.7;

    private Model model;

    public Player(double x, double y, double speedX, double speedY, int min_y, Model model) {
        super(x, y, speedX, speedY, playerImage, imageWidth, imageHeight, renderOrder);

        this.MIN_Y = min_y;
        this.model = model;

        heart1 = new GameObject(50, 50, 0, 0, ImageLoader.getHeartImage(), 55, 66, 90);
        model.getGameObjects().add(heart1);
        heart2 = new GameObject(120, 50, 0, 0, ImageLoader.getHeartImage(), 55, 66, 90);
        model.getGameObjects().add(heart2);
        heart3 = new GameObject(190, 50, 0, 0, ImageLoader.getHeartImage(), 55, 66, 90);
        model.getGameObjects().add(heart3);

        playerWoundedImage = ImageLoader.getPlayerWoundedImage();
        playerMoveRightImage = ImageLoader.getPlayerMoveRightImage();
        playerMoveRightWoundedImage = ImageLoader.getPlayerMoveRightWoundedImage();
        playerMoveLeftImage = ImageLoader.getPlayerMoveLeftImage();
        playerMoveLeftWoundedImage = ImageLoader.getPlayerMoveLeftWounded();
        playerJumpImage = ImageLoader.getPlayerJumpImage();
        playerJumpWoundedImage = ImageLoader.getPlayerJumpWoundedImage();
    }


    /**
     * Уменьшение жизни
     */
    public void minusLife() {
        if (invulnerabilityCount > 0) {
            return;
        }

        switch (life) {
            case 3:
                model.getGameObjects().remove(heart3);
                break;
            case 2:
                model.getGameObjects().remove(heart2);
                break;
            case 1:
                model.getGameObjects().remove(heart1);
                break;
        }

        this.life--;
        if (life <= 0) {
            model.setGameOver();
        }
        this.invulnerabilityCount = timeInvulnerability;

    }

    @Override
    public void updateCoordinates() {
        if (moveRight) {
            jumpRight();
        }
        if (moveLeft) {
            jumpLeft();
        }
        if (shoot) {
            shoot();
        }

        this.x += this.speedX;
        if (speedX > MIN_SPEED_X) {
            speedX += -GRAVITY_X / 500;
        }
        if (speedX < MIN_SPEED_X) {
            speedX -= -GRAVITY_X / 500;
        }
        if (Math.abs(speedX) < 0.1) {
            speedX = 0;
        }


        this.y += speedY;
        if (speedY < MAX_SPEED_Y) {
            speedY += GRAVITY / 500;
        }

        if (invulnerabilityCount > 0) {
            invulnerabilityCount--;
        }

        if (shootTimer > 0) {
            shootTimer--;
        }

        checkBoundariesGameField();
        setPlayerImage();
    }


    private void setPlayerImage() {
        if (moveRight) {
            if (playerWounded()) {
                bufferedImage = playerMoveRightWoundedImage;
            } else {
                bufferedImage = playerMoveRightImage;
            }
        } else if (moveLeft) {
            if (playerWounded()) {
                bufferedImage = playerMoveLeftWoundedImage;
            } else {
                bufferedImage = playerMoveLeftImage;
            }
        } else if (playerJump()) {
            if (playerWounded()) {
                bufferedImage = playerJumpWoundedImage;
            } else {
                bufferedImage = playerJumpImage;
            }
        } else if (playerWounded()) {
            bufferedImage = playerWoundedImage;
        } else {
            bufferedImage = playerImage;
        }
    }

    public void jumpRight() {
        setSpeedX(JUMP_RIGHT);
    }

    public void jumpUp() {
        setSpeedY(JUMP_UP);
    }

    public void jumpLeft() {
        setSpeedX(JUMP_LEFT);
    }

    private void checkBoundariesGameField() {
        if (x < MIN_X) {
            speedX = 0;
            x = MIN_X;
        }

        if (x > MAX_X) {
            speedX = 0;
            x = MAX_X;
        }

        if (y < MAX_Y) {
            speedY = 0;
            y = MAX_Y;
        }

        if (y > MIN_Y) {
            speedY = 0;
            y = MIN_Y;
        }
    }

    private boolean playerWounded() {
        return invulnerabilityCount > 0 && invulnerabilityCount / 50 % 2 == 0;
    }

    private boolean playerJump() {
        if (speedY < -0.8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Сместить картинку игрока вправо
     */
    @Override
    public double getRenderX() {
        return x - imageWidth / 2 + imageShiftRight;
    }

    public void shoot() {
        if (shootTimer <= 0) {
            shootTimer = Game.UPDATES * SHOOT_INTERVAL;
            model.getGameObjects().add(new PlayerShoot(getX() + 100, getY(), 2, 0, ImageLoader.getPlayerFireBallImage_1(), 200, 200, 20));
            model.needToSortGameObjects();
        }
    }

    //============ Getters, Setters =================//


    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void addLife() {
        this.life++;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }


}
