package collections.iterator;

import java.util.Spliterator;

/**
 * https://www.baeldung.com/java-spliterator
 *
 * {@link Spliterator} - Объект для обхода и разделения элементов источника.
 *
 * characteristics - Возвращает набор характеристик этого Spliterator и его элементов.
 * estimateSize - Возвращает оценку количества элементов, которые могут встретиться при обходе
 * forEachRemaining - Выполняет заданное действие для каждого оставшегося элемента последовательно в текущем потоке, пока все элементы не будут обработаны или действие не вызовет исключение.
 * getComparator - Если источник этого Spliterator отсортирован компаратором, возвращает этот компаратор.
 * getExactSizeIfKnown - Удобный метод, который возвращает estimationSize(), если этот Spliterator имеет размер SIZED, иначе -1
 * hasCharacteristics - Возвращает true, если характеристики этого Spliterator () содержат все заданные характеристики.
 * tryAdvance - Если оставшийся элемент существует, выполняет над ним заданное действие
 * trySplit -
 */
public class Spliterator_ {

    public static void main(String[] args) {

    }

}
