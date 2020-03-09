package libs.lombok;

import lombok.Builder;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.With;

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
@Builder
public class Cat {

    @With //добавляет метод withName(String name) который делает клон объекта с одним измененныйм полем
    String name;
    int age;

    @SneakyThrows //убирает проверку исключений
    public static void main(String[] args) {
        Cat cat = Cat.builder()
                .age(12)
                .build();

        System.out.println(cat.name);

        cat = cat.withName("newName");
        System.out.println(cat.name);


        new FileReader("asda");
    }

}
