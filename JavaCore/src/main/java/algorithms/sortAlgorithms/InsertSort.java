package algorithms.sortAlgorithms;

import java.util.Arrays;

/**
 * Сортировка вставками
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            int insertIndex = 0;
            while (i > 0 && sourceArray[insertIndex] < sourceArray[i]) { //выбираем место для вставки
                insertIndex++;
            }
            int temp = sourceArray[i];

            for (int m = i - 1; m >= insertIndex; m--) { //делаем сдвиг массива ( часть массива от места вставки до i ( числа которое будем вставлям))
                sourceArray[m + 1] = sourceArray[m];
            }
            sourceArray[insertIndex] = temp;
        }
    }
}
