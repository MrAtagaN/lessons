package core.optional;


import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * https://vk.com/@javatutorial-java-optional-ne-takoi-uzh-ochevidnyi
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();

        empty.isPresent();
        empty.orElse("asd");
        empty.orElseGet(() -> {
            return 2 + 2;
        });

        Optional<String> optionalString = Optional.of("qwe");
        optionalString.get();

        String string = null;
        Optional.ofNullable(string).filter(elem -> {
            return elem.contains("a");
        });

        OptionalInt.of(4);
        OptionalDouble.of(2.3);
        OptionalLong.of(12);




    }
}
