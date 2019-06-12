import SpringData.Config.DbConfig;
import SpringData.Config.HibernateConfig;
import SpringData.Entities.Cat;
import SpringData.Repository.CatRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Работа с Hibernate
 */
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class, Cat.class, CatRepository.class, DbConfig.class);
        CatRepository catRepository = context.getBean(CatRepository.class);

        Cat cat = new Cat("Tom", 3, "black");
        catRepository.saveCat(cat);
    }
}
