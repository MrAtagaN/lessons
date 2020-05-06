package libs.lombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

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
/**
 * level - изменить модификаторы полей
 * makeFinal - сделать поля final
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Person {

    private final String name;
    @ToString.Exclude
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
