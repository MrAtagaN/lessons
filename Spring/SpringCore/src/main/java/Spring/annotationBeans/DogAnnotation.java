package Spring.annotationBeans;

import org.springframework.stereotype.Component;

/**
 * Бин создаваемый через аннотации
 */
@Component
public class DogAnnotation {

    public DogAnnotation() {
    }

    public void say() {
        System.out.println("DogAnnotation say \"Woof-woof\"!");
    }
}
