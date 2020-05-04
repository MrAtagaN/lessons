package Spring.annotationBeans;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


@Component
public class FishAnnotation {

    private int speed;
    public FishAnnotation() {
    }

    @PostConstruct
    public void init() {
        speed = 13;
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
