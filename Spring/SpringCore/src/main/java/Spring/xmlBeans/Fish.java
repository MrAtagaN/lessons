package Spring.xmlBeans;

/**
 * Created by AtagaN on 27.08.2018.
 */
public class Fish {

    private int speed;
    public Fish() {
    }

    public void say() {
        System.out.println("Fish speed is " + speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
