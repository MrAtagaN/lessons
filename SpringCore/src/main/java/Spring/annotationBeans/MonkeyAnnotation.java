package Spring.annotationBeans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MonkeyAnnotation {
    @Value("5")
    private int age;

    public MonkeyAnnotation() {
    }

    public MonkeyAnnotation(int age) {
        this.age = age;
    }

    public void say() {
        System.out.println("MonkeyAnnotation is " + age +"!");
    }


}
