package libs.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

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
@NoArgsConstructor(onConstructor=@__(@Autowired)) // onConstructor=@__ поставить над конструктором аннотацию
public class Person {

    String name;
    int age;
    Cat cat;

}
