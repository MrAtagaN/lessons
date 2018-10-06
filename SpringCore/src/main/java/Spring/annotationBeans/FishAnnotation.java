package Spring.annotationBeans;

import org.springframework.stereotype.Component;

@Component
public class FishAnnotation {

    private int speed;
    public FishAnnotation() {
    }

    public void say() {
        System.out.println("FishAnnotation speed is " + speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
