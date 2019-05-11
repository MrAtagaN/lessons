package game.gameObjects;


import java.awt.image.BufferedImage;

public class GameObject implements Comparable{

    protected double x;
    protected double y;
    protected double speedX;
    protected double speedY;
    protected BufferedImage bufferedImage;
    protected int imageWidth;
    protected int imageHeight;
    protected int renderOrder;

    public GameObject(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.bufferedImage = bufferedImage;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.renderOrder = renderOrder;
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

    public int getRenderOrder() {
        return renderOrder;
    }

    public void setRenderOrder(int renderOrder) {
        this.renderOrder = renderOrder;
    }

    public void updateCoordinats() {
        this.x += this.speedX;
        this.y += this.speedY;
    }

    @Override
    public int compareTo(Object o) {
        GameObject gameObject = (GameObject) o;
        if (this.renderOrder > gameObject.getRenderOrder()) {
            return 1;
        }
        if (this.renderOrder < gameObject.getRenderOrder()) {
            return -1;
        }
        return 0;
    }
}
