package game.gameObjects.enemies;

import game.Game;
import game.ImageLoader;
import game.Model;


import java.awt.image.BufferedImage;
import java.io.IOException;

public class EnemyHusk extends Enemy {


    private boolean alreadyShooted = false;


    public EnemyHusk(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, int renderOrder , Model model) throws IOException {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, renderOrder, model);
        countMax = Game.UPDATES * 2;
    }

    @Override
    public void updateCoordinats() {

        //поведение
        if (count < Game.UPDATES) {
            speedY = -0.05;
        } else {
            speedY = 0.05;
        }


        super.updateCoordinats();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 700 + 80));

            // убираем из модели fireBall'ы
            model.getGameObjects().forEach(gameObject -> {  if (gameObject instanceof FireBall) { model.getGameObjects().remove(gameObject);}});
        }
        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.setClash(true);
        }
        // летим и стреляем
        shoot();
        incrementCount();

    }

    private void shoot() {
        if (x < 1800 && x > 0 && count > Game.UPDATES * 1 && !alreadyShooted) {

            alreadyShooted = true;

            double diffX = model.getPlayer().getX() - x ;
            double diffY = model.getPlayer().getY() - y ;

            double reduceSpeed =  1/(Math.abs(diffX) + Math.abs(diffY));

            model.getGameObjects().add(new FireBall(getX(), getY(), diffX*reduceSpeed, diffY*reduceSpeed, ImageLoader.getFireBallImage(), 60, 60, 11, model));

            model.needToSortGameObjects();
        }
        if (count < Game.UPDATES * 1) {
            alreadyShooted = false;
        }
    }
}
