
import SpringData.Config.DbConfig;
import SpringData.Entities.Address;
import SpringData.Entities.Person;
import SpringData.Repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;


/**
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
