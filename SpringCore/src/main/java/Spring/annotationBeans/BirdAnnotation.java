package Spring.annotationBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BirdAnnotation {
    public BirdAnnotation() {
    }
    @Bean
    public static BirdAnnotation getBird() {
        return new BirdAnnotation();
    }

    public void say() {
        System.out.println("BirdAnnotation say \"chick-chirik\"!");
    }
}