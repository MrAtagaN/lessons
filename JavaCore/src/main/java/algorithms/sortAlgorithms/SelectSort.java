package algorithms.sortAlgorithms;

import java.util.Arrays;

/**
 * Сортировка выбором
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length - 1; i++) {
            int temp = sourceArray[i];
            int index = i;
            for (int n = i + 1; n < sourceArray.length; n++) {
                if (sourceArray[n] < temp) {
                    temp = sourceArray[n];
                    index = n;
                }
            }
            if (i != index) {
                sourceArray[index] = sourceArray[i];
                sourceArray[i] = temp;
            }
        }
    }
}
