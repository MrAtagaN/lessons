package core.collections.set;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * NavigableSet
 */
public class NavigableSetTest {

    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);


        treeSet.descendingSet(); // развернутый сет

        treeSet.ceiling(3); // ближайший элемент в большую сторону
        treeSet.floor(6); // ближайший элемент в меньшую сторону
        treeSet.higher(3); // строго больший элемент
        treeSet.lower(3); // строго меньший элемен

        treeSet.pollFirst(); // убирает первый элемент
        treeSet.pollLast(); // убирает последний элемент

        treeSet.subSet(3, false, 5, false); // возвращает часть сета
        treeSet.headSet(3, false); // возвращает сет идущий до определенного числа
        treeSet.tailSet(3, false); // возвращает сет идущий после определенного числа
    }
}
