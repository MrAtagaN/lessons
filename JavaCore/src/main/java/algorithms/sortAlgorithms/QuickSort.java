package algorithms.sortAlgorithms;

import java.util.Arrays;

/**
 * Быстрая сортирока
 * выбираем число в середине массива (но можно любое) - это опорное число.
 * Числа которые меньше опорного числа перемещаем в левую часть, числа которые больше опорного числа в правую часть
 * рекурсивно повторяем для левой части массива (слева от порного числа) и для правой
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 6, 4, 8, 2, 9};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] sourceArray, int leftBoarder, int rightBoarder) {
        int leftMarker = leftBoarder; //элемент слева, который больше опорного
        int rightMarker = rightBoarder; //элемент справа, который меньше опорного

        int pivot = (leftBoarder + rightBoarder) / 2;

        while (leftMarker <= rightMarker) {
            while (sourceArray[leftMarker] < sourceArray[pivot]) { //ищем элемент слева, который больше опорного (leftMarker)
                leftMarker++;
            }

            while (sourceArray[rightMarker] > sourceArray[pivot]) { //ищем элемент справа, который меньше опорного (rightMarker)
                rightMarker--;
            }

            if (leftMarker < rightBoarder) { //меняем местами элементы leftMarker и rightMarker
                int temp = sourceArray[leftMarker];
                sourceArray[leftMarker] = sourceArray[rightMarker];
                sourceArray[rightMarker] = temp;
            }
            leftMarker++;
            rightMarker--;
        }

        if (leftMarker < rightBoarder) {
            quickSort(sourceArray, leftMarker, rightBoarder);
        }

        if (rightMarker > leftBoarder) {
            quickSort(sourceArray, leftBoarder, rightMarker);
        }
    }
}

