package game.gameObjects.enemies;

import game.Model;
import game.gameObjects.enemies.Enemy;

import java.awt.image.BufferedImage;

public class EnemyHusk extends Enemy {


    public EnemyHusk(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, Model model) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, model);
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();
        if (x <= -300) {
            x =((int) (Math.random() * 500 + 2000));
            y =((int) (Math.random() * 700 + 20));
        }
        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80 ) {
            model.setClash(true);
        }

    }
}
