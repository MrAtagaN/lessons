package game.gameObjects.enemies;

import game.Model;

import java.awt.image.BufferedImage;

public class FireBall extends Enemy {
    public FireBall(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, model);
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();


        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80 ) {
            model.setClash(true);
        }
    }
}
