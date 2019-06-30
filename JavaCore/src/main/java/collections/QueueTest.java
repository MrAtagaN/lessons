package collections;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * Методы {@link Queue}
 */
public class QueueTest {

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
