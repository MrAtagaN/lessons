package com.plekhanov.game.gameObjects;

import com.plekhanov.game.Game;
import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;

import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private int life = 3;
    private int timeInvulnerability = 2 * (int) Game.UPDATES; // время неуязвимости после столкновения
    private int invulnerabilityCount;                        // обратный счетчик после столкновения
    private BufferedImage playerWoundedImage;
    private BufferedImage playerMoveRightImage;
    private BufferedImage playerMoveRightWoundedImage;
    private BufferedImage playerJumpImage;
    private BufferedImage playerJumpWoundedImage;
    private final int imageShiftRight = 10; //смещение картинки игрока вправо

    private boolean moveRight = false;
    private boolean moveLeft = false;

    private double MIN_X;
    private double MIN_Y;
    private double MAX_X;
    private double MAX_Y;

    private GameObject heart1;
    private GameObject heart2;
    private GameObject heart3;

    private static final double MIN_SPEED_X = 0;
    private static final double MAX_SPEED_Y = 1.7;
    private static final double GRAVITY = 3;
    private static final double GRAVITY_X = 8;
    private static final double JUMP_UP = -1.6;
    private static final double JUMP_RIGHT = 1.4;
    private static final double JUMP_LEFT = -1.4;

    private Model model;

    public Player(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);

        this.MAX_X = 1920 - imageWidth / 2 - imageShiftRight;
        this.MAX_Y = imageHeight / 2;
        this.MIN_X = imageWidth / 2 - imageShiftRight;
        this.MIN_Y = 900;
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
            model.setClash(true); //переделать
        }
        this.invulnerabilityCount = timeInvulnerability;

    }


    public void updateCoordinats() {
        if (moveRight) {
            jumpRight();
        }
        if (moveLeft) {
            jumpLeft();
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

        checkBoundariesGameField();
    }


    public BufferedImage getBufferedImage() {

        if (moveRight) {
            if (playerWounded()) {
                return playerMoveRightWoundedImage;
            } else {
                return playerMoveRightImage;
            }
        }

        if (speedY < 0) {  // игрок движется вверх
            if (playerWounded()) {
                return playerJumpWoundedImage;
            } else {
                return playerJumpImage;
            }
        }

        if (playerWounded()) {
            return playerWoundedImage;
        } else {
            return bufferedImage;
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
        return invulnerabilityCount > 0 && Math.ceil(invulnerabilityCount / 50) % 2 == 0;
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

    /**
     * Сместить картинку игрока вправо
     */
    @Override
    public double getRenderX() {
        return x - imageWidth / 2 + imageShiftRight;
    }

}
