package libs.lombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

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

    String name;
    int age;
    Cat cat;

}
