package game.gameObjects.background;

public class Background7 {
    private int x;


    public Background7(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void changeX(int x) {
        this.x+=x;
    }
}
