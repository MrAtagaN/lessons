package game.gameObjects.background;

public class Background5 {
    private int x;


    public Background5(int x) {
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
