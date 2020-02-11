package libs.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * validate - Валидация объекта
 * validateProperty - Валидация значения параметра объекта
 * validateValue - Валидация значения параметра без создания объекта
 */
public class Main {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Person person = new Person("name", 17, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        });

        Set<ConstraintViolation<Person>> violations2 = validator.validateProperty(person, "name");
        violations2.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        });

        Set<ConstraintViolation<Person>> violations3 = validator.validateValue(Person.class, "name", "aaaaa");
        violations3.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        });


        factory.close();
    }


    public static class Person {
        @NotNull
        @Pattern(regexp = "[A-Z]+")
        @Size(min = 3, max = 100)
        String name;
        @Min(18)
        int age;
        @Past
        LocalDate birthday;
        @Future
        LocalDate deathDay;

        @NotNull
        public String getName() {
            return name;
        }

        public void setName(@NotNull String name) {
            this.name = name;
        }

        public Person(@NotNull @Pattern(regexp = "[A-Za-z]+") @Size(min = 3, max = 100) String name, @Min(18) int age, @Past LocalDate birthday, @Future LocalDate deathDay) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.deathDay = deathDay;
        }
    }
}
