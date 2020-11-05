package algorithms.solution;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindow {

    public static void main(String[] args) {
        System.out.println(minimumWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minimumWindow("A", "AA")); // ""
    }

    /**
     * Метод возвращает минимальную подстроку из s где содержатся все символы из строки t
     * если такой подстрои нет возвоащает пустую строку
     */
    public static String minimumWindow(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        String minWin = "";
        for (int l = 0; l < charsS.length; l++) {
            for (int r = l; r < charsS.length; r++) {
                char[] subArray = getSubArray(charsS, l, r);
                if (containsChars(subArray, charsT)) {
                    if (minWin.equals("") || subArray.length < minWin.length()) {
                        minWin = new String(subArray);
                    }
                    r--;
                    l++;
                }
            }
        }
        return minWin;
    }

    private static boolean containsChars(char[] subArray, char[] targetArray) {
        List<Character> list = new ArrayList<>();
        for (char c : subArray) {
            list.add(c);
        }
        for (char c : targetArray) {
            if (!list.contains(c)) {
                return false;
            } else {
                list.remove(new Character(c));
            }
        }
        return true;
    }

    private static char[] getSubArray(char[] charsS, int l, int r) {
        char[] subArray = new char[r - l + 1];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = charsS[l++];
        }
        return subArray;
    }
}
