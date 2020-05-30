package algorithms.sort;

import java.util.Arrays;

/**
 * Сортировка выбором
 * Сложность алгоритма: n^2
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9, 2, 3, 4};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] sourceArray) {
        int indexValue; //значение наименьшего элемента в оставшемся массиве
        int index; //индекс наименьшнго элемента в оставшемся массиве

        for (int i = 0; i < sourceArray.length - 1; i++) {
            indexValue = sourceArray[i];
            index = i;
            //ищем наименьший элемент из оставшегося массива
            for (int n = i + 1; n < sourceArray.length; n++) {
                if (sourceArray[n] < indexValue) {
                    indexValue = sourceArray[n];
                    index = n;
                }
            }
            //если нашли элемент меньше i-того, меняем местами элементы
            if (i != index) {
                indexValue = sourceArray[index];
                sourceArray[index] = sourceArray[i];
                sourceArray[i] = indexValue;
            }
        }
    }
}
