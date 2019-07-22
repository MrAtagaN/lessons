package core.generics.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Наследование типов в дженериках не работает
 * Если при создании объекта не задан дженерик, то дженерики не работают
 */
public class SomeType<T> {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("SomeValue");

        SomeType<?> someType2 = new SomeType();
        someType2.test(list); // Дженерики работают

        SomeType someType = new SomeType();
        someType.test(list); // ClassCastException, потому что SomeType<T> не задан, дженерики не будут работать
    }


    public <E> void test(Collection<E> collection) {
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test(List<Integer> list) {
        for (Integer integer: list) {
            System.out.println(integer);
        }
    }

}
