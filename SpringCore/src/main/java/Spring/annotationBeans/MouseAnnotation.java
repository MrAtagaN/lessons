package Spring.annotationBeans;

import org.springframework.stereotype.Component;

/**
 * Бин создаваемый через xml конфиг  <context:annotation-config />
 */
@Component("Mikkie")
public class MouseAnnotation {

    public MouseAnnotation() {
    }

    public void say() {
        System.out.println("MouseAnnotation say \"i am Mikkie\"!");
    }
}
