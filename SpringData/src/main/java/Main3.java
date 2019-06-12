import SpringData.Config.DbConfig;
import SpringData.Config.JpaConfig;
import SpringData.Entities.Cat;
import SpringData.Repository.JpaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Работа с JPA
 */
public class Main3 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class, Cat.class, JpaRepository.class, DbConfig.class);

        Cat cat = new Cat("Murka", 5, "white");
        JpaRepository jpaRepository = context.getBean(JpaRepository.class);
        jpaRepository.saveCat(cat);
    }
}
