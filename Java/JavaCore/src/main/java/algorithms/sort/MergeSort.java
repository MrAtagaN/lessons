package algorithms.sort;

import java.util.Arrays;

/**
 * Сортировка слиянием
 *
 * Рекурсивно делим массив пополам, когда доходим до длинны массива 1, начинаем соединять массивы,
 * соединённый массив в отсорьтрованном порядке
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9, 2, 3, 4};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] sourceArray, int startArrayIndex, int lastArrayIndex) {
        if (startArrayIndex < lastArrayIndex) {
            int middleArrayIndex = (startArrayIndex + lastArrayIndex) / 2;
            mergeSort(sourceArray, startArrayIndex, middleArrayIndex);
            mergeSort(sourceArray, middleArrayIndex + 1, lastArrayIndex);
            mergeArrays(sourceArray, startArrayIndex, middleArrayIndex, lastArrayIndex);
        }
    }

    private static void mergeArrays(int[] sourceArray, int startIndexFirstArray, int lastIndexFirstArray, int lastIndexSecondArray) {

        int[] tempArray = new int[lastIndexSecondArray - startIndexFirstArray + 1];
        int tempArrayIndex = 0;

        int firstArrayIndex = startIndexFirstArray;
        int secondArrayIndex = lastIndexFirstArray + 1;

        while (firstArrayIndex <= lastIndexFirstArray || secondArrayIndex <= lastIndexSecondArray) {
            if (firstArrayIndex > lastIndexFirstArray) {
                tempArray[tempArrayIndex++] = sourceArray[secondArrayIndex++];
            } else if (secondArrayIndex > lastIndexSecondArray) {
                tempArray[tempArrayIndex++] = sourceArray[firstArrayIndex++];
            } else if (sourceArray[firstArrayIndex] < sourceArray[secondArrayIndex]) {
                tempArray[tempArrayIndex++] = sourceArray[firstArrayIndex++];
            } else {
                tempArray[tempArrayIndex++] = sourceArray[secondArrayIndex++];
            }
        }
        for (tempArrayIndex = 0; tempArrayIndex < tempArray.length; tempArrayIndex++) {
            sourceArray[startIndexFirstArray++] = tempArray[tempArrayIndex];
        }
    }
}
