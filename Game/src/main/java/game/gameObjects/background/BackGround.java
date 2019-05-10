package game.gameObjects.background;

import game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight);
    }
}
