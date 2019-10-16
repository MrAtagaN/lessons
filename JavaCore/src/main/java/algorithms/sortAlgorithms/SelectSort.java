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
        int temp;
        int index;
        for (int i = 0; i < sourceArray.length - 1; i++) {
            temp = sourceArray[i];
            index = i;
            for (int n = i + 1; n < sourceArray.length; n++) { //ищем наименьший элемент из оставшегося массива
                if (sourceArray[n] < sourceArray[i]) {
                    temp = sourceArray[n];
                    index = n;
                }
            }
            if (i != index) { //если нашли элемент меньше i-того, меняем местами элементами
                sourceArray[index] = sourceArray[i];
                sourceArray[i] = temp;
            }
        }
    }
}
