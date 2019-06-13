import SpringData.Config.DbConfig;
import SpringData.Config.JpaConfig;
import SpringData.Entities.Cat;
import SpringData.Repository.CatJpaAutoRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * JPA AutoRepository
 */
public class Main4 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class, Cat.class, CatJpaAutoRepository.class, DbConfig.class);


        CatJpaAutoRepository jpaRepository = context.getBean(CatJpaAutoRepository.class);
        Cat cat = new Cat("Tom", 3, "black");
        jpaRepository.saveAndFlush(cat);

        List<Cat> cats = jpaRepository.findCatsByName("Tom");
        cats.forEach(val -> {
            System.out.println("cat = " + val);
        });

        Cat catByAge = jpaRepository.findCatByAge(3);
        System.out.println(catByAge);
    }
}
