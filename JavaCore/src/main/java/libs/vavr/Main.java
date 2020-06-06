package libs.vavr;

import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.control.Option;
import io.vavr.control.Try;

/**
 * https://www.baeldung.com/vavr-tutorial
 */
public class Main {

    public static void main(String[] args) {
        option();
        turple2();
        turple3();
        tryClass();
        lazy();
    }



    private static void option() {
        System.out.println("\n=== option ===");

        Option<String> noneOption = Option.of(null);
        Option<String> someOption = Option.of("val");
        someOption.peek(option -> {
            System.out.println(option);
        });

        System.out.println(noneOption);
        System.out.println(someOption);
        System.out.println(noneOption.getOrElse("baeldung"));

    }


    private static void turple2() {
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        String element1 = java8._1;
        int element2 = java8._2();
    }


    private static void turple3() {
        Tuple3<String, Integer, Double> java8 = Tuple.of("Java", 8, 1.8);
        String element1 = java8._1;
        int element2 = java8._2();
        double element3 = java8._3();
    }

    private static void tryClass() {
        System.out.println("\n=== tryClass ===");

        Try<Integer> result = Try.of(() -> 1 / 0);
        System.out.println(result.isFailure());


        Try<Integer> computation = Try.of(() -> 1 / 0);
        int errorSentinel = computation.getOrElse(-1);
        System.out.println(errorSentinel);// -1
    }

    private static void lazy() {
        System.out.println("\n=== lazy ===");

        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated());

        double val1 = lazy.get();
        System.out.println(lazy.isEvaluated());

        System.out.println(val1);
    }
}
