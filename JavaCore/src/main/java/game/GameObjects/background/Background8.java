package game.GameObjects.background;

public class Background8 {

    private int x;


    public Background8(int x) {
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
