package game.gameObjects;


import java.awt.image.BufferedImage;

public class GameObject implements GameObjectAction {

    protected double x;
    protected double y;
    protected double speedX;
    protected double speedY;
    protected BufferedImage bufferedImage;
    protected int imageWidth;
    protected int imageHeight;

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

    public void setX(double x) {
        this.x = x;
    }

    public void updateCoordinats() {
        this.x += this.speedX;
        this.y += this.speedY;
    }


}
