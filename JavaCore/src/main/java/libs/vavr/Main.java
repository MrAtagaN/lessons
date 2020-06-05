package libs.vavr;

import io.vavr.control.Option;

/**
 * https://www.baeldung.com/vavr-tutorial
 */
public class Main {

    public static void main(String[] args) {
        Option<String> noneOption = Option.of(null);
        Option<String> someOption = Option.of("val");

        System.out.println(noneOption);
        System.out.println(someOption);
    }
}
