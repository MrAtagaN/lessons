package game.gameObjects;

import java.awt.image.BufferedImage;

public class EnemyPestilence extends GameObject{

    public EnemyPestilence(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight);
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 700 + 20));
        }
    }
}
