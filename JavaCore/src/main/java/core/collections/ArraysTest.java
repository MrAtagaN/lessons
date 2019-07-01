package core.collections;

import java.util.Arrays;

/**
 * https://javarush.ru/groups/posts/massivy-java
 */
public class ArraysTest {

    public static void main(String[] args) {

        String[] seasons  = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        String[] seasons2  = {"Winter", "Spring", "Summer", "Autumn"};

        int[] array = {5, 1, 4, 3, 7}; //объявляем и инициализируем массив
        System.out.println(Arrays.toString(array));//печатаем массив "правильно"

        Arrays.sort(array, 0, 4); //сортируем весь массив от нулевого до четвёртого члена
        System.out.println(Arrays.toString(array));//выводим отсортированный массив на экран

        int key = Arrays.binarySearch(array, 5); // ищем key - число 5 в отсортированном массиве.
        //метод binarySearch выдаст индекс элемента остортированного массива, в котором "спрятано" искомое число. The array must be sorted
        System.out.println(key);

        System.out.println(Arrays.binarySearch(array, 0));//а теперь попробуем найти число, которого в массиве нет,

    }
}
