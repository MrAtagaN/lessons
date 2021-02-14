package core.streamAPI;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Для создания своего коллектора нужно заимплементить интерфейс {@link Collector}
 *
 * T – тип который возможен в коллекции
 * A – тип временного объекта в который будет накапливаться элементы
 * R – тип контейнера с результатом
 *
 * supplier -
 * accumulator -
 * combiner -
 * finisher -
 * characteristics -
 */
public class CustomCollector<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        return (x) -> x;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }

    public static <T> CustomCollector<T> toCustomSet() {
        return new CustomCollector<>();
    }


    /**
     * Example of work
     */
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dddd");

        Set<String> result = givenList.stream()
                .collect(toCustomSet());

    }
}
