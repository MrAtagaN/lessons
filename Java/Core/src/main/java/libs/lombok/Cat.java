package libs.lombok;

import lombok.*;

import java.io.FileReader;

/**
 * Value
 *
 * Equivalent to
 * @Getter
 * @FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
 * @AllArgsConstructor
 * @ToString
 * @EqualsAndHashCode
 */
@Value
@With //добавляет метод для каждого поля, который делает клон объекта с одним измененныйм полем
@Builder
public class Cat {

    String name;
    int age;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Person person;

}
