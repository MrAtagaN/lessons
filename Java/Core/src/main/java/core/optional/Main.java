package core.optional;


import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * https://vk.com/@javatutorial-java-optional-ne-takoi-uzh-ochevidnyi
 *
 *
 * Статические методы {@link Optional}:
 *
 * Создание:
 * empty - создает Optional c значением null
 * of - создает Optional c переданным значением, не равным null
 * ofNullable - создает Optional c переданным значением
 *
 *
 * Методы {@link Optional}:
 *
 * Получение:
 * get - возвращает результат, или кидает ошибку
 * orElse - возвращает результат, или значение по умолчанию
 * orElseGet - возвращает результат, результат функции
 * orElseThrow - возвращает результат, или кидает ошибку
 *
 * Действия:
 * isPresent - проверка на null
 * filter - фильтрует по предикату
 * map - преобразует по функции
 * flatMap - преобразует по функции. Функция должна оборачивать результат в Optional
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //создание
        Optional<Object> empty = Optional.empty();
        Optional<String> optionalString = Optional.of("qwe");
        OptionalInt.of(4);
        OptionalDouble.of(2.3);
        OptionalLong.of(12);
        Optional.ofNullable(null);


        //получение
        optionalString.get();
        empty.orElse("asd");
        empty.orElseGet(() -> {
            return 2 + 2;
        });
        optionalString.orElseThrow(() -> {
            return new Exception();
        });


        //действия
        empty.isPresent();
        empty.filter(elem -> {
            return ((String) elem).contains("a");
        });

        optionalString.map((elem) -> {return elem + elem;});
        optionalString.flatMap((elem) -> {return Optional.of(elem + elem); });

    }
}
