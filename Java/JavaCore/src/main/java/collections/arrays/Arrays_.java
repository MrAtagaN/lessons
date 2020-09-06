package collections.arrays;

import java.util.Arrays;

/**
 * https://javarush.ru/groups/posts/massivy-java
 *
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture07
 *
 * Методы {@link Arrays}:
 * asList - получить неизменяемый List из переданных элементов
 * binarySearch - поиск элемента в массиве. Массив должен быть отсортирован
 * copyOf - копия массива
 * equals - равенство массивов
 * parallelPrefix - параллельные операции над элементами массива
 * parallelSetAll - параллельное заполние массива
 * parallelSort - парралельная сортировка
 * setAll - заполние массива
 * sort - сортировка
 * stream - получить стрим
 *
 */
public class Arrays_ {

    public static void main(String[] args) {
        String[] seasons  = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        String[] seasons2  = {"Winter", "Spring", "Summer", "Autumn"};
        System.out.println(Arrays.toString(seasons));//печатаем массив "правильно"

        System.out.println(Arrays.equals(seasons, seasons2));

        int[] array = {5, 1, 4, 3, 7}; //объявляем и инициализируем массив

        Arrays.sort(array, 0, 4); //сортируем весь массив от нулевого до четвёртого члена
        System.out.println(Arrays.toString(array));//выводим отсортированный массив на экран

        int key = Arrays.binarySearch(array, 5); // ищем key - число 5 в отсортированном массиве.
        System.out.println(key);

        System.out.println(Arrays.binarySearch(array, 0));//а теперь попробуем найти число, которого в массиве нет,
    }
}
