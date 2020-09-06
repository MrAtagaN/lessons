package core.streamAPI;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * {@link Function} - Принимает один аргумент, возвращает результат
 *
 * {@link Consumer} - Принимает один аргумент, не возвращает результат
 *
 * {@link Predicate} - Принимает один аргумент, возвращает boolean
 *
 * {@link Supplier} - Не нринимает аргументов, возвращает результат
 *
 *
 */
public class FunctionalInterfaces {

    Supplier supplier;
    Predicate predicate;
    Consumer consumer;
    Function function;

}
