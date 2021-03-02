package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * https://javarush.ru/groups/posts/2308-korotko-o-glavnom---java-collections-framework
 * https://habr.com/ru/company/luxoft/blog/256877/
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture09
 *
 * {@link Collection} - Интерфейс коллекций
 *
 * add
 * addAll
 * clear
 * contains
 * containsAll
 * isEmpty
 * parallelStream
 * remove
 * removeAll - удаляет те элементы, которые есть в передаваемой коллекции
 * removeIf - удаляет элементы которые подходят под условие
 * retainAll - оставляет только те элементы, которые есть в передаваемой коллекции
 * size
 * stream
 * toArray
 *
 */
public class Collection_ {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.removeIf((obj) -> {return obj < 2;});
        System.out.println(list);

    }
}
