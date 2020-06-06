package libs.vavr;

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
    }



    private static void option() {
        Option<String> noneOption = Option.of(null);
        Option<String> someOption = Option.of("val");

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
        Try<Integer> result = Try.of(() -> 1 / 0);

        System.out.println(result.isFailure());
    }
}
