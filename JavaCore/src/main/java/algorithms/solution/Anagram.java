package algorithms.solution;

import java.util.HashSet;
import java.util.Set;

public class Anagram {

    public static void main(String[] args) {

        Set<String> anagrams = getAnagrams("cat");
        System.out.println(anagrams);
    }

    public static Set<String> getAnagrams(String sourceString) {
        Set<String> result = new HashSet<>();
        char[] charArray = sourceString.toCharArray();
        recursionAnagramCombinations(charArray, sourceString.length(), result);
        return result;
    }

    /**
     * для нахождения всех комбинаций
     * на первой позиции дожен побывать каждый символ, для этого делаем поворот массива
     * рекурсивно повторяем для подмассива начиная со второй позиции (подмассив от второй позиции до конца массива)
     *
     * @param charArray - строка разложенная на символы
     * @param size - размер подмассива
     * @param result - множество куда складываем полученные анаграммы
     */
    private static void recursionAnagramCombinations(char[] charArray, int size, Set<String> result) {
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (size == 1) {
                addToResultSet(charArray, result);
            }
            recursionAnagramCombinations(charArray, size - 1, result);
            rotate(charArray, size);
        }
    }

    private static void rotate(char[] charArray, int size) {
        int position = charArray.length - size;
        char temp = charArray[position];

        for (; position < charArray.length - 1; position++) {
            charArray[position] = charArray[position + 1];
        }
        charArray[charArray.length - 1] = temp;
    }

    private static void addToResultSet(char[] charArray, Set<String> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(charArray[i]);
        }
        result.add(sb.toString());
    }
}
