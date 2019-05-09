package game.GameObjects.background;

public class Background6 {

    private int x;


    public Background6(int x) {
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
