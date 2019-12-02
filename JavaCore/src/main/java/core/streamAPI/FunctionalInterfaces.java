package core.streamAPI;


/**
 * два параметра, возвращает результат
 * BiFunction<T, U,R> {
 *   R apply(T t, U u);
 * }
 *
 * два параметра, не возвращает результат
 * BiConsumer<T,U>  {
 *   void  accept(T t, U u)
 * }
 *
 * один параметр, возвращает результат
 * Function<T, R> {
 *   R apply(T t);
 * }
 *
 * один параметр, не возвращает результат
 * Consumer<T> {
 *   void accept(T t);
 * }
 *
 * Без параметров, возвращает результат
 * Supplier<T> {
 *   T get();
 * }
 *
 */
public class FunctionalInterfaces {
}
