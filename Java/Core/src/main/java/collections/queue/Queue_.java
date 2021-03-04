package collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Реализации {@link Queue}: PriorityQueue, LinkedList, ArrayDeque
 * Потокобезопасные реализации {@link Queue}:ArrayBlockingQueue, LinkedTransferQueue PriorityBlockingQueue, LinkedBlockingQueue, SynchronousQueue
 *
 * Методы {@link Queue}:
 *
 * element - Извлекает, но не удаляет заголовок этой очереди, или кидает Exception
 * peek - Извлекает, но не удаляет заголовок этой очереди, или возвращает null, если эта очередь пуста.
 *
 * remove - Извлекает и удаляет заголовок этой очереди, или кидает Exception
 * poll - Извлекает и удаляет заголовок этой очереди или возвращает null, если эта очередь пуста.
 *
 * add - Вставляет указанный элемент в эту очередь, если это возможно сделать немедленно, не нарушая ограничений емкости  или генерирует исключение IllegalStateException
 * offer - Вставляет указанный элемент в эту очередь, если это возможно сделать немедленно, не нарушая ограничений емкости
 *
 */
public class Queue_ {

    @SuppressWarnings(value = {"all"})
    public static void main(String[] args) {
        Queue arrayDeque = new ArrayDeque();

        arrayDeque.element();
        arrayDeque.peek();

        arrayDeque.poll();
        arrayDeque.remove();

        arrayDeque.add(new Object());
        arrayDeque.offer(new Object());
    }
}
