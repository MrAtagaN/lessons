package libs.lombok;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * @SneakyThrows - делает проверяемые исключения непроверяемыми
 * @Slf4j -
 * @Data
 * @FieldDefaults
 * onConstructor=@__(@Autowired) - onConstructor=@__ поставить над конструктором аннотацию
 * @Value
 * @With - добавляет метод для каждого поля, который делает клон объекта с одним измененныйм полем
 * @Builder
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        Cat cat = Cat.builder()
                .name("Мурка")
                .age(3)
                .person(person)
                .build();

        person.setName("Иван");
        person.setAge(26);
        person.setCat(cat);

        System.out.println(person);
        System.out.println(cat);
    }

    @SneakyThrows
    private static void throwException()  {
        Files.readAllBytes(Paths.get(""));
    }
}
