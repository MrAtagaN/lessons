
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
        ApplicationContext context = new AnnotationConfigApplicationContext("SpringData");
        PersonRepository personRepository = context.getBean(PersonRepository.class);

        List<Person> allUsers = personRepository.findAllUsers();
        allUsers.forEach(user -> {
            System.out.println("person = " + user);
        });

        Address address = new Address();
        address.setId(2);
        Person person = new Person("Mike", 34, 223132, address, new Date());

        //personRepository.createUser(person);

        System.out.println("person with id 2 = " + personRepository.findPersonById(2));

        personRepository.findUsersByName("AtagaN").forEach(person1 -> {
            System.out.println("person with name AtagaN = " + person1);
        });

    }
}
