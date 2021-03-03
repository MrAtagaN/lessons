package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * {@link Iterator} -
 *
 * Методы {@link Iterator}:
 * hasNext - Возвращает true, если итерация содержит больше элементов.
 * next - Возвращает следующий элемент в итерации.
 * forEachRemaining - Выполняет заданное действие для каждого оставшегося элемента до тех пор, пока все элементы не будут обработаны или действие не вызовет исключение.
 *
 *
 * {@link ListIterator} - итератор у {@link List} который расширяет {@link Iterator}
 *
 * Методы {@link ListIterator}:
 * hasPrevious -
 * previous -
 * nextIndex -
 * previousIndex -
 * set -
 * add -
 */
public class Iterator_ {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();

        //list.add(4);//ConcurrentModificationException
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
        }

        ListIterator<Integer> listIterator = list.listIterator();
        //list.add(4);//ConcurrentModificationException
        while (listIterator.hasNext()) {
            Integer elem = listIterator.next();
            listIterator.add(5);
        }
        System.out.println(list);
    }

}

