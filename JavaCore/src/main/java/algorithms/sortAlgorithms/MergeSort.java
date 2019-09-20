package algorithms.sortAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {3, 5, 2, 7, 1, 6, 4, 8};

        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }


    public static void mergeSort(int[] array, int startArrayIndex, int lastArrayIndex) {
        if (startArrayIndex < lastArrayIndex) {
            int middleArrayIndex = (startArrayIndex + lastArrayIndex) / 2;
            mergeSort(array, startArrayIndex, middleArrayIndex);
            mergeSort(array, middleArrayIndex + 1, lastArrayIndex);
            mergeArrays(array, startArrayIndex, middleArrayIndex, lastArrayIndex);
        }
    }

    private static void mergeArrays(int[] array, int startFirstSubarrayIndex, int lastFirstSubarrayIndex, int lastSecondSubarrayIndex) {

        int[] tempArray = new int[lastSecondSubarrayIndex - startFirstSubarrayIndex + 1];
        int tempArrayIterator = 0;

        int firstSubArrayIterator = startFirstSubarrayIndex;
        int secondSubArrayIterator = lastFirstSubarrayIndex + 1;

        while (firstSubArrayIterator <= lastFirstSubarrayIndex || secondSubArrayIterator <= lastSecondSubarrayIndex) {
            if (firstSubArrayIterator > lastFirstSubarrayIndex) {
                tempArray[tempArrayIterator++] = array[secondSubArrayIterator++];
            } else if (secondSubArrayIterator > lastSecondSubarrayIndex) {
                tempArray[tempArrayIterator++] = array[firstSubArrayIterator++];
            } else if (array[firstSubArrayIterator] < array[secondSubArrayIterator]) {
                tempArray[tempArrayIterator++] = array[firstSubArrayIterator++];
            } else {
                tempArray[tempArrayIterator++] = array[secondSubArrayIterator++];
            }
        }
        for (tempArrayIterator = 0; tempArrayIterator < tempArray.length; tempArrayIterator++) {
            array[startFirstSubarrayIndex++] = tempArray[tempArrayIterator];
        }
    }
}
