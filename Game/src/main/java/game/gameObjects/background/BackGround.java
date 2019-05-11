package game.gameObjects.background;

import game.Game;
import game.gameObjects.GameObject;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder);
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();
        if (Math.abs(x) >= Game.WIDTH) {
            x = Game.WIDTH;
        }
    }
}
