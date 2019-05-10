package game.gameObjects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage bufferedImage;
    private int imageWidth = 150;
    private int imageHeight = 130;

    private double x;
    private double y;
    private double minX = 0;
    private double minY = 810;

    private double speedX;
    private double minSpeedX = -0.5;
    private double minSpeedY = 2;
    private double speedY;
    private double gravity = 2.6;

    public Player(double x, double y, double speedX, double speedY) throws IOException {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        File playerImageFile = new File("Game\\src\\main\\resources\\images\\Player2.png");
        bufferedImage = ImageIO.read(playerImageFile);
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
        if (speedX > minSpeedX) {
            speedX += -gravity / 500;
        }
        if (x < minX) {
            speedX = 0;
        }


        this.y += speedY;
        if (speedY < minSpeedY) {
            speedY += gravity / 500;
        }

        if (y > minY) {
            speedY = 0;
        }


    }

    public void jumpRight() {
        setSpeedX(1.5);
    }

    public void jumpUp() {
        setSpeedY(-1.4);
    }
}
