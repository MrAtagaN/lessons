package Spring.annotationBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Бин созданный через аннотации фабричным методом
 */
@Configuration
public class TigerAnnotation {

    public TigerAnnotation() {
    }

    @Bean
    public static TigerAnnotation getTiger() {
        System.out.println("create TigerAnnotation");
        return new TigerAnnotation();
    }

    public void say() {
        System.out.println("Tiger say \"RRrrrRRrrr\"!");
    }
}
