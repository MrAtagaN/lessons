package libs.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Data

 * Equivalent to
 * @Getter
 * @Setter
 * @RequiredArgsConstructor - конструктор для final полей
 * @ToString
 * @EqualsAndHashCode
 */
@Data
/**
 * chain - сеттеры возвращают текущий объект
 * fluent - геттеры и сеттеры без get и set
 * prefix -
 */
@Accessors(chain = true, fluent = false)
public class Person {

    private final String name;
    private int age;


    public static void main(String[] args) {
        Person person = new Person("sadad");
        person.setAge(30);
        person.getName();

        Cat cat = Cat.builder()
                .name("asdsad")
                .age(12)
                .build();

    }
}
