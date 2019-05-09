package game.GameObjects;

public class Player {
    private int speedX;
    private int speedY;
    private int x;
    private int y;

    public Player(int speedX, int speedY, int x, int y) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.x = x;
        this.y = y;
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
