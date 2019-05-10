package game.gameObjects;

import game.gameObjects.GameObjectAction;

import java.awt.image.BufferedImage;

public class GameObject implements GameObjectAction {

    private double x;
    private double y;
    private double speedX;
    private double speedY;
    private BufferedImage bufferedImage;
    private int imageWidth;
    private int imageHeight;

    public GameObject(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.bufferedImage = bufferedImage;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void updateCoordinats() {
        this.x += this.speedX;
        this.y += this.speedY;
    }

}
