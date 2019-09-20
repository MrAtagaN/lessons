
import SpringData.Config.DbConfig;
import SpringData.Entities.Address;
import SpringData.Entities.Person;
import SpringData.Repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;


/**
 * Доки - https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html
 * Доки - https://docs.spring.io/spring-data/jdbc/docs/1.0.10.RELEASE/reference/html/
 * Работа с JdbcTemplate
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonRepository.class, DbConfig.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);

        List<Person> allUsers = personRepository.findAllPersons();
        allUsers.forEach(user -> {
            System.out.println("person = " + user);
        });

        personRepository.insert(233, "32");

    }
}
