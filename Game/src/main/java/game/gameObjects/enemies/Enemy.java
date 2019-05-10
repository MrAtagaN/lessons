package game.gameObjects.enemies;

import game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    public Enemy(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight);
    }
}
