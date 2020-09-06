package algorithms.sort;

import java.util.Arrays;

/**
 * Сортировка вставками
 * Сложность алгоритма: n^2
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9, 2, 3, 4};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            int insertIndex = i;

            //Выбираем место для вставки. От 0-го до i-го элемента
            //Ищем элемент с бОльшим либо с таким же
            //значением что у i-го элемента
            for (int n = 0; n < i; n++) {
                if (sourceArray[n] >= sourceArray[i]) {
                    insertIndex = n;
                    break;
                }
            }

            if (insertIndex != i) {
                int temp = sourceArray[i];
                //делаем сдвиг массива ( часть массива от места вставки до i ( числа которое будем вставлям))
                for (int m = i; m > insertIndex; m--) {
                    sourceArray[m] = sourceArray[m - 1];
                }
                sourceArray[insertIndex] = temp;
            }

        }
    }
}
