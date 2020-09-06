package collections.queue.impl;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * {@link PriorityQueue}
 *
 * Сортирует элементы в очереди
 */
public class PriorityQueue_ {

    public static void main(String[] args) {
        // сначала идут нечетные числа, потом четные
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1 % 2 == 0) {
                if (o2 % 2 == 0) {
                    return o1 - o2;
                }
                return 1;
            }
            if (o2 % 2 == 0) {
                return -1;
            }
            return o1 - o2;
        });

        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        queue.forEach(System.out::println);
    }
}
