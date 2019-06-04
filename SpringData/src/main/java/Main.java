
import SpringData.Entities.Person;
import SpringData.Repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("SpringData");
        PersonRepository personRepository = context.getBean(PersonRepository.class);

        List<Person> allUsers = personRepository.getAllUsers();
        allUsers.forEach(user -> {
            System.out.println("user = " + user);
        });

    }
}
