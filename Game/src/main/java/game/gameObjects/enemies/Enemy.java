package game.gameObjects.enemies;

import game.Game;
import game.Model;
import game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

    protected double countMax; //цикл действий
    protected double count;

    Model model;
    public Enemy(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
        this.model = model;
    }

    protected void incrementCount() {
        count++;
        if (count > countMax) {
            count = 0;
        }
    }
}
