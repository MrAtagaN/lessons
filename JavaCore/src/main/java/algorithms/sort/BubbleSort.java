package algorithms.sort;

import java.util.Arrays;

/**
 * Пузырьковая сортировка
 * Сложность алгоритма: n^2
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void bubbleSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length - 1; i++) {  //цикл по всем элементам до предпоследнего
            for(int n = i + 1; n < sourceArray.length; n++) {  //цикл по оставшимся (неотсортированнм)  элементам до последнего
                if (sourceArray[n] < sourceArray[i]) {  // Если n-ный элемент меньше, то меняем местами с i-тым
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[n];
                    sourceArray[n] = temp;
                }
            }
        }
    }
}
