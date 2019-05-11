package game.gameObjects.enemies;

import game.Model;


import java.awt.image.BufferedImage;

public class EnemyHusk extends Enemy {

    private int fireBallsCount = 4;

    private BufferedImage fireBallImage;

    public EnemyHusk(double x, double y, double speedX, double speedY, BufferedImage bufferedImage, int imageWidth, int imageHeight, Model model, BufferedImage fireBallImage) {
        super(x, y, speedX, speedY, bufferedImage, imageWidth, imageHeight, model);
        this.fireBallImage = fireBallImage;
    }

    @Override
    public void updateCoordinats() {
        super.updateCoordinats();
        if (x <= -300) {
            x = ((int) (Math.random() * 500 + 2000));
            y = ((int) (Math.random() * 700 + 20));
            fireBallsCount = 4;
            // убираем из модели fireBall'ы
            model.getGameObjects().forEach(gameObject -> {  if (gameObject instanceof FireBall) { model.getGameObjects().remove(gameObject);}});
        }
        //проверка столкновения
        if (Math.abs(model.getPlayer().getX() - getX()) < 80 && Math.abs(model.getPlayer().getY() - getY()) < 80) {
            model.setClash(true);
        }
        // летим и стреляем
        if (x < 1600 && fireBallsCount == 4 || x < 1200 && fireBallsCount == 3 || x < 800 && fireBallsCount == 2 || x < 400 && fireBallsCount == 1) {
            fireBallsCount--;

            double triangle;
            double diffX = model.getPlayer().getX() - x;
            double diffY = model.getPlayer().getY() - y;

            double fireBallSpeedY = 0;
            double fireBallSpeedX = 0;

            if(Math.abs(diffY) < Math.abs(diffX)) {
                triangle = Math.abs(diffY/diffX);
                fireBallSpeedY = triangle * 1;
                fireBallSpeedX = 1 - fireBallSpeedY;
            } else {
                triangle = Math.abs(diffX/diffY);
                fireBallSpeedX = triangle * 1;
                fireBallSpeedY = 1 - fireBallSpeedX;
            }

            if (diffX <= 0 && diffY <= 0) {
                fireBallSpeedY = fireBallSpeedY;
                fireBallSpeedX = fireBallSpeedX;
            }



            model.getGameObjects().add(new FireBall(getX(), getY(), -fireBallSpeedX, fireBallSpeedY, fireBallImage, 60, 60, model));
        }

    }
}
