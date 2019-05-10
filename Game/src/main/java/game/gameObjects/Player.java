package game.gameObjects;

public class Player {

    private int x;
    private int y;
    private int speedX;
    private int speedY;

    public Player(int x, int y, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
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

    public void changeY(int y) {
        this.y+=y;
    }

    public void updateCoordinats() {
        this.x += this.speedX;
        this.y += this.speedY;
    }
}
