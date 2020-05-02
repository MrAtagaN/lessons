package core.streamAPI;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * Один параметр, возвращает результат
 * Function<T, R> {
 *   R apply(T t);
 * }
 *
 * Один параметр, не возвращает результат
 * Consumer<T> {
 *   void accept(T t);
 * }
 *
 * Один параметр, возвращает boolean
 * Predicate<T> {
 *   boolean test(T t);
 * }
 *
 * Без параметров, возвращает результат
 * Supplier<T> {
 *   T get();
 * }
 *
 *
 */
public class FunctionalInterfaces {

    Supplier supplier;
    Predicate predicate;
    Consumer consumer;
    Function function;

}
