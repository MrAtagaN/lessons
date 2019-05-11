package game.gameObjects.enemies;

import game.Model;
import game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

    Model model;
    public Enemy(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
        this.model = model;
    }
}
