import SpringData.Entities.Cat;
import SpringData.Repository.CatRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("SpringData");
        CatRepository catRepository = context.getBean(CatRepository.class);

        Cat cat = new Cat("Tom", 3, "black");
        catRepository.saveCat(cat);
    }
}
