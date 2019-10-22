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
        for (int i = 1; i < sourceArray.length; i++) {
            int insertIndex = 0;
            while (sourceArray[insertIndex] < sourceArray[i]) { //Выбираем место для вставки. От 0-го до i-го элемента
                insertIndex++;                                  //Ищем элемент с бОльшим либо с таким же
            }                                                   //значением что у i-го элемента
            int temp = sourceArray[i];

            for (int m = i - 1; m >= insertIndex; m--) { //делаем сдвиг массива ( часть массива от места вставки до i ( числа которое будем вставлям))
                sourceArray[m + 1] = sourceArray[m];
            }
            sourceArray[insertIndex] = temp;
        }
    }
}
