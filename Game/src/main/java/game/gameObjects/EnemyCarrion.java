package game.gameObjects;

public class EnemyCarrion {


    private int x;
    private int y;
    private int speedX;
    private int speedY;

    public EnemyCarrion(int x, int y, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeX(int x) {
        this.x+=x;
    }

    public void updateCoordinats() {
        this.x += this.speedX;
        this.y += this.speedY;
    }
}
