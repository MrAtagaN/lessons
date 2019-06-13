import SpringData.Config.DbConfig;
import SpringData.Config.JpaConfig;
import SpringData.Entities.Cat;
import SpringData.Repository.CatJpaRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Работа с JPA
 */
public class Main3 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class, Cat.class, CatJpaRepositoryImpl.class, DbConfig.class);

        Cat cat = new Cat("Murka", 5, "white");
        CatJpaRepositoryImpl jpaRepository = context.getBean(CatJpaRepositoryImpl.class);
        jpaRepository.saveCat(cat);
    }
}
