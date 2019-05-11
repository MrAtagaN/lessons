package game.gameObjects;

import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private static final double MIN_X = 0;
    private static final double MIN_Y = 810;
    private double MAX_X;
    private static final double MAX_Y = 0;

    private static final double MIN_SPEED_X = 0;
    private static final double MAX_SPEED_Y = 1.8;
    private static final double GRAVITY = 3.8;
    private static final double JUMP_UP = -1.7;

    public Player(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
        this.MAX_X = 1920 - imageWidth;
    }


    public BufferedImage getBufferedImage() {
        return bufferedImage;
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

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void updateCoordinats() {

        this.x += this.speedX;
        if (speedX > MIN_SPEED_X) {
            speedX += -GRAVITY / 500;
        }
        if (speedX < MIN_SPEED_X) {
            speedX -= -GRAVITY / 500;
        }
        if (Math.abs(speedX) < 0.1) {
            speedX = 0;
        }


        this.y += speedY;
        if (speedY < MAX_SPEED_Y) {
            speedY += GRAVITY / 500;
        }

        checkBoundariesGameField();
    }

    public void jumpRight() {
        setSpeedX(1.5);
    }

    public void jumpUp() {
        setSpeedY(JUMP_UP);
    }

    public void jumpLeft() {
        setSpeedX(-1.5);
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
}
