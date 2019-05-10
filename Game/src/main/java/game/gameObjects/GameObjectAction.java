package game.gameObjects;

import java.awt.image.BufferedImage;

public interface GameObjectAction {

    double getX();
    double getY();
    BufferedImage getBufferedImage();
    int getImageHeight();
    int getImageWidth();
    void updateCoordinats();

}
