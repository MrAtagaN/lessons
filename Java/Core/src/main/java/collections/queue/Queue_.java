package collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Методы {@link Queue}
 *
 * element -
 * peek -
 *
 * poll -
 * remove -
 *
 * add -
 * offer -
 *
 */
public class Queue_ {

    @SuppressWarnings(value = {"all"})
    public static void main(String[] args) {
        Queue arrayDeque = new ArrayDeque();

        arrayDeque.element(); //Retrieves, but does not remove,  NoSuchElementException if this queue is empty
        arrayDeque.peek(); //Retrieves, but does not remove

        arrayDeque.poll(); //Retrieves and removes the head element
        arrayDeque.remove(); //Retrieves and removes the head element,  NoSuchElementException if this queue is empty

        arrayDeque.add(new Object()); //Inserts element,  throwing an {@code IllegalStateException} if no space is currently available
        arrayDeque.offer(new Object()); // Inserts element
    }
}
